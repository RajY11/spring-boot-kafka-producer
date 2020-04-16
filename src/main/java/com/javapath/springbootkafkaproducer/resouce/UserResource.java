package com.javapath.springbootkafkaproducer.resouce;


import com.javapath.springbootkafkaproducer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC_NAME = "User_Topic";

    @GetMapping("/publish/{name}")
    public String sendUser(@PathVariable String name){
        kafkaTemplate.send(TOPIC_NAME, new User(new Random().nextInt(1000),name));

        return "user published successfully";

    }
}
