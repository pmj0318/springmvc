package mapper;

import entity.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    //完后某一个功能,就是写抽象方法
    Student selectById(Integer id);
    //select * from student where id=?
    int insert(Student student);
    int delete(Integer id);
    int modify(Student student);//修改完该怎么比呢,是不要说赋值也就是giant对象呢,,如果就是还是id哪魔
    int findALL();

    Student SelectByNameAndAge(@Param(value="name") String name ,@Param(value="age") Integer age);

}
