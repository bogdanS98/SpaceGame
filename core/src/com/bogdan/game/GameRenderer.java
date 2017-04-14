package com.bogdan.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Timer;

public class GameRenderer extends ScreenAdapter{

    private GameMain game;
    public static Ship ship;
    private Stage stage;
    public static Group aliens;

    private SpriteBatch batch = new SpriteBatch();

    public GameRenderer(GameMain game){
        this.game = game;

        stage = new Stage();

        ship = new Ship(AssetLoader.shipTexture, AssetLoader.HEIGHT/2 - 50, 0);

        stage.addActor(ship);
        aliens = new Group();
        stage.addActor(aliens);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                positionAliens();
            }
        }, 1, 1.5f);

        //AssetLoader.fightSound.play();
    }

    private void positionAliens() {
        float x = MathUtils.random(0, AssetLoader.WIDTH);
        Alien alien = new Alien(AssetLoader.alien, x, AssetLoader.HEIGHT);
        alien.addAction(Actions.sequence(Actions.moveBy(0, - AssetLoader.HEIGHT - alien.getHeight(), 3.0f), Actions.removeActor()));

        aliens.addActor(alien);
    }

    @Override
    public void render(float delta) {
        batch.begin();
        AssetLoader.backgroundSprite.draw(batch);
        batch.end();

        stage.act(delta);
        stage.draw();

        if(!ship.getIsAlive()){
            AssetLoader.fightSound.stop();
            game.setScreen(new GameOverScreen(game));
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        stage.dispose();
    }

}
