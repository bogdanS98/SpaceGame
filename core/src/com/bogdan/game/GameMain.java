package com.bogdan.game;

import com.badlogic.gdx.Game;

public class GameMain extends Game {

	@Override
	public void create () {
        AssetLoader.init();
        setScreen(new StartScreen(this));
	}

    @Override
    public void dispose(){
        super.dispose();
        AssetLoader.dispose();
    }
}
