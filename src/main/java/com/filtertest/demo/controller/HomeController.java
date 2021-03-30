package com.filtertest.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    //示例controller,供统计时间用
    @GetMapping("/home")
    @ResponseBody
    public String homeMethod(@RequestParam("v") String version) {
            System.out.println("controller v:"+version);
            try {
                Thread.sleep(1000);    //延时1秒
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
            return "this is home,v="+version;
    }

}
