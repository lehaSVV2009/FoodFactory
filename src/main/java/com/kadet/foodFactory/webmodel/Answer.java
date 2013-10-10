package com.kadet.foodFactory.webmodel;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 10.10.13
 * Time: 22:43
 * To change this template use File | Settings | File Templates.
 */
public class Answer {

    private Map<String, String> parameters;
    private String url;

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
