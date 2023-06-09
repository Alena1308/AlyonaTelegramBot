package com.example.alyonatelegrambot.timer;

import com.example.alyonatelegrambot.repository.NotificationTaskRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@Component
public class NotificationTaskTimer {
    private final NotificationTaskRepository notificationTaskRepository;
    private final TelegramBot telegramBot;

    @Autowired
    public NotificationTaskTimer(NotificationTaskRepository notificationTaskRepository, TelegramBot telegramBot) {
        this.notificationTaskRepository = notificationTaskRepository;
        this.telegramBot = telegramBot;
    }
    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void task() {
        notificationTaskRepository.findAllByNotificationDateTime(
                        LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES))
                .forEach(notificationTask -> {
                    telegramBot.execute(new SendMessage(
                            notificationTask.getChatId(),
                            "Вы просили напомнить о задаче:\n" + notificationTask.getMessage()));
                    notificationTaskRepository.delete(notificationTask);
                });
    }
}
