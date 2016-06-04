package service.impl;

import com.jackie.service.RedisService;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TestRedisServiceImpl Tester.
 *
 * @author jackie
 * @version 1.0
 * @since 5 20, 2016
 */
//指定bean注入的配置文件
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-mybatis.xml"})
//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRedisServiceImpl {
    @Autowired
    private RedisService redisService;
    private Logger logger = Logger.getLogger(TestRedisServiceImpl.class);

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getTimestamp(String param)
     */
    @Test
    public void testGetTimestamp() throws Exception {
        String time1 = redisService.getTimestamp("param");
        logger.debug("第一次调用：" + time1);
        Thread.sleep(2000);
        String time2 = redisService.getTimestamp("param");
        logger.debug("2秒之后调用：" + time2);
        Assert.assertTrue(time1.equals(time2));
        Thread.sleep(11000);
        String time3 = redisService.getTimestamp("param");
        Assert.assertFalse(time1.equals(time3));
        logger.debug("再过11秒之后调用：" + time3);
    }


} 
