package com.gem.xmgc.service;



import com.gem.xmgc.XmgcApplicationTests;

import com.gem.xmgc.entity.TitleList;
import com.gem.xmgc.entity.UsePaper;
import org.junit.Test;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.time.LocalDate;

/**
 * @author yt
 * @date 2019/10/24 9:24
 */
public class PaperServiceImplTest extends XmgcApplicationTests {

    @Test
    public void findAllPaperTest(){
        IPage<UsePaper> iPage = paperService.findAllPaper(1);
       iPage.getRecords().forEach(System.out::println);
        System.out.println(iPage.getSize());
    }
    @Test
    public void findPaperByClassIdTest(){
        IPage<UsePaper> iPage = paperService.findPaperByClassId(null,1);
        iPage.getRecords().forEach(System.out::println);
    }
    @Test
    public void findPaperByDateAndName(){
        System.out.println(LocalDate.parse("2018-08-03"));
        IPage<UsePaper> iPage = paperService.findPaperByDateAndName(22L, "2018-08-03",null,1);
        iPage.getRecords().forEach(System.out::println);
    }
    @Test
    public void editPaper(){
        UsePaper usePaper = new UsePaper();
        usePaper.setId(1L);
        usePaper.setPId(1L);
        System.out.println(paperService.editPaper(usePaper));
    }
    @Test
    public void editTitleList(){

        TitleList titlelist = new TitleList();
        titlelist.setId(1L);
        titlelist.setQuestion("高博应诺");
        System.out.println(paperService.editTitleList(titlelist));

    }
    @Test
    public void findTitleListById(){
        IPage<TitleList> iPage = paperService.findTitleListById(86L,2);
        iPage.getRecords().forEach(System.out::println);
    }
    @Test
    public void removePaperDetailById(){
        System.out.println(paperService.removePaperDetailById(1L,3L));
    }

    @Test
    public void findAllPaperinfoByClassId(){
        paperService.findAllPaperinfoByClassId(22L,1).getRecords().forEach(System.out::println);
    }
}
