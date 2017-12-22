package com.wangsheng.demo.controller;

import com.wangsheng.demo.entity.User;
import com.wangsheng.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/main")
public class MainController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index(){ return "test/index";}

    @RequestMapping(value = "/mainIndex")
    public String mainIndex(){
        return "test/main";
    }

    @RequestMapping(value = "/show")
    @ResponseBody
    public Object show(@RequestParam(value = "name")String name){
        User user = userService.findUserByName(name);
        if(null != user)
            return user;
        else return null;
    }

    @RequestMapping(value = "/menuList")
    @ResponseBody
    public Object menuList(){
        List<Map> childrenListMap = new ArrayList<>();
        Map childrenMap1 = new HashMap();
        childrenMap1.put("title","用户管理");
        childrenMap1.put("icon","&#xe641;");
        childrenMap1.put("href","");
        childrenListMap.add(childrenMap1);
        Map childrenMap2 = new HashMap();
        childrenMap2.put("title","数据字典");
        childrenMap2.put("icon","&#xe641;");
        childrenMap2.put("href","");
        childrenListMap.add(childrenMap2);
        Map childrenMap3 = new HashMap();
        childrenMap3.put("title","菜单管理");
        childrenMap3.put("icon","&#xe641;");
        childrenMap3.put("href","");
        childrenListMap.add(childrenMap3);
        List<Map> listMap = new ArrayList<>();
        Map map1 = new HashMap();
        map1.put("title","系统管理");
        map1.put("icon","fa-cubes");
        map1.put("spread","true");
        map1.put("children",childrenListMap);
        listMap.add(map1);
        return listMap;
    }
}
