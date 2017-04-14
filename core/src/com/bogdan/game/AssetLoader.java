package com.bogdan.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class AssetLoader {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 650;
    public static Texture alien;
    public static Texture missile;
    //public static String starfighter = "Starfighter.png";

    public static Texture background;
    public static Texture shipTexture;
    public static Sprite backgroundSprite;

    public static Sound missileSound;
    public static Sound explosionSound;
    public static Music fightSound;

    public static void init(){
        shipTexture = new Texture(Gdx.files.internal("Starfighter.png"));
        alien = new Texture(Gdx.files.internal("alien.png"));
        missile = new Texture(Gdx.files.internal("missile.png"));
        background = new Texture(Gdx.files.internal("stars.jpg"));
        backgroundSprite = new Sprite(background);
        missileSound = Gdx.audio.newSound(Gdx.files.internal("missile.wav"));
        explosionSound = Gdx.audio.newSound(Gdx.files.internal("explosion.wav"));
        fightSound = Gdx.audio.newMusic(Gdx.files.internal("fight.wav"));
        fightSound.setVolume(0.2f);
    }

    public static void dispose(){
        missileSound.dispose();
        explosionSound.dispose();
        fightSound.dispose();
    }
}
