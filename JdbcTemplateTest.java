package com.itheima.one;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        JdbcTemplate jdbcTemplate= (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        String sql="create table account(id int primary key auto_increment,username varchar(25),balance double)";
        jdbcTemplate.execute(sql);
        System.out.println("create account finish");


    }
    @Test
    public void  addAccountTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        AccountDao accountDao= (AccountDao) applicationContext.getBean("AccountDao");
        Account account=new Account();
        account.setUsername("123");
        account.setBalance(100.0);
        int num=accountDao.addAccount(account);
        if(num>0){
            System.out.println("insert ok");
        }
    }
    @Test
    public void  updateAccountTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        AccountDao accountDao= (AccountDao) applicationContext.getBean("AccountDao");
        Account account=new Account();
        account.setId(1);
        account.setUsername("331");
        account.setBalance(230.0);
        int num=accountDao.updateAccount(account);
        if(num>0){
            System.out.println("update ok");
        }
    }
    @Test
    public void  deleteAccountTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        AccountDao accountDao= (AccountDao) applicationContext.getBean("AccountDao");

        int num=accountDao.deleteAccount(1);
        if(num>0){
            System.out.println("delete ok");
        }
    }
    @Test
    public void  queryAccountTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        AccountDao accountDao= (AccountDao) applicationContext.getBean("AccountDao");
        Account account=new Account();
        account=accountDao.findAccountById(2);
        System.out.println(account);
        List<Account> x = accountDao.findAllAccount();
        for (Account a:x)
        {
            System.out.println(a);
        }
    }
}
