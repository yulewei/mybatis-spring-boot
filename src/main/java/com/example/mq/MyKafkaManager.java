package com.example.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yulewei on 2020/8/9
 */
@Slf4j
@Component
public class MyKafkaManager {

    private List<String> buffer = new ArrayList<>();

    @KafkaListener(topics = {"chat__im_message_0", "chat__im_message_1", "chat__im_message_2", "chat__im_message_3",
            "chat__im_message_4", "chat__im_message_5", "chat__im_message_6", "chat__im_message_7"})
    public synchronized void handleBinlogChatImMessage(String payload) {
        System.out.println(Thread.currentThread().getId());
        buffer.add(payload);
        if (buffer.size() >= 10) {
            sync2Elasticsearch();
        }
    }

    @Scheduled(fixedRate = 60 * 1000)
    public synchronized void sync2Elasticsearch() {
        System.out.println("sync2Elasticsearch");
        if (buffer.isEmpty()) {
            return;
        }
        System.out.println("buffer size:" + buffer.size());
        buffer.clear();
    }

}
