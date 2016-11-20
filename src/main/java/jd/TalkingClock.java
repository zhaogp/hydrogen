package jd;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

/**
 * Created by zhaogp on 2016/11/20.
 */
public class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
        ActionListener listener = new InnerTimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    public class InnerTimePrinter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("inner class demo, now() is "+new Date());
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}
