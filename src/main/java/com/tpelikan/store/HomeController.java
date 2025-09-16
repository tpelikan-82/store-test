package com.tpelikan.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tpelikan.store.entity.Employee;

@Controller
public class HomeController {
	
    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("/")
    public String index() {
        System.out.println(appName);
        return "index.html";
    }
    
 

    
}
