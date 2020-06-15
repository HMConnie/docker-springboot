package com.sgcai.boot.api;

import com.sgcai.boot.entity.User;
import com.sgcai.boot.impl.UserServiceImpl;
import com.sgcai.boot.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam("mobile") String mobile, @RequestParam("password") String password) {
        List<User> users = userService.getUserInfoByMobileWithPwd(mobile, password);
        return ResponseUtils.toSuccess(users);
    }
}
