package com.doddd.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: spring-boot-diystarter
 * @description:
 * @author: doddd
 * @create: 2020-02-23 22:13
 **/
@ConfigurationProperties(prefix = "doddd.hello")
public class HelloProperties {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

}
