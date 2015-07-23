package com.samhaves.particulars.main;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by samhaves on 15-05-06.
 */
public class StickyEnemy extends GameObject {

    private Handler handler;
    private final int MAX_SPEED = 2;
    private int x1,y1,x2,y2;


    public StickyEnemy(int x, int y, ObjectId id, Handler handler){
        super(x,y,id);
        this.handler = handler;

    }

    public void tick(LinkedList<GameObject> object) {

        x += velX;
        y += velY;

        for(int i = 0 ; i < handler.object.size(); i ++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ObjectId.Player) {

                if(tempObject.x + 9 > x){
                    x += 2;
                }
                if(tempObject.y +9 > y){
                    y += 2;
                }
                if(tempObject.x + 9 < x){
                    x -= 2;
                }
                if(tempObject.y + 9< y){
                    y -= 2;
                }

            }
        }

        if(x + 16 >= Game.WIDTH || x <= 0) velX = -velX;
        if(y + 36 >= Game.HEIGHT || y <= 0) velY = -velY; // oddly 36 seems to be the best for the bottom border

        handler.addObject(new Trail(x, y, ObjectId.Trail, handler,0.009f, 16, 16,Color.blue ));

    }

    public void render(Graphics g) {
       // g.setColor(Color.blue); dont need because of how trail is rendered
        g.fillRect(x, y, 16, 16);
        g.drawLine(x1,y1,x2,y2);

    }


    public Rectangle getBounds() {
        return new Rectangle(x,y,16, 16);
    }

    private int calcVel(GameObject player, char direction){
        double deltaX = player.x - x;
        double deltaY = player.y - y;
        double angle = Math.tan(deltaY / deltaX);

        x1 = x;
        x2 = player.x;
        y1 = y;
        y2 = player.y;

        if(direction == 'x'){
            return (int) Math.round(MAX_SPEED * Math.cos(angle));
        }else if(direction == 'y'){
            return (int) Math.round(MAX_SPEED * Math.sin(angle));
        }else{
            return 0;
        }
    }

}
