package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.ScreenUtils;

import static java.lang.Thread.sleep;

public class MyGdxGame extends ApplicationAdapter {



    private int widthScreen;
    private int heightScreen;
    private int squareOfScreen = 10;
    private OrthographicCamera orthographicCamera;
    private ShapeRenderer shapeRenderer;
    private ShapeRenderer foodRender;
    private Snake snake;
    private Food food;



    @Override
    public void create() {
        this.shapeRenderer = new ShapeRenderer();
        this.foodRender = new ShapeRenderer();
        this.widthScreen = Gdx.graphics.getWidth();
        this.heightScreen = Gdx.graphics.getHeight();
        this.orthographicCamera = new OrthographicCamera();
        this.orthographicCamera.setToOrtho(false, widthScreen, heightScreen);
        this.snake = new Snake(squareOfScreen);
        this.food = new Food(squareOfScreen, this.widthScreen, this.heightScreen);


    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        foodRender.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setProjectionMatrix(orthographicCamera.combined);

        speedSnake();
        food.drawFood(foodRender);
        snake.drawSnake(shapeRenderer);
        snake.snakeMove();
        clearScreen();

        shapeRenderer.end();
        foodRender.end();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }

    private void speedSnake() {
        try {
            sleep(80);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
