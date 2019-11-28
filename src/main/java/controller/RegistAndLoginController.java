package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class RegistAndLoginController {
    List<User> list = new ArrayList<>();

    @RequestMapping("/regist")
    public @ResponseBody
    String regist(User user, HttpServletRequest req) {
        list.add(user);
        if (user.toString().equals("")) {
            return "fail regist ";
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("user", list);
            System.out.println("注册时:" + session.getId() + "," + session.getAttribute("user"));
            return "success regist";
        }
    }

    @RequestMapping("/login")
    public @ResponseBody
    String login(User user, HttpServletRequest req) {
        HttpSession session = req.getSession();
        List<User> list = (List<User>) session.getAttribute("user");
        System.out.println("登录时:" + session.getId() + "," + session.getAttribute("user"));
        int flag = 0;
        for (User u : list) {
            if (user.toString().equals(u.toString())) {
                flag = 1;
                break;
            }
        }
        return flag == 1 ? "success login" : "fail login";
    }
}