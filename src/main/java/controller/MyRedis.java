package controller;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class MyRedis {
    public static void main(String[] args) {
        //要先连接诶衣蛾个数据库,就是需要new,但是已将好了
        //1.就是往redis里面放数据
        Jedis jedis = new Jedis();//创建Redis对象,在java中叫jedis
        jedis.set("hero","liubei");

        //2.就是在redis获取数据
        String s = jedis.get("name");
        System.out.println(s);

        //3.主要用hmset,也就是map里面是获取数据
         Map map = jedis.hgetAll("mymap");
        System.out.println(map);

        //4.设置setmap怎么办?1
        Map map2 = new HashMap();
        map2.put("game","lol");
        map2.put("mobilephone","Iphone");

        jedis.hmset("my",map2);//key就是在redis my 后面value就是自己自己在java中map2..



     //5.就是双层map遍历后期要用的的话,就是自己记住
        Map<String,Map> map3 = new HashMap();
         Map <String,String>map4 = new HashMap();
         map4.put("1","abc");
         map4.put("2","abc2");
         map4.put("3","abc3");
         map3.put("qq",map4);
        for (Map.Entry<String,Map>entry:map3.entrySet())  {
            System.out.println(entry.getKey()+"=="+entry.getValue());
        }
    }

}
