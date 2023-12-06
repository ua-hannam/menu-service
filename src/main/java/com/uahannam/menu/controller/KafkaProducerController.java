package com.uahannam.menu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uahannam.menu.service.KafkaProducerService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * 카프카 컨트롤러
 * @since 2023. 12. 06
 * @author swlee
 */
@Slf4j(topic = "KafkaController")
@RestController
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@RequestMapping("/api/menu/kafka")
public class KafkaProducerController {

    private final KafkaProducerService kafkaProducerService;

    /**
     * 카프카 메세지 전송
     * @since 2023. 12. 06
     *
     * @return ResponseEntity<Void> 성공 여부 반환
     */
    @PostMapping("")
    public ResponseEntity<Void> sendMessage(String topic, String message) {
        log.info("sendMessage");
        kafkaProducerService.sendMessage(topic, message);
        log.info("sendMessage : success");
        return ResponseEntity.ok().build();
    }
    
    
}
