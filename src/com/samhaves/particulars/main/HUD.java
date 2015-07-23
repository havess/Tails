package com.samhaves.particulars.main;

import java.awt.*;

/**
 * Created by samhaves on 15-05-06.
 */
public class HUD {


    public static int HEALTH = 100;

    private int score = 0, level = 1;

    public void tick(){
        HEALTH = Game.clamp(HEALTH, 0, 100);
        score++;

    }

    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect(15,15,200,34);
        g.setColor(Color.gray);
        g.drawRect(14,15, 202, 34);
        g.setColor(Color.green);
        g.fillRect(15,16,HEALTH * 2, 32);

        g.drawString("Score: " + score + " Level: " + level, 15, 66);

    }

    public void score(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public void level(int level){
        this.level = level;
    }

    public int getLevel(){
        return level;
    }
}
