package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Snake {

    private float x_pos;
    private float y_pos;
    private ShapeRenderer shapeRenderer;
    private float squareOfScreen;

    public Snake(float x_pos, float y_pos, ShapeRenderer shapeRenderer, float squareOfScreen) {
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.shapeRenderer = shapeRenderer;
    }

    public float getX_pos() {
        return x_pos;
    }

    public void setX_pos(float x_pos) {
        this.x_pos = x_pos;
    }

    public float getY_pos() {
        return y_pos;
    }

    public void setY_pos(float y_pos) {
        this.y_pos = y_pos;
    }

    public float getSquareOfScreen() {
        return squareOfScreen;
    }

    public void setSquareOfScreen(float squareOfScreen) {
        this.squareOfScreen = squareOfScreen;
    }

    public void snakeMove(){
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) ) {
            this.x_pos = squareOfScreen + -squareOfScreen;
            shapeRenderer.rect(x_pos, y_pos, squareOfScreen, squareOfScreen);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) ){
            this.x_pos = squareOfScreen;
            shapeRenderer.rect(x_pos, y_pos, squareOfScreen, squareOfScreen);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) ) {
            this.y_pos = squareOfScreen;
            shapeRenderer.rect(x_pos, y_pos, squareOfScreen, squareOfScreen);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) ){
            this.y_pos = squareOfScreen + -squareOfScreen;
            shapeRenderer.rect(x_pos, y_pos, squareOfScreen, squareOfScreen);
        }

        shapeRenderer.rect(x_pos, y_pos, squareOfScreen, squareOfScreen);
        shapeRenderer.end();
    }
}
