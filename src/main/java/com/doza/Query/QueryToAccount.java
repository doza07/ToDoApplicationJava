package com.doza.Query;

import com.doza.dao.AccountDao;
import com.doza.entity.account.Account;
import com.doza.generator.GeneratorAccount;

public class QueryToAccount {

    public static void findAllAccount() {
        System.out.println("Method findAllPerson");
        var accountDao = AccountDao.getInstance().findAllAccount();
        for (Account account : accountDao) {
            System.out.println(account.toString());
        }
    }

    public static void CreateTenAccount() {
        GeneratorAccount generatorPerson = new GeneratorAccount();
    }
}
