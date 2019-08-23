package demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ValueConstants;

@Controller
public class DemoController {

    @RequestMapping(value = "hello")
    @ResponseBody
    public String index(){
        return "hello world";
    }
}
