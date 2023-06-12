package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Snake {

    private int x_pos;
    private int y_pos;
    private ShapeRenderer shapeRenderer;
    private int squareOfScreen;

    public Snake(int x_pos, int y_pos, ShapeRenderer shapeRenderer, int squareOfScreen) {
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.shapeRenderer = shapeRenderer;
    }

    public int getX_pos() {
        return x_pos;
    }

    public void setX_pos(int x_pos) {
        this.x_pos = x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }

    public void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }

    public int getSquareOfScreen() {
        return squareOfScreen;
    }

    public void setSquareOfScreen(int squareOfScreen) {
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
