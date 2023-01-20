package com.thinkconstructive.notificationservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @GetMapping(value = "/{notificationId}")
    public Notifications getNotifications(@PathVariable("notificationId") String notificationId)
    {
        Notifications notificationOne = new Notifications(notificationId,
                "Notification Details " + notificationId);

        return notificationOne;
    }
}
