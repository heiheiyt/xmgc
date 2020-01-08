package com.gem.xmgc;

import com.gem.xmgc.mapper.PaperDetailMapper;
import com.gem.xmgc.mapper.UsePaperMapper;
import com.gem.xmgc.service.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XmgcApplicationTests {
    @Autowired
    public UsePaperMapper usePaperMapper;
    @Autowired
    public PaperService paperService;
    @Autowired
    public PaperDetailMapper paperDetailMapper;
    @Autowired
    public TaskService taskService;

    @Autowired
    public RecruitStudentTestService recruitStudentTestService;
    @Autowired
    public ClazzServiceImpl clazzService;
    @Autowired
    public SubjectTypeService subjectTypeService;

    @Autowired
    public StudentService studentService;
    @Autowired
    public ScoreService scoreServiceImpl;
}
