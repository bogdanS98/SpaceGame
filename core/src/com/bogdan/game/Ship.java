package com.bogdan.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.TimeUtils;

public class Ship extends GameObject{

    private float x;
    private boolean isAlive;
    private float velocity = 250f;
    private long lastFire;

    private static final int FRAME_COLS = 1;
    private static final int FRAME_ROWS = 3;

    private Animation shipAnimation;
    private TextureRegion[] shipFrames;
    private TextureRegion currentFrame;
    private SpriteBatch batch;
    private float stateTime;

    private enum States{
        FRAME1, FRAME2, FRAME3
    }

    public Ship(Texture texture, float x, float y) {
        super(texture, x, y);
        isAlive  = true;
    }

    public void createAnimation(){
        TextureRegion[][] tmp;
        tmp = TextureRegion.split(AssetLoader.shipTexture, AssetLoader.shipTexture.getWidth() / FRAME_COLS,
                AssetLoader.shipTexture.getHeight() / FRAME_ROWS);
        shipFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                shipFrames[index++] = tmp[i][j];
            }
        }
        shipAnimation = new Animation(0.025f, shipFrames);
        batch = new SpriteBatch();
        stateTime = 0f;
        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = shipAnimation.getKeyFrame(stateTime, true);
        batch.begin();
        batch.draw(currentFrame, 50, 50);
        batch.end();
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
