package com.bgq.demo.util;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class URLParams {

    private String URL = "https://api.seniverse.com/v3/weather/";
    private String key = "afmlz62jdx69kmph";

    private Map<String, String> params = new HashMap<>();
    private String url;

    public URLParams(String url) {
        this.url = url;
    }

    public URLParams put(String key, String val) {
        params.put(key, val);
        return this;
    }

    public String build() {
        String str = URL;
        str += url + "?key=" + key;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            str += ("&" + entry.getKey() + "=" + entry.getValue());
        }
        return str;
    }

}
