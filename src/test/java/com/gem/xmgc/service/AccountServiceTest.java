
package com.gem.xmgc.service;

import com.gem.xmgc.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;




import com.gem.xmgc.entity.*;
import com.gem.xmgc.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;


/**
 * @author 张开
 * @date 2019/10/24 10:05
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {
    @Autowired
    AccountService accountService;
    @Test
    public void createTeacher() {
        Teacher teacher = new Teacher();
        teacher.setTName("lalala");
        accountService.createTeacher(teacher);
    }

    @Test
    public void createManage() {
    }

    @Test
    public void findManageByName() {
        accountService.findManageByName("xiaokai").getRecords().forEach(System.out::println);
    }

    @Test
    public void createAccount() {
        AccountAll accountAll = new AccountAll();
        accountAll.setMName("lll");
        accountService.createAccount(accountAll);
    }

    @Test
    public void createEmailcc() {
        Emailcc emailcc  = new Emailcc();
        emailcc.setUsername("xiao新");
        emailcc.setEmail("djlfsdf@qq.com");
        accountService.createEmailcc(emailcc);
    }

   /* @Test

 public void findAllEmailcc() {
        accountService.findAllEmailcc().getRecords().forEach(System.out::println);
    }*/


    @Test
    public void findEmailccByName() {
        accountService.findEmailccByName("于艳红").getRecords().forEach(System.out::println);
    }

    @Test
    public void removeEmailccById() {
        accountService.removeEmailccById(1);
    }

    @Test
    public void editEmailcc() {
        Emailcc emailcc = new Emailcc();
        emailcc.setId(2);
        emailcc.setUsername("lala");
        accountService.editEmailcc(emailcc);
    }

    @Test
    public void findAcount() {
       accountService.findAcount("jiaowu","lalala").getRecords().forEach(System.out::println);
    }

    @Test
    public void editAccount() {
        Manage manage = new Manage();
        manage.setMName("xiaokai");
        manage.setId(1L);
        accountService.editAccount("manage",manage);
    }

    @Test
    public void removeAccount() {
        accountService.removeAccount("null",00000000001);
    }







}

