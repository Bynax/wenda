package com.bohuanshi.wenda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

/**
 * @Author: bohuanshi
 * @Date: 2020/5/22 15:15
 * @Description:
 */

@Controller
public class IndexController {

    @RequestMapping(path = {"/", "/index"})
    @ResponseBody // 如果注释掉就会去模版目录中返回文件
    public String index() {
        return "Hello world";
    }


    @RequestMapping(path = {"/profile/{groupId}/{userId}"},method = {RequestMethod.GET})
    @ResponseBody // 如果注释掉就会去模版目录中返回文件
    public String profile(@PathVariable("userId") int userId,
                          @PathVariable("groupId") String groupId,
                          @RequestParam("type") int type,
                          @RequestParam("key") String key) {
        return String.format("profile page of %s %d t: %d k %s", groupId, userId, type, key);
    }
}
