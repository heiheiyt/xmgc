/*
package com.gem.xmgc.service;

import com.gem.xmgc.XmgcApplicationTests;
import com.gem.xmgc.entity.FirstLevel;
import com.gem.xmgc.entity.SecondLevel;
import com.gem.xmgc.entity.SubjectContent;
import com.gem.xmgc.entity.SubjectType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SubjectTypeServiceImplTest extends XmgcApplicationTests {

    SubjectType subjectType=new SubjectType();
    @Test
    public void createSubject() {
        subjectType.setTypeName("军哥最帅");
        subjectType.setStatu(0L);
        subjectTypeService.createSubject(subjectType);
    }

    @Test
    public void removeSubject() {
        subjectTypeService.removeSubject(1);
    }

    @Test
    public void editSubject() {
        subjectType.setId(2L);
        subjectType.setTypeName("H6");
        subjectTypeService.editSubject(subjectType);
    }

    @Test
    public void findAllSubject() {
        subjectTypeService.findAllSubject().forEach(System.out::println);
    }

    @Test
    public void findSubjectByName() {
        System.out.println(subjectTypeService.findSubjectByName("H6"));
    }

    @Test
    public void createFirstLevel() {
        FirstLevel firstLevel=new FirstLevel();
        firstLevel.setTypeId(1L);
        firstLevel.setFirstName("怎样像军哥一样优秀");
        firstLevel.setStatu(0L);
        subjectTypeService.createFirstLevel(firstLevel);
    }

    @Test
    public void findFirstAll() {
        subjectTypeService.findFirstAll(1,25L);
    }

    @Test
    public void editFirstLevel() {
        FirstLevel firstLevel =new FirstLevel();
        firstLevel.setId(28L);
        firstLevel.setFirstName("军哥为啥这么帅");
        firstLevel.setTypeId(3L);
        subjectTypeService.editFirstLevel(firstLevel);
    }

    @Test
    public void removeFirstLevelById() {
        subjectTypeService.removeFirstLevelById(28L);
    }

    @Test
    public void createSecondLevel() {
        subjectTypeService.createSecondLevel(1L,"军哥最帅");
    }

    @Test
    public void findSecondAll() {
        subjectTypeService.findSecondAll(1L,1);
    }

    @Test
    public void editSecondtLevel() {
        SecondLevel secondLevel=new SecondLevel();
        secondLevel.setFId(1L);
        secondLevel.setSName("炸裂");
        secondLevel.setStatu(0L);
        secondLevel.setId(102L);
        subjectTypeService.editSecondtLevel(secondLevel);
    }

    @Test
    public void removeSecondLevelById() {
        subjectTypeService.removeSecondLevelById(102L);
    }
    SubjectContent subjectContent=new SubjectContent();
    @Test
    public void createSubjectTest() {
        subjectContent.setSubjectid(1L);
        subjectContent.setThing(1L);
        subjectContent.setType(1L);
        subjectTypeService.createSubjectTest(subjectContent);
    }

    @Test
    public void editSubjectTest() {
        subjectContent.setThing(3L);
        subjectContent.setSubjectid(3L);
        subjectContent.setId(69L);
        subjectContent.setType(2L);
        subjectTypeService.editSubjectTest(subjectContent);
    }

    @Test
    public void removeSubjectTest() {
        subjectTypeService.removeSubjectTest(69L);
    }

    @Test
    public void findSubjectTestBySubject() {
        subjectTypeService.findSubjectTestBySubject(1L,0).getRecords().forEach(System.out::println);
    }
}*/
