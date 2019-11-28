 package controller;

import entity.Student;
import entity.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@Controller
//注解?w为什么在注解加进来?spring带他玩  ,原来就什么样的数据类型,就会找不到,就会下面respondbody
//为甚要用注解,
//@ResponseBody  //加在整个类上面就是这个ctorller返回的就是json的数据格式

@RestController  //等价属于 @Controller +@ Responbody
public class MyController {

    //@RequestMapping会根据请求名找到对应的方法.,写在方法上面就绑定了,请我这个请求过来了就执行这个方法.
    //通过url找方法,这个注解就是@RequestMapping
    @RequestMapping("/add")
    public void add(){
        System.out.println("我是add方法");
    }

    //比servlet好很多.就是会方便很多,
    @RequestMapping("/delete")
    public void delete(){
        System.out.println("我是detele方法");
    }

    @RequestMapping("modifty")
    public void modifty(){
        System.out.println("我是修改modifty");
    }


    /**
     *
     //model
     //Model And View
     * Model是每次请求中都存在的默认参数，利用其addAttribute()方法即可将服务器的值传递到jsp页面中；
     * ModelAndView包含model和view两部分，使用时需要自己实例化，利用ModelMap用来传值，也可以设置view的名称
     * @param mv
     * @return
     */
    @RequestMapping("hello")
    public String hello(Model mv){
        //ModelAndView 数据+模型对象,可以绑定数据到指定页面,

         mv.addAttribute("name","hello world");

//本来就是会一个String字符串,这个就是会个没有.jsp如果就是会会你的数据类型?怎么办
        return  "my";
    }

    //这就是之前的转发
    @RequestMapping("hello2")
    public ModelAndView hello2(ModelAndView mv){
        mv.addObject("name","hlll");
        mv.setViewName("my");

        //看得上数据也有了,也设置到页面上面的就最后返回一个mv对象
        return  mv ;
    }

    @RequestMapping("hello3")
    @ResponseBody//该注解就是 回的就是json格式的字符串而非页面,也可以可以写在方法里面.
    //这个加在类上面呢,就是整个类都是返回的都是json类型格式
    public    String hello3(){

        return  "my";
    }

 /*   @RequestMapping("/stu1")
    public Student student(Student stu){
        stu = new Student("张三",25);
        return  stu;
    }
*/
    @RequestMapping("list")
   public List <Student> list(){
   List<Student> list = new ArrayList<Student>();
   Student stu = new Student();
   Student stu2 = new Student();

    stu.setName("沾沾");
    stu.setAge(25);
    list.add(stu);

    stu2.setAge(26);
    stu2.setName("ss");
    list.add(stu2);

    return  list;
    //如果热部署就是旁边的debug启动,是实现一办必须要跟请求向关的时候就得从热部署也没用,,就该东Java代码,等个两秒,
        //

   }
   @RequestMapping("show")
   public void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       PrintWriter pw = response.getWriter();
       pw.print("hell 收到了");
       String name = request.getParameter("name");
       String age = request.getParameter("age");
       System.out.println(name);
       System.out.println(age);

   }

   @RequestMapping("sh")
    public int show(HttpServletRequest request , @RequestParam String name ,@RequestParam String age){
       try {
           request.setCharacterEncoding("UTF-8");
           System.out.println("姓名"+name+":"+"名字"+age);
           if(name!=""&&age!=""){
               return  0;//成功
           }else{
               return 1;//失败
           }
       } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
       }

       return 2;
   }

   @RequestMapping("reg")
   public String reg( HttpServletRequest request ,@RequestParam String name ,@RequestParam String psw){
       System.out.println(name+","+psw);


      HttpSession session = request.getSession();

       session.setAttribute("name","name");
       session.setAttribute("psw","psw");

       return "login";

   }


   @RequestMapping("logino")
   public int  login( @RequestParam String name ,@RequestParam String psw ,HttpServletRequest request ){

       HttpSession session = request.getSession();
      String name1 = (String)session.getAttribute("name'");
      String psw1=(String) session.getAttribute("psw");

   if(name1!=""&&psw1!=""){
       return  1;//成功
   }else{
         return 2;
       }
   }

    /**
     * 模拟异步请求响应
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了...");
        // 客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        // 做响应，模拟查询数据库
       user.setName("你");
        user.setPsw("123");
        // 做响应
        return user;
    }


}


