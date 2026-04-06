package com.example.Ss1.Th;


import com.example.Ss1.Th.INotification;
import org.springframework.stereotype.Component;

@Component("soundNotification")
public class SoundNotification implements INotification {
    @Override
    public void send(String username) {
        System.out.println("Sending sound notification to " + username);
    }
}
