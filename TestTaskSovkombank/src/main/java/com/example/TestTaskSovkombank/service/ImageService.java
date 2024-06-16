package com.example.TestTaskSovkombank.service;

import com.example.TestTaskSovkombank.config.UnsplashProperties;
import com.example.TestTaskSovkombank.exception.ImageException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageService implements IImageService
{
    private final UnsplashProperties unsplashProperties;
    public String GetImage(@NotNull String _query) throws ImageException
    {
        log.atInfo().log("New Request with query " + _query);
        HttpRequest request;
        try
        {
            request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.unsplash.com/search/photos?client_id=" + unsplashProperties.getAccessKey() + "&per_page=1&query=" + _query))
                    .GET()
                    .build();
        }
        catch (Exception exception)
        {
            throw new ImageException(exception.getMessage());
        }
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response;
        try
        {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (Exception exception)
        {
            throw new ImageException(exception.getMessage());
        }
        String text = response.body();
        Pattern pattern = Pattern.compile("https://images\\.unsplash\\.com/[^\\s]+?\\.(jpg|jpeg|png)*");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find())
        {
            String result = matcher.group();
            log.atInfo().log("image found: " + result);
            return result;
        }
        else
        {
            log.atError().log("image not found");
            throw new RuntimeException("url not found in response");
        }
    }
}
