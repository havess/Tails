package com.samhaves.particulars.main;


import java.awt.*;
import java.util.LinkedList;

public abstract class GameObject {
    protected int x,y;
    protected ObjectId id;
    protected int velX = 0, velY = 0;

    public GameObject(int x, int y, ObjectId id)
    {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick(LinkedList<GameObject> object);
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public int getVelX(){
        return velX;
    }
    public int getVelY(){
        return velY;
    }
    public void setVelocityX(int velX){
        this.velX = velX;
    }
    public void setVelocityY(int velY){
        this.velY = velY;
    }

    public void setId(ObjectId id){
        this.id = id;
    }
    public ObjectId getId(){
        return id;
    }
}
