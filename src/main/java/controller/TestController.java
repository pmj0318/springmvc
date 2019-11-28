package controller;

import entity.Student;
import mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    //意义上就是注入的service是实现类,可以不可以创建service 是是实现类,,没有就是后面springboot就是到服务没法发布
    @Autowired
    StudentMapper sm;
    @RequestMapping("test22")
    @Transactional(propagation= Propagation.NESTED,rollbackFor = Exception.class)
    public void test2() {
    Student stu = new Student("内嵌事务",25);
    int n = sm.insert(stu);
    if(n>0){
        System.out.println("插入数据成功");
    }
   // int a =2/0;//外部异常和内部异常?外部异常不不会影响内部异常,单是内部异常会影响外不上
        int a =2/0;// 这就是测试内部回滚会不会一项外部nest
        /**
         * 就是nest就是新象一个共生体,命运共同体.有一个回滚句都不会插入成功数据
         */
    }



}
