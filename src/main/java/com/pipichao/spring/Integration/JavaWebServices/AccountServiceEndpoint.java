package com.pipichao.spring.Integration.JavaWebServices;

import com.pipichao.spring.Integration.SpringHTTPInvoker.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebMethod;
import javax.jws.WebService;

//@WebService(serviceName = "AccountService")
//@Configuration
public class AccountServiceEndpoint extends SpringBeanAutowiringSupport {
    @Autowired(required = true)
    private AccountService biz;



    @WebMethod
    public void insertAccount(Account acc) {
        biz.insertAccount(acc);
    }

    @WebMethod
    public Account[] getAccounts(String name) {
        return biz.getAccounts(name);
    }

}
