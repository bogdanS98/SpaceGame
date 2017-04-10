package com.bogdan.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class GameObject extends Image{

    private Rectangle rectangle;

    public GameObject(Texture texture, float x, float y){
        super(texture);
        rectangle = new Rectangle(x, y, getWidth(), getHeight());
        setPosition(x, y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        rectangle.setPosition(getX(), getY());
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
