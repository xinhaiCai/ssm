package com.jackie.controller;

import com.alibaba.fastjson.JSON;
import com.jackie.model.Organization;
import com.jackie.service.OrganizationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackie on 2016/3/13.
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController {
    private Logger logger = Logger.getLogger(OrganizationController.class);

    @Autowired
    public OrganizationService organizationService;

    public String test() {
        return "hello";
    }

    @RequestMapping("/query")
    public String querySchoolRelation() {
        return "organization_query";
    }

    /**
     * 查询unitName1是否为unitName2的子校
     *
     * @param unitName1 子校名称
     * @param unitName2 父校名称
     * @param model
     * @return 包含查询结果的视图
     */
    @RequestMapping(value = "/querySchool", method = RequestMethod.GET
            , produces = "text/plain;charset=UTF-8")
    public String Query(@RequestParam("unitName1") String unitName1,
                        @RequestParam("unitName2") String unitName2, Model model) {
        long startTime = System.currentTimeMillis();
        //根据父校名称找到所有该名称的前缀编码precode
        List<String> precode_list = organizationService.selectPrecodeByName(unitName2);
        long endTime1 = System.currentTimeMillis();
        logger.info("找父学校前缀编码花了：" + (endTime1 - startTime) + "ms");
        List<List<Organization>> childSchoolList = new ArrayList<List<Organization>>();
        //对每个前缀编码
        //子查询 使用索引模糊匹配 'precode%' 查找
        //父查询 返回每个子校名称为输入名称的详细信息
        for (String s : precode_list) {
            List<Organization> list = organizationService.selectByNameAndPrecode(unitName1, s);
            if (!list.isEmpty()) {
                childSchoolList.add(list);
            }
        }
        long endTime2 = System.currentTimeMillis();
        logger.info("找子学校花了：" + (endTime2 - endTime1) + "ms");
        String jsonString = null;
        logger.info("查到对应关系的子学校有" + childSchoolList.size() + "个");
        if (!childSchoolList.isEmpty()) {
            logger.debug("有转化成json字串");
            jsonString = JSON.toJSONString(childSchoolList);
        }
        long endTime3 = System.currentTimeMillis();
        logger.info("转为json花了：" + (endTime3 - endTime2) + "ms");
        model.addAttribute("unitName1", unitName1);
        model.addAttribute("unitName2", unitName2);
        model.addAttribute("result", jsonString);
        return "organization_query_result";
    }
}
