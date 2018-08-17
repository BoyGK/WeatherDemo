package com.bgq.demo.service;

import com.bgq.demo.bean.Choose;
import com.bgq.demo.bean.City;
import com.bgq.demo.bean.DailyRe;
import com.bgq.demo.bean.NowRe;
import com.bgq.demo.util.HttpRequest;
import com.bgq.demo.util.URLParams;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ChooseService {

    private URLParams urlParams;
    private HttpRequest request;

    //"https://api.seniverse.com/v3/weather/now.json?key=afmlz62jdx69kmph&location=${city}&language=zh-Hans&unit=c"
    //"https://api.seniverse.com/v3/weather/daily.json?key=afmlz62jdx69kmph&location=${city}&language=zh-Hans&unit=c&start=0&days=1"
    public String getAllWeather(City city) {

        Choose choose = new Choose();
        List<Choose.Citys> citys = new ArrayList<>();
        for (String s : city.getCity().split(",")) {
            citys.add(getWeather(s));
        }
        choose.setCitys(citys);
        return new Gson().toJson(choose);
    }

    private Choose.Citys getWeather(String city) {
        request = new HttpRequest();
        urlParams = new URLParams("now.json");
        urlParams.put("location", city)
                .put("language", "zh-Hans")
                .put("unit", "c");
        String re1 = request.doGet(urlParams.build());
        NowRe nowRe = new Gson().fromJson(re1, NowRe.class);

        urlParams = new URLParams("daily.json");
        urlParams.put("location", city)
                .put("language", "zh-Hans")
                .put("unit", "c")
                .put("start", "0")
                .put("days", "1");
        String re2 = request.doGet(urlParams.build());
        DailyRe dailyRe = new Gson().fromJson(re2, DailyRe.class);

        Choose.Citys citys = new Choose().new Citys();
        citys.setName(nowRe.getResults().get(0).getLocation().getName());
        citys.setPath(nowRe.getResults().get(0).getLocation().getPath());
        citys.setTemperature(nowRe.getResults().get(0).getNow().getTemperature());
        citys.setOthers(nowRe.getResults().get(0).getNow().getText() + " | 湿度" +
                nowRe.getResults().get(0).getNow().getHumidity() + "% | " +
                nowRe.getResults().get(0).getNow().getWind_direction() + "风" +
                nowRe.getResults().get(0).getNow().getWind_scale() + "级");
        citys.setHigh2low(dailyRe.getResults().get(0).getDaily().get(0).getHigh() + " / " +
                dailyRe.getResults().get(0).getDaily().get(0).getLow() + "℃");
        return citys;
    }

}
