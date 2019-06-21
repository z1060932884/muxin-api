package com.zzj.muxin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {


    @RequestMapping(value = "/hello")
    public String hello(Model model) {
        String name = "zzj";
        model.addAttribute("name", name);
        List<String> list = new ArrayList<>();
        list.add("nihao");
        list.add("222");
        list.add("haah");
        model.addAttribute("list", list);
        return "hello";
    }

}
