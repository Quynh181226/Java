package JavaCore.Ss4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//Giả lập việc hệ thống ghi lại lịch sử mượn sách của một sinh viên trong một ngày với số lượng giao dịch lớn
//
//Yêu cầu:
//Tạo một danh sách các giao dịch (Mã sách, Ngày mượn)
//Sử dụng StringBuilder để nối tất cả các giao dịch này thành một báo cáo duy nhất, mỗi giao dịch nằm trên một dòng
//Thêm thời gian hệ thống vào đầu báo cáo
//So sánh thời gian thực thi nếu dùng phép cộng chuỗi + thông thường so với StringBuilder
public class B3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String[] transactions={
            "BK001-20/01",
            "BK005-21/01",
            "BK099-22/01"
        };

        //Create report vs StringBuilder
        // Tạo báo cáo với StringBuilder
        String reportSB = getStringBuilder(transactions);
        System.out.println(reportSB);

        // So sánh thời gian thực thi
        System.out.println("=== SO SÁNH HIỆU NĂNG ===\n");

        // Test StringBuilder (10000 lần)
        long sbTime = time(() -> {
            for (int i = 0; i < 10000; i++) {
                getStringBuilder(transactions);
            }
        });

        // Test String Concatenation (10000 lần)
        long stringTime = time(() -> {
            for (int i = 0; i < 10000; i++) {
                stringNoBuilder(transactions);
            }
        });

        System.out.printf("Số thời gian thực thi dùng StringBuilder: %d ms%n", sbTime);
        System.out.printf("Số thời gian thực thi dùng String: %d ms%n", stringTime);
        System.out.printf("StringBuilder nhanh hơn %.2f lần%n", (double) stringTime / sbTime);
    }
    //Pthuc use phep (+) String
    public static String stringNoBuilder(String[] transactions) {
        String report="--- Báo cáo mượn sách ---\n";
        report +="Ngày tạo: "+LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+"\n";

        for(String t: transactions){
            report+="Giao dịch: "+t+"\n";
        }

        return report;
    }

    //Pthuc use StringBuilder
    private static String getStringBuilder(String[] transactions){
        StringBuilder sb=new StringBuilder();

        sb.append("--- Báo cáo mượn sách ---\n");
        sb.append("Ngày tạo: ")
           .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");

        for (String t: transactions){
            sb.append("Giao dịch: ").append(t).append("\n");
        }

        return sb.toString();
    }

    //Pthuc calculate time thực thi
    public static long time(Runnable task){
        //Ghi lai time start
        //Start work
        //Ghi lai time end
        //Calcu time chenh lech
        //1 ms = 1_000_000 ns
        long start=System.nanoTime();
        task.run();
        long end=System.nanoTime();
        return (end-start)/1000000;
    }
}
