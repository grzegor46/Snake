package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	private int widthScreen, heightScreen;
	private int squareOfScreen = 50;
	private OrthographicCamera orthographicCamera;
	private ShapeRenderer snakeShape;
	private float x=0;
	private float y=0;



	@Override
	public void create () {
		this.snakeShape = new ShapeRenderer();
		this.widthScreen = Gdx.graphics.getWidth();
		this.heightScreen = Gdx.graphics.getHeight();
		this.orthographicCamera = new OrthographicCamera();
		this.orthographicCamera.setToOrtho(false, widthScreen, heightScreen);
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		snakeShape.begin(ShapeRenderer.ShapeType.Filled);
		snakeShape.setColor(80 / 255.0f, 80 / 255.0f, 50 / 255.0f, 1);
		snakeShape.rect(x, y, squareOfScreen, squareOfScreen);
		snakeMove();

		batch.begin();
		batch.end();
	}


//	TODO: try refactor it
	private void snakeMove(){
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) ) {
			this.x = squareOfScreen-50;
			snakeShape.rect(x, y, squareOfScreen, squareOfScreen);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) ){
			this.x = squareOfScreen;
			snakeShape.rect(x, y, squareOfScreen, squareOfScreen);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP) ) {
			this.y = squareOfScreen;
			snakeShape.rect(x, y, squareOfScreen, squareOfScreen);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN) ){
			this.y = squareOfScreen-50;
			snakeShape.rect(x, y, squareOfScreen, squareOfScreen);
		}

		snakeShape.rect(x, y, squareOfScreen, squareOfScreen);
		snakeShape.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
