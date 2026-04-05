package com.example.Ss1.Th;

import com.example.Ss1.Th.INotification;
import org.springframework.stereotype.Component;

@Component("popupNotification")
public class PopupNotification implements INotification {
    @Override
    public void send(String username) {
        System.out.println("Sending popup notification to " + username);
    }
}
