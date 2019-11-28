package controller;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CURDController {
    @RequestMapping("/add2")
    public int add( @RequestParam Integer a ){//参数不你那个用int,返回值不能是null
//Integer a 洽会为您还null,因为你是在参数里面值为0,怎么认识那个参数为10怎么传?地址栏拼?
        System.out.println("我是add");
        a=1;
     //    int b = 2/0;

        //但是我可以贵定他是什么时候输出的e?
        //这个歌打印语句在在那个类中的方法
        /**
         * 打印语句写入磁盘中,,按照你的规则,
         * 这些规则就是log
         */
        return 1;
    }

    @RequestMapping("/delete2")
    public void  delete(){
        System.out.println("我是delete");
    }


   //我先在可以不可以待用孔易方法,,一个方法嗲用另一个方法...


    //连接维护数库? 插入之前操作?

//答题我们的输出语句
    @RequestMapping("abc")
    public void testlog(Integer a){
        Logger logger = Logger.getLogger(CURDController.class);
      logger.debug("我代替了System.out");
    }
}
