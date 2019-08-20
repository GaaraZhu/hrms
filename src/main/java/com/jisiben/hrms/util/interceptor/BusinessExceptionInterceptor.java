package com.jisiben.hrms.util.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

@Component
public class BusinessExceptionInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation target) throws Throwable {
        System.out.println("Enter HandleExceptionInterceptor");
        Object result = null;
        try {
            result = target.proceed();
        } catch (Throwable e) {
            System.out.println("Begin Handle exception");
            System.out.println(ExceptionUtils.getStackTrace(e));
        }

        System.out.println("Exit HandleExceptionInterceptor");

        return result;
    }

}