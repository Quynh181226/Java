package Demo;

import javax.swing.*;   // Thư viện Swing dùng cho giao diện người dùng (GUI)
import java.awt.*;      // Thư viện hỗ trợ layout và màu sắc

public class JPanelDemo1 {
    public static void main(String[] args) {
        // 🔹 Tạo cửa sổ chính (JFrame)
        JFrame frame = new JFrame("JPanel Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Thoát chương trình khi đóng cửa sổ
        frame.setSize(400, 300);                              // Kích thước cửa sổ
        frame.setLayout(new BorderLayout());                  // Layout chính của frame

        // 🔹 Tạo JPanel thứ 1 – sử dụng FlowLayout (mặc định)
        JPanel panel1 = new JPanel();                         // Khởi tạo JPanel
        panel1.setBackground(Color.CYAN);                     // Đặt màu nền cho panel
        panel1.add(new JLabel("Panel 1"));                    // Thêm nhãn (label)
        panel1.add(new JButton("Button 1"));                  // Thêm nút bấm
        panel1.add(new JButton("Button 2"));                  // Thêm nút bấm thứ 2

        // 🔹 Tạo JPanel thứ 2 – sử dụng GridLayout (2 hàng, 2 cột)
        JPanel panel2 = new JPanel(new GridLayout(2, 2, 5, 5)); // Tham số (rows, cols, hgap, vgap)
        panel2.setBackground(Color.PINK);                     // Đặt màu nền
        panel2.add(new JLabel("A"));                          // Thêm 4 label
        panel2.add(new JLabel("B"));
        panel2.add(new JLabel("C"));
        panel2.add(new JLabel("D"));

        // 🔹 Tạo JPanel thứ 3 – sử dụng BorderLayout
        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBackground(Color.LIGHT_GRAY);               // Đặt màu nền
        panel3.add(new JLabel("Center", JLabel.CENTER), BorderLayout.CENTER); // Thành phần ở giữa
        panel3.add(new JButton("North"), BorderLayout.NORTH); // Nút phía trên
        panel3.add(new JButton("South"), BorderLayout.SOUTH); // Nút phía dưới

        // 🔹 Thêm các panel vào frame chính
        frame.add(panel1, BorderLayout.NORTH);   // panel1 ở phía trên
        frame.add(panel2, BorderLayout.CENTER);  // panel2 ở giữa
        frame.add(panel3, BorderLayout.SOUTH);   // panel3 ở phía dưới

        // 🔹 Hiển thị cửa sổ
        frame.setVisible(true);
    }
}

//JPanel được dùng để nhóm các component lại với nhau.
//Có thể dùng nhiều LayoutManager khác nhau (FlowLayout, GridLayout, BorderLayout, …).
//Dùng add() để thêm component vào JPanel.
//Sau đó, thêm các JPanel vào JFrame để hiển thị.

//JPanel là container để gom nhóm các component (Label, Button, TextField, …).
//Có thể đặt layout riêng cho từng JPanel → dễ dàng chia bố cục giao diện.
//JFrame chứa các JPanel như các vùng (NORTH, CENTER, SOUTH trong BorderLayout).
//Các panel có thể lồng vào nhau giúp giao diện linh hoạt hơn.