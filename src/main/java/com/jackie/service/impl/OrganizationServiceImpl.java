package com.jackie.service.impl;

import com.jackie.dao.OrganizationMapper;
import com.jackie.model.Organization;
import com.jackie.service.OrganizationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jackie on 2016/3/23.
 */
@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService {
    @Resource
    private OrganizationMapper OrganizationDao;

    @Override
    public List<Organization> selectByName(String unitName) {
        return OrganizationDao.selectByName(unitName);
    }

    @Override
    public Organization selectByPrimaryKey(String id) {
        return OrganizationDao.selectByPrimaryKey(id);
    }


    public List<String> selectPrecodeByName(String unitName) {
        return OrganizationDao.selectPrecodeByName(unitName);
    }

    public List<Organization> selectByNameAndPrecode(String unitName, String precode) {
        return OrganizationDao.selectByNameAndPrecode(unitName, precode);
    }

//    @Override
//    public List<Organization> selectAll() {
//        return OrganizationDao.selectAll();
//    }
}
