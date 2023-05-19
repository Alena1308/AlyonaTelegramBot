package com.example.alyonatelegrambot.service;

import com.example.alyonatelegrambot.entity.NotificationTask;
import com.example.alyonatelegrambot.repository.NotificationTaskRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationTaskService {
    private final NotificationTaskRepository notificationTaskRepository;

    public NotificationTaskService(NotificationTaskRepository notificationTaskRepository) {
        this.notificationTaskRepository = notificationTaskRepository;
    }
    public void save(NotificationTask notificationTask){
        notificationTaskRepository.save(notificationTask);
    }
}
