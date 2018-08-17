package com.bgq.demo.bean;

import java.util.List;

public class Choose {

    private List<Citys> city_s;

    public List<Citys> getCitys() {
        return city_s;
    }

    public void setCitys(List<Citys> citys) {
        this.city_s = citys;
    }

    public class Citys{
        private String name;
        private String path;
        private String temperature;
        private String others;
        private String high2low;

        public String getHigh2low() {
            return high2low;
        }

        public void setHigh2low(String high2low) {
            this.high2low = high2low;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getOthers() {
            return others;
        }

        public void setOthers(String others) {
            this.others = others;
        }
    }
}
