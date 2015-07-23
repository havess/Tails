package com.samhaves.particulars.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;//16:9 aspect ratio
    private Thread thread;
    private boolean running = false;

    private Random r;

    private Handler handler;

    private HUD hud;

    private Spawn spawner;

    public Game(){
        handler = new Handler();

        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Particulars", this);

        r = new Random();
        hud = new HUD();
        spawner = new Spawn(handler, hud);


        handler.addObject(new Player(WIDTH/2 -32, HEIGHT / 2 -32, handler, ObjectId.Player));
        handler.addObject(new BasicEnemy(r.nextInt(WIDTH - 32), r.nextInt(HEIGHT - 32), ObjectId.BasicEnemy, handler));



    }

    public static void main(String[] args){
        new Game();
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(InterruptedException e ){
            e.printStackTrace();
        }
    }

    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames + " TICKS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();

        if(bs == null){
			/*creates a "3 screen(main + 2 background)" buffer for faster update load ins
			 * this is the general max for most computers*/
            this.createBufferStrategy(3);
            return;

        }

        Graphics g = bs.getDrawGraphics();
        /////////////////////////////////

        //Draw everything for game here
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());

        handler.render(g);//renders everything
        hud.render(g);

        /////////////////////////////////

        g.dispose();
        bs.show();

    }

    private void tick(){
        handler.tick();
        hud.tick();
        spawner.tick();
    }

    public static int clamp(int variable, int min, int max){
        if(variable >= max){
            return variable = max;
        }else if(variable <= min){
            return variable = min;
        }else{
            return variable;
        }
    }
}
