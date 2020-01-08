package com.gem.xmgc.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.xmgc.entity.*;
import com.gem.xmgc.mapper.*;
import com.gem.xmgc.util.ObjIsNotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 学生服务类
 * @author jiowww
 * @data 2019/10/24
 */
@Service
public class StudentService {


    //注入StudentDetailMapper
    @Autowired
    StudentDetailMapper studentDetailMapper;
    //注入DisciplineMapper
    @Autowired
    DisciplineMapper disciplineMapper;
    //注入StudentMapper
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    WrittenIntervieMapper writtenlntervieMapper;

    @Autowired
    ClazzMapper clazzMapper;

    @Autowired
    StudentEmploymentMapper studentEmploymentMapper;

    @Autowired
    StudentViewMapper studentViewMapper;

    @Autowired
    WrittenInterviewViewMapper writtenInterviewViewMapper;

    @Autowired
    SubjectCheckMapper subjectCheckMapper;

    //每页多少条记录
    Integer size = 5;

    //(就业信息)

    /**
     * 通过班级id和姓名查询就业信息(学生)
     * @param CId 班级id
     * @return 就业信息记录
     */
    public List<StudentEmployment> findAllWorkDetailsById(Long CId){
        //分页对象
        QueryWrapper<Clazz> qc = Wrappers.query();
        qc.select("c_id");
        qc.eq(ObjIsNotEmpty.isNotEmpty(CId),"id",CId);
        String sEmploymentClassName = null;
        Clazz clazz = clazzMapper.selectOne(qc);
        if (clazz != null){
            sEmploymentClassName = clazz.getCId();
        }
        QueryWrapper<StudentEmployment> queryWrapper = Wrappers.query();
        //过滤条件班级和name(学生)
        queryWrapper.eq(StringUtils.isNotEmpty(sEmploymentClassName),"s_employment_class_name", sEmploymentClassName);
        return studentEmploymentMapper.selectList(queryWrapper);
    }


    /**
     * 通过班级id和姓名查询就业信息(学生)
     * @param CId 班级id
     * @param sEmploymentName 学生姓名
     * @param current 第几页
     * @return 就业信息记录
     */
    public IPage<StudentEmployment> findWorkDetailsByIdAndName(Long CId,String sEmploymentName,Integer current){
        //分页对象
        QueryWrapper<Clazz> qc = Wrappers.query();
        qc.select("c_id");
        qc.eq("id",CId);
        String sEmploymentClassName = null;
        Clazz clazz = clazzMapper.selectOne(qc);
        if (clazz != null){
            sEmploymentClassName = clazz.getCId();
        }
        Page<StudentEmployment> page = new Page<>(current,size);
        QueryWrapper<StudentEmployment> queryWrapper = Wrappers.query();
        //过滤条件班级和name(学生)
        queryWrapper.eq(StringUtils.isNotEmpty(sEmploymentClassName),"s_employment_class_name", sEmploymentClassName).eq(StringUtils.isNotEmpty(sEmploymentName),"s_employment_name", sEmploymentName);
        return studentEmploymentMapper.selectPage(page,queryWrapper);
    }



    /**
     * 通过班级id和姓名查询就业信息(学生)
     * @param sEmploymentId 学生id
     * @param sEmploymentName 学生姓名
     * @param current 第几页
     * @return 就业信息记录
     *//*
    *//*public IPage<WorkDetail> findWorkDetailsByIdAndName(Long sEmploymentId,String sEmploymentName,String sEmploymentClassName,Integer current){
        //分页对象
        Page<WorkDetail> page = new Page<>(current,size);
        QueryWrapper<WorkDetail> queryWrapper = Wrappers.query();
        //过滤条件id(学生)和name(学生)
        queryWrapper.eq("sEmploymentId", sEmploymentId).eq("sEmploymentName", sEmploymentName).eq(StringUtils.isNotEmpty(sEmploymentClassName),"s_employment_class_name",sEmploymentClassName);
        return workDetailMapper.selectPage(page,queryWrapper);
    }*//*

    *//**
     * 就业信息
     * @param name 学生姓名
     * @param id 班级id
     * @return 就业信息记录
     *//*
//    public List<WorkDetail> findAllStudents(String name, Long id){
//        return null;
//    }*/


    //学生
    /**
     * 通过学生id查询学生
     * @param id 学生id
     * @return 单条学生记录
     */
    public StudentView findStudentById(Long id){
        //根据学生id查询一个学生对象
        return studentViewMapper.selectById(id);
    }


    /**
     * 通过id删除学生
     * @param id 学生id
     * @return 是否成功
     */
    public boolean removeStudentById(Long id){
        //用id删除一个学生对象
        int result = studentMapper.deleteById(id);
        return true;
    }

    /**
     * 修改学生
     * @param student 学生对象
     * @return 是否成功
     */
    public boolean editStudent(StudentView student){
        //根据所传对象的id值修改对应的记录
        int result = studentViewMapper.updateById(student);
        return true;
    }

    /**
     * 查询所有学生
     * @param cId 班级id
     * @return 多条学生记录(不分页)
     */
    public IPage<StudentView> findAllStudentByCId(Long cId,Integer current,String studentName){
        Page<StudentView> page = new Page<>(current,size);
        QueryWrapper<StudentView> queryWrapper = Wrappers.query();
        //过滤条件c_id(班级id)
        queryWrapper.eq(ObjIsNotEmpty.isNotEmpty(cId),"c_id",cId).eq(StringUtils.isNotEmpty(studentName),"s_name",studentName);
        return studentViewMapper.selectPage(page,queryWrapper);
    }

    /**
     * 查询所有学生
     * @param cId 班级id
     * @return 多条学生记录(不分页)
     */
    public List<StudentView> findAllStudent(Long cId){
        QueryWrapper<StudentView> queryWrapper = Wrappers.query();
        //过滤条件c_id(班级id)
        queryWrapper.eq(ObjIsNotEmpty.isNotEmpty(cId),"c_id",cId);
        return studentViewMapper.selectList(queryWrapper);
    }
    /**
     * 查询所有学生
     * @param cId 班级id
     * @return 多条学生记录(不分页)
     */
    public List<StudentView> findAllStudentNameByCId(Long cId){
        QueryWrapper<StudentView> queryWrapper = Wrappers.query();
        queryWrapper.select("id","s_name").eq(ObjIsNotEmpty.isNotEmpty(cId),"c_id",cId);
        return studentViewMapper.selectList(queryWrapper);
    }



    /**
     * 添加一个学生
     * @param student 学生对象
     * @return 是否成功
     */
    public boolean createStudent(StudentView student){
        student.setStatu(0);
        //创建学生对象的时候绑定一条线上线下成绩
        int result = studentViewMapper.insert(student);
        WrittenInterviewView wi = new WrittenInterviewView();
        wi.setSId(student.getId());
        writtenInterviewViewMapper.insert(wi);
        return false;
    }

    /**
     * 添加多个学生
     * @param students 学生对象集合
     * @return 是否成功
     */
    public boolean createStudents(List<StudentView> students,Long CId){
        //创建学生对象的时候绑定一条线上线下成绩
        WrittenInterviewView wi = new WrittenInterviewView();
        SubjectCheck sc = new SubjectCheck();
        //遍历学生集合
        for (StudentView student:students){
            student.setStatu(0);
            //将遍历到的每个学生插入数据库
            student.setCid(CId);
            studentViewMapper.insert(student);
            wi.setSId(student.getId());
            sc.setSId(student.getId());
            subjectCheckMapper.insert(sc);
            writtenInterviewViewMapper.insert(wi);
        }
        return false;
    }

    /**
     * 通过多个id批量删除学生
     * @param ids 多个id
     * @return 是否成功
     */
    public boolean removeStudents(List<Long> ids){
        studentMapper.deleteBatchIds(ids);
        return false;
    }



    /**
     * 通过学生id查询学生
     * @param id 学生id
     * @return 单条学生记录
     *//*
    public Student findStudentById(Long id){
        //根据学生id查询一个学生对象
        return studentMapper.selectById(id);
    }

    *//**
     * 通过姓名查询学生
     * @param sName 学生姓名
     * @param current 第几页
     * @param cId 班级id
     * @return 多条学生记录
     *//*
    public IPage<Student> findStudentsByCIdAndName(String sName,Long cId,Integer current){
        Page<Student> page = new Page<>(current,size);
        //条件过滤s_name和c_id
        QueryWrapper<Student> queryWrapper = Wrappers.query();
        queryWrapper.eq(StringUtils.isNotEmpty(sName),"s_name",sName).eq("c_id",cId);
        IPage<Student> iPage = studentMapper.selectPage(page,queryWrapper);
        return iPage;
    }

    *//**
     * 通过id删除学生
     * @param id 学生id
     * @return 是否成功
     *//*
    public boolean removeStudentById(Long id){
        //用id删除一个学生对象
        int result = studentMapper.deleteById(id);
        return true;
    }

    *//**
     * 修改学生
     * @param student 学生对象
     * @return 是否成功
     *//*
    public boolean editStudent(Student student){
        //根据所传对象的id值修改对应的记录
        int result = studentMapper.updateById(student);
        return true;
    }

    *//**
     * 添加一个学生
     * @param student 学生对象
     * @return 是否成功
     *//*
    public boolean createStudent(Student student){
        //创建学生对象的时候绑定一条线上线下成绩
        int result = studentMapper.insert(student);
        WrittenIntervie wi = new WrittenIntervie();
        wi.setSid(student.getId());
        writtenlntervieMapper.insert(wi);
        return false;
    }

    *//**
     * 添加多个学生
     * @param students 学生对象集合
     * @return 是否成功
     *//*
    public boolean createStudents(List<Student> students){
        //创建学生对象的时候绑定一条线上线下成绩
        WrittenIntervie wi = new WrittenIntervie();
        //遍历学生集合
        for (Student student:students){
            //将遍历到的每个学生插入数据库
            studentMapper.insert(student);
            wi.setSid(student.getId());
            writtenlntervieMapper.insert(wi);
        }
        return false;
    }

    *//**
     * 通过多个id批量删除学生
     * @param ids 多个id
     * @return 是否成功
     *//*
    public boolean removeStudents(List<Long> ids){
        studentMapper.deleteBatchIds(ids);
        return false;
    }*/
    //(学生档案)


    /**
     * 通过姓名或者班级id查询学生档案
     * @param c_id 班级id
     * @return 多条学生档案记录
     */
    public List<StudentDetail> findStudentDetailByCId(Long c_id){
        QueryWrapper<StudentDetail> queryWrapper = Wrappers.query();
        queryWrapper.eq(ObjIsNotEmpty.isNotEmpty(c_id),"sd.c_id",c_id);
        return studentDetailMapper.findAllStudentDetails(queryWrapper);
    }


    /**
     * 通过姓名或者班级id查询学生档案
     * @param c_id 班级id
     * @param cName 学生姓名
     * @return 多条学生档案记录
     */
    public IPage<StudentDetail> findStudentDetailByIdOrName(Long c_id, String cName,Integer current){
        Page<StudentDetail> page = new Page<>(current,size);
        QueryWrapper<StudentDetail> queryWrapper = Wrappers.query();
        queryWrapper.eq(ObjIsNotEmpty.isNotEmpty(c_id),"c_id",c_id).eq(StringUtils.isNotEmpty(cName),"c_name",cName).orderByDesc("id");
        return studentDetailMapper.selectPage(page,queryWrapper);
    }

    /**
     * 创建一个学生档案
     * @param studentDetail 学生档案对象
     * @return 是否成功
     */
    public boolean createStudentDetail(StudentDetail studentDetail){
        studentDetail.setStatu(0);
        studentDetailMapper.insert(studentDetail);
        return true;
    }

    /**
     * 上传多个学生档案
     * @param studentDetails 多个学生档案对象
     * @return 是都成功
     */
    public boolean uploadStudentDetails(List<StudentDetail> studentDetails,Long cid){
        for (StudentDetail sd:studentDetails) {
            sd.setCid(cid);
            sd.setStatu(0);
            studentDetailMapper.insert(sd);
        }
        return true;
    }

    /**
     * 通过id删除学生档案
     * @param id 档案id
     * @return 是否成功
     */
    public boolean removeStudentDetail(Long id){
        studentDetailMapper.deleteById(id);
        return true;
    }

    /**
     * 通过多个id批量删除学生档案
     * @param ids 多个档案id
     * @return 是否成功
     */
    public boolean removeStudentDetails(List<Long> ids){
        studentDetailMapper.deleteBatchIds(ids);
        return true;
    }

    /**
     * 根据档案id查询一条档案
     * @param id 档案id
     * @return 一条档案记录
     */
    public StudentDetail findStudentDetailById(Long id){
        return studentDetailMapper.selectById(id);
    }

    /**
     * 编辑学生档案
     * @param studentDetail 一条学生档案
     * @return 是否成功
     */
    public boolean editStudentDetail(StudentDetail studentDetail){
        studentDetailMapper.updateById(studentDetail);
        return true;
    }



   /* *//**
     * 查询全部学生档案
     * @param c_id 班级id
     * @return 多条学生档案记录
     *//*
    public IPage<StudentDetail> findAllStudentDetail(Long c_id,Integer current){
        Page<StudentDetail> page = new Page<>(current,size);
        QueryWrapper<StudentDetail> queryWrapper = Wrappers.query();
        queryWrapper.eq("c_id",c_id);
        return studentDetailMapper.selectPage(page,queryWrapper);
    }

    *//**
     * 通过姓名或者班级id查询学生档案
     * @param c_id 班级id
     * @param cName 学生姓名
     * @return 多条学生档案记录
     *//*
    public IPage<StudentDetail> findStudentDetailByIdOrName(Long c_id, String cName,Integer current){
        Page<StudentDetail> page = new Page<>(current,size);
        StudentDetail sd = new StudentDetail();
        sd.setCId(c_id);
        sd.setCName(cName);
        QueryWrapper<StudentDetail> queryWrapper = Wrappers.query(sd);
        return studentDetailMapper.selectPage(page,queryWrapper);
    }

    *//**
     * 创建一个学生档案
     * @param studentDetail 学生档案对象
     * @return 是否成功
     *//*
    public boolean createStudentDetail(StudentDetail studentDetail){
        studentDetailMapper.insert(studentDetail);
        return true;
    }

    *//**
     * 上传多个学生档案
     * @param studentDetails 多个学生档案对象
     * @return 是都成功
     *//*
    public boolean uploadStudentDetails(List<StudentDetail> studentDetails){
        for (StudentDetail sd:studentDetails) {
            studentDetailMapper.insert(sd);
        }
        return true;
    }

    *//**
     * 通过id删除学生档案
     * @param id 档案id
     * @return 是否成功
     *//*
    public boolean removeStudentDetail(Long id){
        studentDetailMapper.deleteById(id);
        return true;
    }

    *//**
     * 通过多个id批量删除学生档案
     * @param ids 多个档案id
     * @return 是否成功
     *//*
    public boolean removeStudentDetails(List<Long> ids){
        studentDetailMapper.deleteBatchIds(ids);
        return true;
    }

    *//**
     * 根据档案id查询一条档案
     * @param id 档案id
     * @return 一条档案记录
     *//*
    public StudentDetail findStudentDetailById(Long id){
        return studentDetailMapper.selectById(id);
    }

    *//**
     * 编辑学生档案
     * @param studentDetail 一条学生档案
     * @return 是否成功
     *//*
    public boolean editStudentDetail(StudentDetail studentDetail){
        studentDetailMapper.updateById(studentDetail);
        return true;
    }
*/
    //(违纪)



    /**
     * 录入一条学生违纪信息
     * @param discipline 一条违纪
     * @return 是否成功
     */
    public boolean createDiscipline(Discipline discipline){
        discipline.setStatu(0);
        disciplineMapper.insert(discipline);
        return false;
    }

    /**
     * 通过违纪id删除违纪信息
     * @param id 违纪id
     * @return 是否成功
     */
    public boolean removeDisciplineById(Long id){
        disciplineMapper.deleteById(id);
        return false;
    }

    /**
     * 通过违纪id删除违纪信息
     * @param ids 违纪id
     * @return 是否成功
     */
    public boolean removeDisciplineByIds(List<Long> ids){
        disciplineMapper.deleteBatchIds(ids);
        return true;
    }

    /**
     * 根据违纪id查询一条记录
     * @param id 根据违纪
     * @return 查询一条违纪记录
     */
    public Discipline findDisciplineById(Long id){
        QueryWrapper<Discipline> queryWrapper = Wrappers.query();
        queryWrapper.eq("d.id",id);
        return disciplineMapper.selectDisciplineById(queryWrapper);
    }

    /**
     * 编辑违纪信息
     * @param discipline 一条违纪
     * @return 是否成功
     */
    public boolean editDiscipline(Discipline discipline){
        disciplineMapper.updateById(discipline);
        return false;
    }


    /**
     * 通过班级id查询学生违纪信息
     * @param id 班级id
     * @return
     */
    public List<Discipline> findDisciplineByCId(Long id){
        QueryWrapper<Discipline> queryWrapper = Wrappers.query();
        queryWrapper.eq(ObjIsNotEmpty.isNotEmpty(id),"c_id",id);
        return disciplineMapper.selectDisciplinesByCId(queryWrapper);
    }

    /**
     * 通过条件查询违纪信息
     * @param id
     * @param date 违纪时间
     * @param name 违纪学生姓名
     * @param type 违纪类型
     * @return 多条违纪记录
     */
    public IPage<Discipline> findDisciplineByCondition(Long id,LocalDateTime date, String name, String type,Integer current){
        /*//如果学生名字不为空，查询相对应的学生id
        Page<Student> pageStu = new Page<>(current,size);
        Page<Discipline> pageDic = new Page<>(current,size);
        QueryWrapper<Discipline> q1 = Wrappers.query();
        q1.eq("c_id",id);
        IPage<Student> students = new Page<>();
        if (name != null){
            QueryWrapper<Student> queryWrapper = Wrappers.query();
            queryWrapper.eq("s_name",name);
            students = studentMapper.selectPage(pageStu,queryWrapper);
        }
        //将学生id封装在集合中
        List<Long> ids = new ArrayList<>();
        for (Student s:students.getRecords()){
            ids.add(s.getId());
        }
        //判断日期是否为空
        boolean flag = false;
        if (date != null){
            flag = true;
        }
        //动态拼接时间，姓名，违纪类型
        q1.eq(flag,"create_time",date).eq(StringUtils.isNotEmpty(type),"type",type).in(!ids.isEmpty(),"student_id",ids);
        return disciplineMapper.findAllDisciplineByCId(pageDic,q1);*/

        Page<Discipline> page = new Page<>(current,size);
        QueryWrapper<Discipline> queryWrapper = Wrappers.query();
        queryWrapper.eq(ObjIsNotEmpty.isNotEmpty(id),"c_id",id);
        queryWrapper.eq(StringUtils.isNotEmpty(name),"s_name",name);
        queryWrapper.eq(ObjIsNotEmpty.isNotEmpty(date),"create_time",date);
        queryWrapper.eq(StringUtils.isNotEmpty(type),"type",type);
        return disciplineMapper.selectAllDisciplinesByCId(page,queryWrapper);
    }

   /* *//**
     * 录入一条学生违纪信息
     * @param discipline 一条违纪
     * @return 是否成功
     *//*
    public boolean createDiscipline(Discipline discipline){
        disciplineMapper.insert(discipline);
        return false;
    }

    *//**
     * 通过违纪id删除违纪信息
     * @param id 违纪id
     * @return 是否成功
     *//*
    public boolean removeDisciplineById(Long id){
        disciplineMapper.deleteById(id);
        return false;
    }

    *//**
     * 根据违纪id查询一条记录
     * @param id 根据违纪
     * @return 查询一条违纪记录
     *//*
    public Discipline findDisciplineById(Long id){
        return disciplineMapper.selectById(id);
    }

    *//**
     * 编辑违纪信息
     * @param discipline 一条违纪
     * @return 是否成功
     *//*
    public boolean editDiscipline(Discipline discipline){
        disciplineMapper.updateById(discipline);
        return false;
    }

    *//**
     * 根据班级查询所有的违纪信息
     * @return 多条违纪记录
     *//*
    //public List<Discipline> findAllDiscipline(Long id);

    *//**
     * 通过班级id查询学生违纪信息
     * @param id
     * @return
     *//*
    public IPage<Discipline> findDisciplineByClassId(Long id,Integer current){
        Page<Student> pageStu = new Page<>(current,size);
        Page<Discipline> pageDis = new Page<>(current,size);
        QueryWrapper<Student> qw1 = Wrappers.query();
        QueryWrapper<Discipline> qw2 = Wrappers.query();
        //根据班级id查询出所有学生的id
        qw1.select("id").eq("c_id",id);
        IPage<Student> list = studentMapper.selectPage(pageStu,qw1);
        List<Long> ids = new ArrayList<>();
        for (Student s:list.getRecords()){
            ids.add(s.getId());
        }
        //根据当前查询出的学生id查出所有违纪记录
        qw2.in("student_id",ids);
        return disciplineMapper.selectPage(pageDis,qw2);
    }
    *//**
     * 通过条件查询违纪信息
     * @param date 违纪时间
     * @param name 违纪学生姓名
     * @param type 违纪类型
     * @return 多条违纪记录
     *//*
    public IPage<Discipline> findDisciplineByCondition(LocalDateTime date, String name, String type,Integer current){
        //如果学生名字不稳空，查询相对应的学生id
        Page<Student> pageStu = new Page<>(current,size);
        Page<Discipline> pageDic = new Page<>(current,size);
        QueryWrapper<Discipline> q1 = Wrappers.query();
        IPage<Student> students = new Page<>();
        if (name != null){
            QueryWrapper<Student> queryWrapper = Wrappers.query();
            queryWrapper.eq("s_name",name);
            students = studentMapper.selectPage(pageStu,queryWrapper);
        }
        //将学生id封装在集合中
        List<Long> ids = new ArrayList<>();
        for (Student s:students.getRecords()){
            ids.add(s.getId());
        }
        //判断日期是否为空
        boolean flag = false;
        if (date != null){
            flag = true;
        }
        //动态拼接时间，姓名，违纪类型
        q1.eq(flag,"create_time",date).eq(StringUtils.isNotEmpty(type),"type",type).in(!ids.isEmpty(),"student_id",ids);
        return disciplineMapper.selectPage(pageDic,q1);
    }*/

    /**
     * 查询所有学生
     * @param cId 班级id
     * @return 多条学生记录
     */
    public IPage<Student> findAllStudentsByCId(Long cId,Integer current){
        Page<Student> page = new Page<>(current,size);
        QueryWrapper<Student> queryWrapper = Wrappers.query();
        //过滤条件c_id(班级id)
        queryWrapper.eq(ObjIsNotEmpty.isNotEmpty(cId),"c_id",cId);
        IPage<Student> students = studentMapper.selectPage(page, queryWrapper);
        return students;
    }

    /**
     * 新增
     * 根据实训师id查询学生
     * @param tid
     * @return
     */
    public List<Student> findStudentByTeacherId(Long tid){
        return studentMapper.selectStudentByTeacherId(tid);
    }

    /**
     * 新增
     * 根据实训师id查询学生分页
     * @param tid
     * @param current
     * @return
     */
    public IPage<Student> findAllStudentsByTid(Long tid,Integer current){
        Page<Student> page = new Page<>(current,size);
        return studentMapper.selectAllStudentByTid(page,tid);
    }





}
