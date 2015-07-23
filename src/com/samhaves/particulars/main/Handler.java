package com.samhaves.particulars.main;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by samhaves on 15-05-06.
 */
public class Handler {

    public LinkedList<GameObject> object = new LinkedList<GameObject>();


    public void tick() {
        for(int i = 0; i < object.size(); i++){
            GameObject object = this.object.get(i);
            object.tick(this.object);
        }
    }

    public void render(Graphics g) {
        for(int i = 0; i < object.size();i++){
            GameObject object = this.object.get(i);
            object.render(g);
        }
    }

    public void addObject(GameObject object){
        this.object.add(object);
    }

    public void removeObject (GameObject object){
        this.object.remove(object);
    }
}
