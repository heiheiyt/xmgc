/*
package com.gem.xmgc.service;


import com.gem.xmgc.XmgcApplicationTests;
import com.gem.xmgc.entity.Clazz;
import com.gem.xmgc.entity.NewClassDetail;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class ClazzServiceImplTest extends XmgcApplicationTests {
    Clazz clazz=new Clazz();

    @Test
    public void createClazz() {
        clazz.setAddTime(LocalDateTime.now());
        clazz.setCId("Java");
        clazz.setMId(1L);
        clazz.setStaatDate(LocalDateTime.now());
        clazz.setStartYear("1994");
        clazz.setTId(1L);
        clazz.setUpTime(LocalDateTime.now());
        clazz.setTypeId(1L);
       Boolean a= clazzService.createClazz(clazz);
        System.out.println(a);
    }

    @Test
    public void removeClazz() {

        clazzService.removeClazz(1L);
    }

    @Test
    public void editClazz() {
        clazz.setId(1L);
        clazz.setCId("TPJAVA");
        clazz.setMId(2L);
        clazz.setStartYear("1956");
        clazz.setTId(2L);
        clazz.setTypeId(2L);
        clazzService.editClazz(clazz);

    }


    @Test
    public void findClazzByTeacherId() {
        clazzService.findClazzByTeacherId(1L,1).getRecords().forEach(System.out::println);
    }

    @Test
    public void findClazzByManageId() {
        clazzService.findClazzById(1L,1).getRecords().forEach(System.out::println);
    }

    @Test
    public void fingClazzByYear() {
        clazzService.findAllClazzByYear("2019",1,null,null)
                .getRecords().forEach(System.out::println);
    }
NewClassDetail newClassDetail=new NewClassDetail();
    @Test
    public void createClassTest() {
        newClassDetail.setCid(1L);
        newClassDetail.setDate(LocalDate.now());
        newClassDetail.setThing(1L);
        clazzService.createClassTest(newClassDetail);
    }

    @Test
    public void editClassTest() {
        newClassDetail.setId(1L);
        newClassDetail.setCid(15L);
        newClassDetail.setDate(LocalDate.now());
        newClassDetail.setThing(17L);
        clazzService.editClassTest(newClassDetail);
    }

    @Test
    public void removeClassTest() {
        clazzService.removeClassTest(1L);
    }

    @Test
    public void findClassTestBySubjectAndName() {
        clazzService.findClassTestBySubjectAndName(65L,null,1).getRecords().forEach(System.out::println);
    }

}
*/
