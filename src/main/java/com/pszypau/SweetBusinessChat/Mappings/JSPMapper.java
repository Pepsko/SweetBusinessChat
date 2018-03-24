package com.pszypau.SweetBusinessChat.Mappings;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Lenovo on 2018-03-24.
 */
@Controller
public class JSPMapper {
    @GetMapping("/home")
    public String display(){
        return "home.jsp";
    }
}
