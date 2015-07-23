package com.samhaves.particulars.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by samhaves on 15-05-06.
 */
public class KeyInput extends KeyAdapter{

    private Handler handler;

    public KeyInput (Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ObjectId.Player) {
                if(key == KeyEvent.VK_D){
                    tempObject.setVelocityX(5);
                }
                if(key == KeyEvent.VK_A){
                    tempObject.setVelocityX(-5);
                }
                if(key == KeyEvent.VK_W ){
                    tempObject.setVelocityY(-5);
                }
                if( key == KeyEvent.VK_S){
                    tempObject.setVelocityY(5);
                }

            }

            if(key == KeyEvent.VK_ESCAPE){
                System.exit(1);
            }
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ObjectId.Player) {
                if(key == KeyEvent.VK_D){
                    tempObject.setVelocityX(0);
                }
                if(key == KeyEvent.VK_A){
                    tempObject.setVelocityX(0);
                }
                if(key == KeyEvent.VK_W ){
                    tempObject.setVelocityY(0);
                }
                if( key == KeyEvent.VK_S){
                    tempObject.setVelocityY(0);
                }

            }
        }
    }
}
