package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Snake {

    private int x_pos=0;
    private int y_pos=0;
    private int squareOfScreen;
    private int switchDigit = 22;

    public Snake(int squareOfScreen) {

        this.squareOfScreen = squareOfScreen;
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

    public void drawSnake(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(80 / 255.0f, 80 / 255.0f, 50 / 255.0f, 1);
        shapeRenderer.rect(this.x_pos,this.y_pos,squareOfScreen,squareOfScreen);
    }

    public void snakeMove() {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && switchDigit !=22) {
            System.out.println(Gdx.input.isKeyPressed(Input.Keys.LEFT));
            switchDigit = 21;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && switchDigit != 21) {
            System.out.println(Gdx.input.isKeyPressed(Input.Keys.RIGHT));
            switchDigit = 22;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) && switchDigit != 20) {
            System.out.println(Gdx.input.isKeyPressed(Input.Keys.UP));
            switchDigit = 19;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && switchDigit != 19) {
            System.out.println(Gdx.input.isKeyPressed(Input.Keys.DOWN));
            switchDigit = 20;
        }

        switch (switchDigit) {
            case 21:
                setX_pos((getX_pos() + -squareOfScreen));
                this.x_pos = getX_pos();
                break;
            case 22:
                setX_pos((getX_pos() + squareOfScreen));
                this.x_pos = getX_pos();
                break;
            case 19:
                setY_pos((getY_pos() + squareOfScreen));
                this.y_pos = getY_pos();
                break;
            case 20:
                setY_pos((getY_pos() + -squareOfScreen));
                this.y_pos = getY_pos();
                break;
        }
    }
}
