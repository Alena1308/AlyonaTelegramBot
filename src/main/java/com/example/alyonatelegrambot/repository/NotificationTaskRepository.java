package com.example.alyonatelegrambot.repository;

import com.example.alyonatelegrambot.entity.NotificationTask;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotificationTaskRepository extends JpaRepository<NotificationTask,Long> {
//    List<NotificationTask> findAllByNotificationDateTime(LocalDateTime localDateTime);
//
//    List<NotificationTask> findAllByNotificationDateTimeAndChatId(
//            LocalDateTime localDateTime,
//            long chatId);
}
