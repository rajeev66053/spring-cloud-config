package com.java.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MainController {

    @Value("${channel.source: No Channel}")
    private String source;

    @Autowired
    private ConfigProps configProps;

    @GetMapping("/info")
    public ChannelInfo getChannleInfo(){
        return new ChannelInfo(source, configProps.getName(), configProps.getUrl());
    }
}