package com.company.Infrastructure.utils;

import java.util.HashMap;
import java.util.Map;

public class TestUrl {
    private String protocol = "http";
    private String domain;
    private String port = "";
    private String path = "";
    private Map<String, String> params = new HashMap<>();

    public TestUrl() {
    }

    public static class Builder {
        private TestUrl testUrl;

        public Builder() {
            testUrl = new TestUrl();
        }

        public Builder withProtocol(String protocol) {
            testUrl.protocol = protocol;
            return this;
        }

        public Builder withDomain(String domain) {
            testUrl.domain = domain;
            return this;
        }

        public Builder withPort(String port) {
            testUrl.port = port;
            return this;
        }

        public Builder withPath(String path) {
            testUrl.path = path;
            return this;
        }

        public Builder withParam(String param) {
            testUrl.params.put(param, null);
            return this;
        }

        public Builder withParam(String key, String value) {
            testUrl.params.put(key, value);
            return this;
        }

        public String build() {
            if (!testUrl.port.isEmpty()) {
                testUrl.port = ":" + testUrl.port;
            }
            if (!testUrl.path.startsWith("/")) {
                testUrl.path = "/" + testUrl.path;
            }
            String params = "?";
            if (!testUrl.params.isEmpty()) {
                for (Map.Entry<String, String> param : testUrl.params.entrySet()) {
                    if (param.getValue() == null) // если  value = null
                        params += param.getKey() + "&";
                    else
                        params += param + "&";
                }
            }

            return testUrl.protocol + "://"
                    + testUrl.domain
                    + testUrl.port
                    + testUrl.path
                    + params;
        }
    }

    public static String myAccountUrl() {
       /* return new TestUrl.Builder()
                .withProtocol("https")
                .withDomain("mysite.com")
                .withPath("my-account/info")
                .withParam("debug", "true")
                .withParam("msid", "139837924")
                .withParam("logOn")
                .build();

        */
       return new Builder()
               .withProtocol("http")
               .withDomain("automation.is-best.net")
               .build();
    }

}
