package com.bgq.demo.util;

import com.bgq.demo.bean.NowRe;

public class AIW {

    private NowRe city;
    private String resultText;

    public AIW(NowRe city) {
        this.city = city;
    }

    public String getResultTest() {
        return resultText;
    }

    /**
     * 简单算法
     * @return
     */
    public AIW simple() {
        resultText = "城市" + city.getResults().get(0).getLocation().getName() + ",天气" +
                city.getResults().get(0).getNow().getText() + "," +
                city.getResults().get(0).getNow().getWind_direction() + "风" +
                city.getResults().get(0).getNow().getWind_scale() + "级";
        return this;
    }
}
