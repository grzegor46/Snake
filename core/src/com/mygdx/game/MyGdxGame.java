package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import static java.lang.Thread.sleep;

public class MyGdxGame extends ApplicationAdapter {


    private int widthScreen;
    private int heightScreen;
    private final int squareOfScreen = 10;
    private OrthographicCamera orthographicCamera;
    private ShapeRenderer shapeRenderer;
    private ShapeRenderer foodRender;
    private Snake snake;
    private Food food;
    private SpriteBatch batch;
    private Texture texture;

    @Override
    public void create() {
        texture = new Texture(Gdx.files.internal("game_over_.png"));
        batch = new SpriteBatch();
        this.shapeRenderer = new ShapeRenderer();
        this.foodRender = new ShapeRenderer();
        this.widthScreen = Gdx.graphics.getWidth();
        this.heightScreen = Gdx.graphics.getHeight();
        this.orthographicCamera = new OrthographicCamera();
        this.orthographicCamera.setToOrtho(false, widthScreen, heightScreen);
        this.food = new Food(squareOfScreen, this.widthScreen, this.heightScreen);
        this.snake = new Snake(squareOfScreen, this.widthScreen, this.heightScreen);
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

        snake.updateSnakeBody(this.food);
        if(snake.isGameOver() == 1) {
            batch.begin();
            clearScreen();
            batch.draw(texture, 0, 0);
            Gdx.graphics.setContinuousRendering(false);
            batch.end();
        }
        shapeRenderer.end();
        foodRender.end();

    }

    private void clearScreen() {
        Gdx.gl.glClearColor( 1, 0, 0, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        batch.dispose();
    }

    private void speedSnake() {
        try {
            sleep(80);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
