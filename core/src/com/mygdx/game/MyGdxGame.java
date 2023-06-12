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
	private ShapeRenderer shapeRenderer;
	private int x=0;
	private int y=0;
	private Snake snake;



	@Override
	public void create () {
		this.shapeRenderer = new ShapeRenderer();
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
		shapeRenderer.setColor(80 / 255.0f, 80 / 255.0f, 50 / 255.0f, 1);
		shapeRenderer.rect(snake.getX_pos(), snake.getY_pos(), squareOfScreen, squareOfScreen);
		snakeMove();

		batch.begin();
		batch.end();
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

		shapeRenderer.rect(x, y, squareOfScreen, squareOfScreen);
		shapeRenderer.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
