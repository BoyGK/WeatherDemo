package com.bgq.demo.action;

import com.bgq.demo.util.HttpRequest;
import com.bgq.demo.util.URLParams;
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
        String str = param.substring(8, param.length() - 2);
//        System.out.println("1" + str);
        String[] strs = str.split("\\?");
//        System.out.println("2-1" + strs[0]);
//        System.out.println("2-2" + strs[1]);
        URLParams params = new URLParams(strs[0]);
//        System.out.println("3" + params.build());
        String url = params.build() + strs[1];
        if (url.contains("/sun.json")) url = url.replace("weather", "geo");
//        System.out.println("4" + url);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(new HttpRequest().doGet(url));
        return null;
    }

}
