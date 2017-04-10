package com.bogdan.game;


import com.badlogic.gdx.graphics.Texture;

public class Alien extends GameObject{

    public Alien(Texture texture, float x, float y) {
        super(texture, x, y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(getRectangle().overlaps(GameRenderer.ship.getRectangle())){
            GameRenderer.ship.setIsAlive(false);
        }
    }
}
