package com.thinkconstructive.userservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String USER_SERVICE = "user-service";

    @GetMapping(value="/{userId}")
    @CircuitBreaker(name = USER_SERVICE, fallbackMethod = "userServiceFallBack")
    public User getUser(@PathVariable("userId") String userId)
    {
        User userOne = new User(userId, "User Name " + userId,
                "xxxxx" + userId);

        Posts posts = restTemplate.getForObject(
                "http://post-service/post/1", Posts.class);
        userOne.setPosts(posts);

        Notifications notifications = restTemplate.getForObject(
                "http://notification-service/notification/1", Notifications.class
        );
        userOne.setNotifications(notifications);

        return userOne;
    }

    public User userServiceFallBack(Exception userException)
    {
        return new User("1", "User One", "xyz");
    }

}
