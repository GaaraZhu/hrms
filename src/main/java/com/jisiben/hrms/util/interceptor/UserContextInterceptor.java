package com.jisiben.hrms.util.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class UserContextInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation paramMethodInvocation)
            throws Throwable {
        System.out.println("Enter UserInfoInterceptor");

        Object result = paramMethodInvocation.proceed();

        System.out.println("Exit UserInfoInterceptor");

        return result;
    }

}