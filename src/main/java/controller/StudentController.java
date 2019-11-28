package controller;

import entity.Student;
import entity.Student2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import serviceImpl.Student2ServiceImpl;
import serviceImpl.StudentServiceImpl;

@RestController
public class StudentController {
@Autowired
    StudentServiceImpl ssi;

    @Autowired
    Student2ServiceImpl ssi2;

    @RequestMapping("/select")
    public Student selectById(@RequestParam Integer id){
        //为甚new不行,注入就行了,就是会把错了,null空指针异常,为什么
        //就是spring装的组件, 任何组件就是得给spring管理,找不大就会报空指针异常,,就是 相当不属于就是淡季游戏,空顶不可以
        //就是so手动加入bean
     return  ssi.selectById(id);
    }


    @RequestMapping("insert")
    public  int insert(){
        //数据可以不可以new,是数据当然不可以 new,只有对象不能new
        Student stu = new Student("张丹",20);
        return ssi.insert(stu);
    }

    @RequestMapping("delete22")
    public int delete(@RequestParam Integer id){
        return ssi.delete(id);
    }

    @RequestMapping("modify")
    public int modify(){
//1.根据 id 查询
// Studnet stu = new Student（）；
Student stu = ssi.selectById(2);

//更新操作
   stu.setName("王一博");
   stu.setAge(22);
   return ssi.modify(stu);
    }


@RequestMapping("findall")
    public  int findAll(){
 return  ssi.findAll();
}

@RequestMapping("/selectByNA")
    public  Student selectByNA(){
        return ssi.SelectByNameAndAge("肖战",25);
}

@RequestMapping("selective")
    public int selective(){
    Student2 stu = new Student2(2,"xianxian");
        return ssi2.insertSelective(stu);

}

}
