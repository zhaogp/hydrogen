package gp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by zhaogp on 2016/11/20.
 */
public class TimePrinter implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone, the time is "+ new Date());
        Toolkit.getDefaultToolkit().beep();
    }
}
