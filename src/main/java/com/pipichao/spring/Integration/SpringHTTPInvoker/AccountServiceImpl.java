package com.pipichao.spring.Integration.SpringHTTPInvoker;

import com.pipichao.spring.Integration.JavaWebServices.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService {
    @Override
    public void insertAccount(Account acc) {
        System.out.println("insertAccount");
    }

    @Override
    public Account[] getAccounts(String name) {
        System.out.println("getAccounts");
        return new Account[0];
    }
}
