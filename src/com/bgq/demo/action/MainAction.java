package com.bgq.demo.action;

import com.bgq.demo.util.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
@RequestMapping("/testApi")
public class MainAction {

    @RequestMapping(value = "/url", method = RequestMethod.POST)

    public String hello(@RequestBody String param, HttpServletResponse resp) throws Exception {
        String url = param.substring(8, param.length() - 2);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(new HttpRequest().doGet(url));
        return null;
    }

}
