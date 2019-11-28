package controller;

import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import serviceImpl.StudentServiceImpl;

@RestController
public class MyTransaction {
    /*就是在spring里面使用事务*/

    //表示当前方法开启一个事务?如果加在类上面呢,
    //之前就是没有是哦用事务?为社会那么就能提交,就是使用默认jdbc事务.这是spring默认的传播行为.
    //    @如果是使用默认就是不用鸡杂"propagation=Propagation.REQUIRED"这个及阿布加 就没神去呗就是默认,所以不用加

    @Autowired
    StudentServiceImpl ssi;

    @Autowired
    TestController tc;
    @RequestMapping("test1")
    @Transactional(rollbackFor = Exception.class)
    public  void test1(){
        Student stu = new Student("卡莎",18);
        int n  = ssi.insert(stu);
        if(n>0){
            System.out.println("test1插入数据成功");
        }
       // MyTransaction mt = new MyTransaction();//怎么在本类放方法待用其他对象..创建一个额对象
        //如果说你早本类中调用自己的方法就用不=new,如果在容器中,就是hibuyong  new在这种让其中药用new,就是永远是空指针?在spring容器里面.
        tc.test2();

        /* int a =2/0;
        //外部影响内部,内部不会一项外部..*/
       // int a =2/0;//nest数据外部会不会一项内部?测试结果看一下..
    }

 /*   public  void test2(){
        //int c = 2/0;//要么成功,要么一起死..一开第一下次就是测试默认界=级别的测试,,

    }*/

}
