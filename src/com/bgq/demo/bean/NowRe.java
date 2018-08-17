package com.bgq.demo.bean;

import java.util.List;

/**
 * 指定城市天气
 */
public class NowRe {
    private List<ResultsNow> results;

    public List<ResultsNow> getResults() {
        return results;
    }

    public void setResults(List<ResultsNow> results) {
        this.results = results;
    }
}
