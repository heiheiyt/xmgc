/*
package com.gem.xmgc.service;

import com.gem.xmgc.XmgcApplicationTests;
import com.gem.xmgc.entity.RecruitDetail;
import com.gem.xmgc.entity.UseRecruit;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RecruitStudentTestServiceTest extends XmgcApplicationTests {

    @Test
    public void findAllRecruitStudentTest() {
        recruitStudentTestService.findAllRecruitStudentTest(1).getRecords().forEach(System.out::println);
    }

    @Test
    public void editRecruitStudentTest() {
        UseRecruit useRecruit=new UseRecruit();
        useRecruit.setEndDate(LocalDateTime.now());
        useRecruit.setRecruitinfoId(1L);
        useRecruit.setId(1L);
        useRecruit.setStatu(0);
        useRecruit.setRemarks("动次打次");
        useRecruit.setStartDate(LocalDateTime.now());
        useRecruit.setUserecruitName("滴滴");
        recruitStudentTestService.editRecruitStudentTest(useRecruit);
    }

    @Test
    public void findRecruitStudentItemByName() {
        recruitStudentTestService.findRecruitStudentItemByName(1,1L).getRecords().forEach(System.out::println);

    }

    @Test
    public void recruitStudentItemById() {
        System.out.println(recruitStudentTestService.recruitStudentItemById(1L));
    }

    @Test
    public void createUseRecruit() {
        UseRecruit useRecruit=new UseRecruit();
        useRecruit.setUserecruitName("召唤师峡谷");
        useRecruit.setStartDate(LocalDateTime.now());
        useRecruit.setStatu(1);
        useRecruit.setRemarks("???");
        useRecruit.setEndDate(LocalDateTime.now());
        useRecruit.setRecruitinfoId(1L);
        recruitStudentTestService.createUseRecruit(useRecruit);
    }

    @Test
    public void editRecruitDetail() {
        recruitStudentTestService.findRecruitDetailById(1L);
    }
	 @Test
    public void uploadRecruitStudentItem() {
        RecruitDetail r1 = new RecruitDetail();
        r1.setQuestion("sfjsdlkfad");
        r1.setAnswer("a");
        RecruitDetail r2 = new RecruitDetail();
        r2.setQuestion("sfjsdlkfad");
        r2.setAnswer("a");
        RecruitDetail r3 = new RecruitDetail();
        r3.setQuestion("sfjsdlkfad");
        r3.setAnswer("a");
        List<RecruitDetail> items = new ArrayList<>();
        items.add(r1);
        items.add(r2);
        items.add(r3);
        recruitStudentTestService.uploadRecruitStudentItem("第一次招生试卷",items);
    }
}*/
