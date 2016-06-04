package service.impl;

import com.jackie.model.Organization;
import com.jackie.service.OrganizationService;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by jackie on 2016/3/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-mybatis.xml"})

public class TestOrganizationServiceImpl {
    private static Logger logger = Logger.getLogger(TestOrganizationServiceImpl.class);
//      private ApplicationContext ac = null;

    @Resource
    private OrganizationService organizationService = null;

//  @Before
//  public void before() {
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//      userService = (UserService) ac.getBean("userService");
//  }

    @Test
    public void test1() {
        Organization organization = organizationService.selectByPrimaryKey("001");
        Assert.assertEquals("Seewo智慧学校", organization.getUnitName());
    }
}
