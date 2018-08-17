package com.bgq.demo.action;

import com.bgq.demo.bean.City;
import com.bgq.demo.service.AudioService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
@RequestMapping("/testApi")
public class AudioAction {

    @RequestMapping(value = "/audio")
    public String getAudio(@RequestBody String param, HttpServletResponse resp) throws Exception {
        City city = new Gson().fromJson(param, City.class);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(new AudioService().getAudio(city));
        return null;
    }
}
