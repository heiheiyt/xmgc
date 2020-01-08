/*
package com.gem.xmgc.service;

import com.gem.xmgc.entity.Discipline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

*/
/**
 * @author 张开
 * @date 2019/11/9 10:08
 *//*

@RunWith(SpringRunner.class)
@SpringBootTest
public class APITest {
    @Test
    public  void function(){
        String url = "http://10.40.2.16:8888/xmgc/crm";
        RestTemplate restTemplate = new RestTemplate();
        Discipline discipline = new Discipline();
        discipline.setId(1L);
        discipline.setCreateTime(new Date());
        discipline.setRemarks("连接");
        String list = restTemplate.postForObject(url,String.class);
        System.out.println(list);
    }
}
*/
