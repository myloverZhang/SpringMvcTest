package org.hdu.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.hdu.mapper.school.SchoolMapper;
import org.hdu.mapper.students.StudentsMapper;
import org.hdu.model.SchoolPo;
import org.hdu.model.StudentsPo;
import org.hdu.service.ITestService;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Shu shoufu. ${date} ${time}
 * ${tags}
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} ${date}
 * @modify by reason:{方法名}:{原因}
 */
@Service
public class TestServiceImpl implements ITestService{
    @Autowired
    @Qualifier("mysqlSessionFactoryBean")
    private SqlSessionFactoryBean mysqlSessionFactory;

    @Autowired
    @Qualifier("psqlSessionFactoryBean")
    private SqlSessionFactoryBean psqlSessionFactory;
    @Override
    public StudentsPo getStudentInfo(Integer id) {
        SqlSession session = null;
        try {
            session = mysqlSessionFactory.getObject().openSession();
            StudentsMapper mapper = session.getMapper(StudentsMapper.class);
            StudentsPo studentsPo = mapper.getStudentById(id);
            return studentsPo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SchoolPo getSchoolInfo(Integer id) {
        SqlSession session = null;
        try {
            session = psqlSessionFactory.getObject().openSession();
            SchoolMapper mapper = session.getMapper(SchoolMapper.class);
            SchoolPo schoolPo = mapper.getSchoolInfo(id);
            return schoolPo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
