/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giatk.dtos;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Kha Gia
 */
public class Time extends Thread{

    @Override
    public void run() {
        super.run();
        while(true){
            try {
                giatk.ui.Main.lbDisplay.setText(new StringTokenizer(java.time.LocalTime.now().toString(), ".").nextToken());
                Thread.sleep(100);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
    
}
