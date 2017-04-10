package com.bogdan.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class StartScreen extends ScreenAdapter{

    private SpriteBatch batch;
    private BitmapFont font;
    private GameMain game;

    public StartScreen(GameMain game){
        this.game = game;
        batch = new SpriteBatch();
        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(Gdx.input.isTouched())
            game.setScreen(new GameRenderer(game));
        batch.begin();
        font.setScale(3f);
        font.draw(batch, "SPACE GAME", 185, 400);
        font.setScale(1.5f);
        font.draw(batch, "PRESS TO CONTINUE", 210, 350);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
