package com.chock.nettysocket.netty;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @auther: zhuohuahe
 * @date: 2019/3/14 16:12
 * @description:
 */
@Controller
public class ServerController {

    @GetMapping("")
    public String connect(){
        return "socket";
    }
}
