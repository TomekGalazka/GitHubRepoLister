package com.githubrepolister.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class GitHubRepoListerConfig {

    @Value("${github.api.token}")
    private String githubApiToken;

    @Bean
    public RestTemplate restTemplate() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token " + githubApiToken);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        return new RestTemplate();
    }
}
