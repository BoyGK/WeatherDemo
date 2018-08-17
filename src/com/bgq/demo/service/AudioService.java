package com.bgq.demo.service;

import com.bgq.demo.bean.City;
import com.bgq.demo.bean.NowRe;
import com.bgq.demo.restapi.common.DemoException;
import com.bgq.demo.restapi.ttsdemo.TtsMain;
import com.bgq.demo.util.AIW;
import com.bgq.demo.util.HttpRequest;
import com.bgq.demo.util.URLParams;
import com.google.gson.Gson;

import java.io.IOException;

public class AudioService {

    private URLParams urlParams;
    private HttpRequest request;

    private AIW aiw;

    public String getAudio(City city) {
        request = new HttpRequest();
        urlParams = new URLParams("now.json");
        urlParams.put("location", city.getCity())
                .put("language", "zh-Hans")
                .put("unit", "c");
        String re1 = request.doGet(urlParams.build());
        NowRe nowRe = new Gson().fromJson(re1, NowRe.class);

        String text = getText(nowRe);

        try {
            String url = new TtsMain(text).getAudio();
            return url;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getText(NowRe nowRe) {
        aiw = new AIW(nowRe);
        return aiw.simple().getResultTest();
    }

}
