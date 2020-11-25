package com.naokeziteng.cloud.controller;

import com.naokeziteng.cloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aku
 * @Date 2020/11/25
 * @Description
 */
@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/send")
    public void sendMessage() {
        messageProvider.send();
    }
}
