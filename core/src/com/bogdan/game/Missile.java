package com.bogdan.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Missile extends GameObject{

    private float velocity;

    public Missile(Texture texture, float x, float y, float velocity) {
        super(texture, x, y);
        this.velocity = velocity;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        moveBy(0, velocity * delta);

        if(getY() > AssetLoader.HEIGHT)
            remove();
        else{
            for(Actor a : GameRenderer.aliens.getChildren()){
                Alien alien = (Alien) a;
                if(getRectangle().overlaps(alien.getRectangle())){
                    AssetLoader.explosionSound.play();
                    alien.clear();
                    alien.remove();
                    clear();
                    remove();
                }
            }
        }
    }
}
