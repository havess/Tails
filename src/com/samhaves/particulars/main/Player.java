package com.samhaves.particulars.main;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by samhaves on 15-05-06.
 */
public class Player extends GameObject{
    Handler handler;

    public Player(int x, int y, Handler handler, ObjectId id){
        super(x,y,id);
        this.handler = handler;
    }


    public void tick(LinkedList<GameObject> object) {


        x += velX;
        y += velY;

        /*if(x + 32 >= Game.WIDTH || x - 3 <= 0) velX = 0; // could put into a clamp method but meh
        if(y + 60 >= Game.HEIGHT || y  - 2 <= 0) velY = 0;*/

        x = Game.clamp(x, 0,Game.WIDTH - 32);
        y = Game.clamp(y, 0, Game.HEIGHT - 55);

        handler.addObject(new Trail(x, y, ObjectId.Trail, handler,0.05f, 32, 32,Color.white ));
        checkCollision();
    }

    private void checkCollision(){
        for(int i = 0; i < handler.object.size(); i ++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ObjectId.BasicEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 2;
                }
            }
        }
    }
    public void render(Graphics g) {

        g.setColor(Color.white);
        g.drawRect(x, y, 32, 32);
    }

    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
    }
}
