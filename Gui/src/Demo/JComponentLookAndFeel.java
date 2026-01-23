package Demo;

import javax.swing.*;

public class JComponentLookAndFeel {
    public static void main(String[] args) {
        try {
            UIManager.getCrossPlatformLookAndFeelClassName();
        }catch (Exception e){
            //...
        }
        //Create and show the Gui
        new JComponentLookAndFeel();
    }
}
///????