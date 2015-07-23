package com.samhaves.particulars.main;

import java.util.Random;

/**
 * Created by samhaves on 15-05-11.
 */
public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random r = new Random();
    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;

    }

    public void tick(){

        if(scoreKeep >= 100) {
            scoreKeep = 0;
            hud.level(hud.getLevel() + 1);

            switch(hud.getLevel()){
                case 2:
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ObjectId.BasicEnemy, handler));
                    break;
                case 3:
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ObjectId.BasicEnemy, handler));
                    handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ObjectId.BasicEnemy, handler));
                    break;
                case 4:
                    handler.addObject(new StickyEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ObjectId.BasicEnemy, handler));

            }
        }
        scoreKeep++;
    }


}
