package Demo;

import javax.swing.*;
import java.awt.*;

public class JTabbedPaneDemo extends JFrame {
    //swing
    JTabbedPane jtp;
   public JTabbedPaneDemo() {
       super("JTabbedPane Demo");
       setSize(200, 200);
       //awt
       Container contents=getContentPane();
       jtp = new JTabbedPane();
       jtp.addTab("Tab1", new JLabel("This is tab one"));
       jtp.addTab("Tab2", new JButton("This is tab two"));
       jtp.addTab("Tab3", new JCheckBox("This is tab three"));
       contents.add(jtp);

       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
   }

   public static void main(String[] args) {
       new JTabbedPaneDemo();
   }
}
