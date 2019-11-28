package serviceImpl;

import entity.Student;
import mapper.StudentMapper;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.StudentService;

@Service
//就是获取springmvc.xml那个bean里面了
public class StudentServiceImpl implements StudentService {

//为什么?spring-mybatis已经扫描了,mapper,所以可以注入
    @Autowired
    StudentMapper sm;

    @Override
    public Student selectById(Integer id) {
        //魅力dao的实现类,怎么调用?注入.怎么使用
        return sm.selectById(id);
    }

    @Override
    public int insert(Student student) {
        return sm.insert(student);
    }

    @Override
    public int delete(Integer id) {
        return sm.delete(id);
    }

    @Override
    public int modify(Student student) {
        return sm.modify(student);
    }

    @Override
    public int findAll() {
        return sm.findALL ();
    }

    @Override
    public Student SelectByNameAndAge(String name, Integer age) {
        return sm.SelectByNameAndAge(name,age);
    }
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
}
