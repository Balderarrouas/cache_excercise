package com.example.demo.controller;

import com.example.demo.Cache;
import com.example.demo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class cacheController {

    Cache userCache = new Cache();

    @GetMapping(value = "/get-user-data")
    @ResponseBody
    public String renderCache(@RequestParam int id) throws InterruptedException {

        if(userCache.has(id)==false){
            User user = new User(id);
            String s =user.getDataSlow();
            userCache.set(id,s);
            return s;
        }
        else if(userCache.has(id)==true)
        {
            return userCache.get(id);
        }

        return "/get-user-data";
    }

}
