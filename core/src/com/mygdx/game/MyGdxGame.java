package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import static java.lang.Thread.sleep;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	private int widthScreen, heightScreen;
	private int squareOfScreen = 50;
	private OrthographicCamera orthographicCamera;
	private ShapeRenderer shapeRenderer;
	private ShapeRenderer shapeRenderer2;
	private int x=0;
	private int y=0;
	private Snake snake;



	@Override
	public void create () {
		Gdx.graphics.setContinuousRendering(true);
		this.shapeRenderer = new ShapeRenderer();
		this.shapeRenderer2 = new ShapeRenderer();
		this.widthScreen = Gdx.graphics.getWidth();
		this.heightScreen = Gdx.graphics.getHeight();
		this.orthographicCamera = new OrthographicCamera();
		this.orthographicCamera.setToOrtho(false, widthScreen, heightScreen);
		batch = new SpriteBatch();
		this.snake = new Snake(x ,y, shapeRenderer, squareOfScreen);

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer2.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(80 / 255.0f, 80 / 255.0f, 50 / 255.0f, 1);
		shapeRenderer2.setColor(70 / 255.0f, 60 / 255.0f, 40 / 255.0f, 1);
		shapeRenderer2.rect(100,100,50,50);
		shapeRenderer.rect(snake.getX_pos(), snake.getY_pos(), squareOfScreen, squareOfScreen);
		snakeMove();
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		shapeRenderer.setProjectionMatrix(orthographicCamera.combined);


		snake.setX_pos((snake.getX_pos() + squareOfScreen));
		this.x = snake.getX_pos();
		shapeRenderer.rect(x, y, squareOfScreen, squareOfScreen);
		snakeMove();
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		Gdx.gl.glClearColor(0, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shapeRenderer.rect(x, y, squareOfScreen, squareOfScreen);
		shapeRenderer2.end();
		shapeRenderer.end();

	}

	private void clearScreen() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

//	TODO: try refactor it
	private void snakeMove(){

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) ) {
			snake.setX_pos((snake.getX_pos() + -squareOfScreen));
			this.x = snake.getX_pos();
			shapeRenderer.rect(x, y, squareOfScreen, squareOfScreen);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) ){
			snake.setX_pos((snake.getX_pos() + squareOfScreen));
			this.x = snake.getX_pos();
			shapeRenderer.rect(x, y, squareOfScreen, squareOfScreen);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP) ) {
			snake.setY_pos((snake.getY_pos() + squareOfScreen));
			this.y = snake.getY_pos();
			shapeRenderer.rect(x, y, squareOfScreen, squareOfScreen);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN) ){
			snake.setY_pos((snake.getY_pos() + -squareOfScreen));
			this.y = snake.getY_pos();
			shapeRenderer.rect(x, y, squareOfScreen, squareOfScreen);
		}


	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
