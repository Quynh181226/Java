package petkingdom.bussiness.impl;

import java.util.Stack;

public class HistoryServiceImpl {

    private Stack<String> logs = new Stack<>();

    public void push(String action) {
        logs.push(action);
    }

    public void undo() {
        if (logs.isEmpty()) {
            System.out.println("Không có thao tác nào để hoàn tác.");
        } else {
            System.out.println("Undo: " + logs.pop());
        }
    }

    public void showRecent() {
        if (!logs.isEmpty()) {
            System.out.println("Latest: " + logs.peek());
        }
    }
}