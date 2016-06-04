package com.jackie.interceptor;

/**
 * Created by jackie on 2016/5/20.
 */

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

public class MethodTimeInterceptor implements MethodInterceptor {//环绕切面

    private Logger logger = Logger.getLogger(MethodTimeInterceptor.class);

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object value = null;
        String targetName = invocation.getThis().getClass().getName();
        String methodName = invocation.getMethod().getName();
        long startTime = System.currentTimeMillis();
        // 让被调用方法先执行
        value = invocation.proceed();
        long endTime = System.currentTimeMillis();
        logger.info(targetName + "_" + methodName + "运行时间：" + (endTime - startTime) + "ms");
        return value;
    }
}
