package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class Snake {

    private final ArrayList<Point> snakeBody = new ArrayList<>();
    private final int squareOfScreen;
    private int x_pos = 0;
    private int y_pos = 0;
    private int switchDigit = 22;

    public Snake(int squareOfScreen) {
        snakeBody.add(new Point(this.x_pos, this.y_pos));
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
        for (Point point : snakeBody) {
            shapeRenderer.setColor(80 / 255.0f, 80 / 255.0f, 50 / 255.0f, 1);
            shapeRenderer.rect(point.getX(), point.getY(), squareOfScreen, squareOfScreen);
        }
    }

    public boolean isCollisionWithFood(Food food) {
        Point headSnake = snakeBody.get(snakeBody.size() - 1);
        return headSnake.getX() == food.getX_pos() && headSnake.getY() == food.getY_pos();
    }

    public void updateSnakeBody(Food food) {
        snakeMove();
        boolean isColl = isCollisionWithFood(food);
        if (isColl) {
            snakeBody.add(new Point(this.x_pos, this.y_pos));
            food.newFoodPosition();
        }
        snakeBody.remove(snakeBody.get(0));
    }

    public void snakeMove() {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && switchDigit != 22) {
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
        snakeBody.add(new Point(this.x_pos, this.y_pos));
    }
}
