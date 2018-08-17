package com.bgq.demo.action;

import com.bgq.demo.bean.City;
import com.bgq.demo.service.ChooseService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/testApi")
public class ChooseAction {

    @RequestMapping("/choose")
    public String choose(@RequestBody String param, HttpServletResponse response) throws IOException {
        City city = new Gson().fromJson(param, City.class);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(new ChooseService().getAllWeather(city));
        return null;
    }
}
