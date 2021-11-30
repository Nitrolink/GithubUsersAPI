package com.foundry.GithubApi;

import com.foundry.GithubApi.Models.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/github")
public class GithubApiController {
    private final String URL = "https://api.github.com/users";

    @GetMapping(value = {"/users","/users/{id}"})
    public Object getUsers(RestTemplate restTemplate, @PathVariable(name = "id", required = false) String id){
        if(id == null){
            return restTemplate.getForObject(URL, User[].class);
        }
        else{
            return restTemplate.getForObject(URL+ "/" +id, User.class);
        }
    }
}
