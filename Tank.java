package com.Tank;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * Created by chao-shu on 17-3-2.
 */
public class Tank extends Frame{
        public static void main(String[] args) {
            new Tank().launchFrame();

        }
        private int x=50;
        private int y=50;

        public void launchFrame(){

            this.setTitle("坦克大战");
            this.setLocation(300, 400);
            this.setSize(300, 400);
            //this.setBackground(Color.RED);
//            this.getContentPane().setBackground(Color.GREEN);
            this.setBackground(Color.GRAY);
            //为关闭窗口添加响应
            this.addWindowListener(new WindowAdapter(){

                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }

            });
            new Thread(new MyRepaint()).start();
            this.addKeyListener(new KeyMonitor());
            //设置是否允许用户改变窗口的大小，这里限制下，不允许
            this.setResizable(false);
            this.setVisible(true);
        }

    //问题 为何未调用此函数，还会起作用
        public void paint(Graphics g) {
            Color c = g.getColor();
            g.setColor(Color.RED);
            g.fillOval(x, y, 10, 10);
            g.setColor(c);
//            y+=5;//该表坦克的位置

        }
    private class MyRepaint implements Runnable{
        public void run() {
            while (true) {
                //每50ms重画一次
                repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
            }
        }
    private class KeyMonitor extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            int key=e.getKeyCode();
            switch(key){
                case KeyEvent.VK_LEFT:
                    x -= 5;
                    break;
                case KeyEvent.VK_UP:
                    y -= 5;
                    break;
                case KeyEvent.VK_RIGHT:
                    x += 5;
                    break;
                case KeyEvent.VK_DOWN:
                    y += 5;
                    break;
            }
        }


    }



}
