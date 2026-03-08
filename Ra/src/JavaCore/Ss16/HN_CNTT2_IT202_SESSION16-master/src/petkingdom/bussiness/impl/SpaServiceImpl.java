package petkingdom.bussiness.impl;

import petkingdom.model.ServiceRecord;

import java.util.LinkedList;
import java.util.Queue;

public class SpaServiceImpl {

    private Queue<ServiceRecord> queue = new LinkedList<>();

    public void enqueue(ServiceRecord record) {
        queue.offer(record);
    }

    public void processNext() {
        ServiceRecord record = queue.poll();
        //poll tra ve null neu rong
        if (record == null) {
            System.out.println("Không có thú cưng nào đang chờ đợi.");
        } else {
            System.out.println(record.toString());
        }
    }

    public void showWaitingList() {
        for (ServiceRecord p : queue) {
            System.out.println(p.toString());
        }
    }
}