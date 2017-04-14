package com.bogdan.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

public class Ship extends GameObject{

    private float x;
    private boolean isAlive;
    private float velocity = 250f;
    private long lastFire;

    public Ship(Texture texture, float x, float y) {
        super(texture, x, y);
        isAlive  = true;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        float dirX = Gdx.input.getAccelerometerX();

        if(Gdx.input.isTouched()){
            if(TimeUtils.millis() - lastFire >= 300){
                AssetLoader.missileSound.play();
                Missile missile = new Missile(AssetLoader.missile, getX()+getWidth()/2-10, getY()+getHeight(), 300);
                getStage().addActor(missile);
                lastFire = TimeUtils.millis();
            }
        }

        x = getX();
        if(dirX == 0){
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                x -= delta * velocity;

            }
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                x += delta * velocity;
            }
        }else{
            if(dirX < 0)
                x += delta * velocity;
            else
                x -= delta * velocity;
        }

        if(x<=0)
            x = 0;
        else if(x>=AssetLoader.HEIGHT-getWidth())
            x = AssetLoader.HEIGHT-getWidth();
        setPosition(x, 0);
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}
