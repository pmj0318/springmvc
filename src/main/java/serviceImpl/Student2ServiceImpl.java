package serviceImpl;

import entity.Student2;
import mapper.Student2Mapper;
import mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.StudentService2;

@Service
//就是获取springmvc.xml那个bean里面了
public class Student2ServiceImpl implements StudentService2 {
    //为什么?spring-mybatis已经扫描了,mapper,所以可以注入
    @Autowired
    Student2Mapper sm;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sm.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Student2 record) {
        return sm.insert(record);
    }

    @Override
    public int insertSelective(Student2 record) {
        return sm.insertSelective(record);
    }

    @Override
    public Student2 selectByPrimaryKey(Integer id) {
        return sm.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Student2 record) {
        return sm.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student2 record) {
        return sm.updateByPrimaryKeySelective(record);
    }
}
