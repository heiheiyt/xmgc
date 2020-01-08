/*
package com.gem.xmgc.service;

import com.gem.xmgc.XmgcApplicationTests;
import com.gem.xmgc.entity.ScoreObject;
import com.gem.xmgc.entity.SubjectCheck;
import com.gem.xmgc.entity.Submission;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * @author jiowww
 * @data 2019/10/25.
 *//*

public class ScoreServiceTest extends XmgcApplicationTests{
    //第几页
    Integer current = 1;
    @Test
    public void findAllScore() {
        scoreServiceImpl.findAllScore(20L,1).getRecords().forEach(System.out::println);
        //scoreServiceImpl.findAllScore(43L,1).forEach(System.out::println);
    }

//    @Test
//    public void findScore() {
//        List<ScoreObject> list = scoreServiceImpl.findScore(2286L,1).getRecords();
//        list.forEach(System.out::println);
//
//
//    }

//    @Test
//    public void findScores() {
//        Long id = 25L;
//        String name = "";
//        String pName = "";
//        List<ScoreObject> list = scoreServiceImpl.findScores(id,name,pName,current).getRecords();
//        list.forEach(System.out::println);
//    }

    @Test
    public void findAllWrittenAndIntervie() {
        Long id = 43L;
        String sName = "陈0";
        scoreServiceImpl.findAllWrittenAndIntervie(id,sName).getRecords().forEach(System.out::println);
    }

    @Test
    public void editWrittenAndIntervie() {
        Long id = 1L;
        scoreServiceImpl.editWrittenAndIntervie(id,80.0,80.0);
    }

    @Test
    public void findAllResult() {
        scoreServiceImpl.findAllResult(3L,1).getRecords().forEach(System.out::println);
    }

   */
/* @Test
    public void findAllScoreObject() {
        String stuName = "";
        String fScore= "1";
        String wScore = "1";
        String underCheck = "1";
        String onlineCheck = "1";
        String piResumeIsok = "1";
        String piComprehensiveQuality = "A";
        scoreServiceImpl.findAllScoreObject(stuName,fScore,wScore,underCheck,onlineCheck,piResumeIsok,piComprehensiveQuality,current).getRecords().forEach(System.out::println);
    }*//*


    @Test
    public void findAllSubjectCheckByCondition() {
        String subtype = "";
        String year = "";
        Long cId = 42L;
        scoreServiceImpl.findAllSubjectCheckByCondition(subtype,year,cId,current).getRecords().forEach(System.out::println);
    }

    @Test
    public void findAllSubjectCheckById() {
        System.out.println(scoreServiceImpl.findAllSubjectCheckById(1L));;
    }

    @Test
    public void editSubjectCheckById() {
        SubjectCheck subjectCheck = new SubjectCheck();
        subjectCheck.setId(1L);
        subjectCheck.setOnlineCheck(Submission.SUBMISSION);
        scoreServiceImpl.editSubjectCheckById(subjectCheck);
    }

}*/
