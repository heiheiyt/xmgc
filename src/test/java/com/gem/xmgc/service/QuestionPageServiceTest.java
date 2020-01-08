/*
package com.gem.xmgc.service;

import com.gem.xmgc.entity.SearchItem;
import com.gem.xmgc.entity.SearchUseInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

*/
/**
 * @author 张开
 * @date 2019/10/24 18:43
 *//*

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionPageServiceTest {
@Autowired
QuestionPageService questionPageService;
    @Test
    public void uploadQuestionPage() {
        SearchItem s1 = new SearchItem();
        s1.setSelectA("B");
        SearchItem s2 = new SearchItem();
        s2.setSelectA("B");
        SearchItem s3 = new SearchItem();
        s3.setSelectA("B");
        List<SearchItem> items = new ArrayList<>();
        items.add(s1);
        items.add(s2);
        items.add(s3);
        questionPageService.uploadQuestionPage("zhangkai",items);
    }


    @Test
    public void createQuestionPage() {
        SearchUseInfo searchUseInfo = new SearchUseInfo();
        searchUseInfo.setCid(1l);
        questionPageService.createQuestionPage(searchUseInfo);
    }

    @Test
    public void findAllQuestionPage() {
        questionPageService.findAllQuestionPage().getRecords().forEach(System.out::println);
    }

    @Test
    public void findQuestionPageByClassName() {
    }

    @Test
    public void findQuestionPageById() {
    }

    @Test
    public void editQuestionPage() {
    }

    @Test
    public void removeQuestionPage() {
    }

    @Test
    public void fingQuestionitem() {
        questionPageService.fingQuestionitem("第一次满意度调查问卷").getRecords().forEach(System.out::println);
    }

    @Test
    public void editQuestionItem() {
    }

    @Test
    public void removeQuestionItem() {
    }
}*/
