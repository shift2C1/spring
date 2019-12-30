package com.pipichao.spring.Integration.SpringHTTPInvoker;

import com.pipichao.spring.Integration.JavaWebServices.Account;

public interface AccountService {


    public void insertAccount(Account acc) ;


    public Account[] getAccounts(String name) ;
}
