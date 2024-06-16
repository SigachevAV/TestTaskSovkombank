package com.example.TestTaskSovkombank.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "unsplash")
public class UnsplashProperties
{
    private String accessKey;

    public void setAccessKey(String accessKey)
    {
        this.accessKey = accessKey;
    }

    public String getAccessKey()
    {
        return accessKey;
    }
}
