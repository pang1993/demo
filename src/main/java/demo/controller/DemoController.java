package demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping(value = "hello")
    @ResponseBody
    public String index() {
        return "hello world";
    }

    @PostMapping(value = "login")
    public String login(String username, String password, Map<String, Object> out, HttpSession httpSession) {
        if ("admin".equals(username) && "123".equals(password)) {
            logger.info("用户" + username + "登录成功");
            httpSession.setAttribute("loginName", username);
            return "redirect:/welcome";
        } else {
            logger.info("用户" + username + "登录失败");
            out.put("msg", "用户名或密码不正确");
            return "index";
        }
    }
}
