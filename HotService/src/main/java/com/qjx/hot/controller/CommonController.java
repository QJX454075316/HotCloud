package com.qjx.hot.controller;

import com.alibaba.fastjson.JSONObject;
import com.qjx.hot.entrty.User;
import com.qjx.hot.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import java.util.List;


@Controller
@RequestMapping("index")
/**
 * 公共controller提供公共功能的接口
 * @author junxiangquan
 *
 */
public class CommonController {

    @Autowired
    private CommonService commonService;

    @RequestMapping("login")
    public ModelAndView userLogin(@RequestBody String param){
        User user = JSONObject.parseObject(param,User.class);
        ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
        user = commonService.loginIn(user);
        if(user!=null){
            model.addObject("data",user);
            model.addObject("code",200);
            model.addObject("msg","登录成功!");
        }else{
            model.addObject("code",400);
            model.addObject("msg","账号或密码不正确!");
        }
        return model;
    }

    @RequestMapping("usernameIsExist")
    public ModelAndView usernameIsExist(String username){
        int resrult = commonService.usernameIsExist(username);
        ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
        if(resrult<=0){
            model.addObject("code",200);
            model.addObject("msg","用户名可以使用!");
        }else{
            model.addObject("code",400);
            model.addObject("msg","用户名已存在!");
        }
        return model;
    }

    @RequestMapping("register")
    public ModelAndView register(@RequestBody String param){
        User user = JSONObject.parseObject(param,User.class);
        ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
        int result = commonService.register(user);
        if(result==1){
            model.addObject("data",user);
            model.addObject("code",200);
            model.addObject("msg","注册成功!");
        }else{
            model.addObject("code",400);
            model.addObject("msg","注册失败!");
        }
        return model;
    }


    @GetMapping("getAllUser")
    public ModelAndView getAllUser(){

        ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
        List<User> users = commonService.getUserList();
        if(!users.isEmpty()){
            model.addObject("data",users);
            model.addObject("code",200);
            model.addObject("msg","登录成功!");
        }else{
            model.addObject("code",400);
            model.addObject("msg","没有用户!");
        }
        return model;
    }

    
    /*@RequestMapping("/thymeleaf")
    public String testThymeleaf(Map<String,Object> map) {
        map.put("msg", "Hello Thymeleaf");
        map.put("userList", commonService.getUserList());
        return "test_thymeleaf";
    }

    @RequestMapping("/freemaker")
    public String testFreemaker(Map<String,Object> map) {
        map.put("msg", "Hello freemarker!");
        return "test_freemarker";
    }

    @RequestMapping("/index")
    public String index() {
        return "test_sidebar";
    }*/

}
