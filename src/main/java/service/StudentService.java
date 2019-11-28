package service;

import entity.Student;

public interface StudentService {
    //完后某一个功能,就是写抽象方法
    Student selectById(Integer id);
    int insert(Student student);
    int delete(Integer id);
    int modify(Student student);
    int findAll();

    Student SelectByNameAndAge(String name ,Integer age);

}
