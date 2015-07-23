package com.samhaves.particulars.main;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by samhaves on 15-05-07.
 */
public class Trail extends GameObject{

    private Handler handler;
    private float alpha = 1;
    private int width, height;
    private float life;
    Color color;


    public Trail(int x, int y, ObjectId id, Handler handler, float life, int width, int height, Color color){
        super(x,y,id);
        this.life = life;
        this.color = color;
        this.width = width;
        this.height = height;
        this.handler = handler;

    }

    public void tick(LinkedList<GameObject> object) {
        if(alpha > life){
            alpha -= (life - 0.0001f);
        }else handler.removeObject(this);
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));

        g.setColor(color);
        g.fillRect(x,y,width , height);

        g2d.setComposite(makeTransparent(1));


    }

    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }

    public Rectangle getBounds() {
        return null;
    }
}
