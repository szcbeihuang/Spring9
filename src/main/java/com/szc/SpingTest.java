package com.szc;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SpingTest {
//    @Test
//    public  void TestJdbcTemplate() {//已经创建
//        ApplicationContext applicationContext = new
//                ClassPathXmlApplicationContext("applicationContext.xml");
//        JdbcTemplate jdTemplate =
//                (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
//        jdTemplate.execute("create table account(" +
//                "id int primary key auto_increment," +
//                "username varchar(50)," +
//                "balance double)");
//        System.out.println("账户表account创建成功！");
//    }
    @Test
    public  void TestAddAccount() {
        ApplicationContext applicationContext =new
                ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao =
                (AccountDao) applicationContext.getBean("accountDao");
        Account account = new Account();
        account.setUsername("xxl");
        account.setBalance(10000.00);
        int num = accountDao.addAccount(account);
        if (num > 0) {
            System.out.println("成功插入了" + num + "条数据！");
        } else {
            System.out.println("插入操作执行失败！");
        }
    }
    @Test
    public void TestDeleteAccount(){
            ApplicationContext applicationContext =new
                    ClassPathXmlApplicationContext("applicationContext.xml");
            AccountDao accountDao =
                    (AccountDao) applicationContext.getBean("accountDao");
            int num = accountDao.deleteAccount(6);
            if (num > 0) {
                System.out.println("成功删除了" + num + "条数据！");
            } else {
                System.out.println("删除操作执行失败！");
            }
    }
    @Test
    public  void TestUpdateAccount() {
        ApplicationContext applicationContext =new
                ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao =
                (AccountDao) applicationContext.getBean("accountDao");
        Account account = new Account();
        Account account2 = new Account();
        account.setId(1);
        account.setUsername("szc");
        account.setBalance(20000.00);
        account2.setId(2);
        account2.setUsername("tom");
        account2.setBalance(10000.00);
        int num = accountDao.updateAccount(account);
        int num1 = accountDao.updateAccount(account2);
        if (num > 0 && num1 > 0) {
            System.out.println("成功修改了" + (num+num1) + "条数据！");
        } else {
            System.out.println("修改操作执行失败！");
        }
    }
    @Test
    public  void FindAccountByIdTest() {
        ApplicationContext applicationContext =new
                ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao =
                (AccountDao) applicationContext.getBean("accountDao");
        Account account = accountDao.findAccountById(1);
        System.out.println(account);
    }
    @Test
    public  void FindAllAccountTest() {
        ApplicationContext applicationContext =new
                ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao =
                (AccountDao) applicationContext.getBean("accountDao");
        List<Account> account = accountDao.findAllAccount();
        for (Account act : account) {
            System.out.println(act);
        }
    }
    @Test
    public  void TransactionTest() {
        ApplicationContext applicationContext =new
                ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao =
                (AccountDao)applicationContext.getBean("accountDao");
        accountDao.transfer("szc", "xxl", 100.0);
        System.out.println("转账成功！");
    }
    @Test
    public  void AnnotationTest() {
        ApplicationContext applicationContext =new
                ClassPathXmlApplicationContext("applicationContext-annotation.xml");
        AccountDao accountDao =
                (AccountDao)applicationContext.getBean("accountDao");
        accountDao.transfer("xxl", "szc", 100.0);
        System.out.println("转账成功！");
    }
}