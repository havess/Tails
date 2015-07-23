package com.samhaves.particulars.main;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by samhaves on 15-05-06.
 */
public class BasicEnemy extends GameObject {

    private Handler handler;


    public BasicEnemy(int x, int y, ObjectId id, Handler handler){
        super(x,y,id);
        this.handler = handler;
        velX = 5;
        velY = 5;
    }

    public void tick(LinkedList<GameObject> object) {
        x += velX;
        y += velY;

        if(x + 16 >= Game.WIDTH || x <= 0) velX = -velX;
        if(y + 36 >= Game.HEIGHT || y <= 0) velY = -velY; // oddly 36 seems to be the best for the bottom border

        handler.addObject(new Trail(x, y, ObjectId.Trail, handler,0.03f, 16, 16,Color.red ));

    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect( x, y, 16, 16 );
    }


    public Rectangle getBounds() {
        return new Rectangle(x,y,16, 16);
    }
}
