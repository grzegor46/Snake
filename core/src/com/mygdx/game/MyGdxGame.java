package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import static java.lang.Thread.sleep;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    private int widthScreen, heightScreen;
    private final float squareOfScreen = 10;
    private OrthographicCamera orthographicCamera;
    private ShapeRenderer shapeRenderer;
    private final float x = 0;
    private final float y = 0;
    private Snake snake;
    private final int switchDigit = 0;


    @Override
    public void create() {
        this.shapeRenderer = new ShapeRenderer();
        this.widthScreen = Gdx.graphics.getWidth();
        this.heightScreen = Gdx.graphics.getHeight();
        this.orthographicCamera = new OrthographicCamera();
        this.orthographicCamera.setToOrtho(false, widthScreen, heightScreen);
        this.snake = new Snake(shapeRenderer, squareOfScreen);

    }

    @Override
    public void render() {

        ScreenUtils.clear(0, 0, 0, 1);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setProjectionMatrix(orthographicCamera.combined);
        speedSnake();
        snake.drawSnake(shapeRenderer);
        snake.snakeMove();
        shapeRenderer.end();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void dispose() {
        batch.dispose();
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
