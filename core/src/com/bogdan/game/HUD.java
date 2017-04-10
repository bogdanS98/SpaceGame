package com.bogdan.game;


import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class HUD extends ScreenAdapter{

    private Color color;
    private BitmapFont font;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer  = new ShapeRenderer();
    private int greenValue = 255;
    private int score = 0;
    private int level = 1;
    public static int HEALTH = 100;

    public HUD(){
        //draw();
        HEALTH = limits(HEALTH, 0, 100);
        greenValue = limits(greenValue, 0, 255);
        greenValue = HEALTH * 2;
        score++;
    }

    /*public void draw(){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GRAY);
        shapeRenderer.rect(15, 15, 200, 32);
        shapeRenderer.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(75, greenValue, 0, 1);
        shapeRenderer.rect(15, 15, HEALTH*2, 32);
        shapeRenderer.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(15, 15, 200, 32);
        shapeRenderer.end();
    }*/

    public static int limits(int var, int min, int max){
        if(var >= max)
            return var = max;
        else if(var <= min)
            return var = min;
        else return var;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void dispose() {
        super.dispose();
        //shapeRenderer.dispose();
    }
}
