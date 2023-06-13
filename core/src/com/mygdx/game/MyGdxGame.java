package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import static java.lang.Thread.sleep;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	private int widthScreen, heightScreen;
	private float squareOfScreen = 25;
	private OrthographicCamera orthographicCamera;
	private ShapeRenderer shapeRenderer;
	private ShapeRenderer shapeRenderer2;
	private float x=0;
	private float y=0;
	private Snake snake;
	private int switchDigit=22;



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

		shapeRenderer2.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer2.setColor(70 / 255.0f, 60 / 255.0f, 40 / 255.0f, 1);
		shapeRenderer2.rect(100,100,50,50);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(80 / 255.0f, 80 / 255.0f, 50 / 255.0f, 1);
		shapeRenderer.rect(snake.getX_pos(), snake.getY_pos(), squareOfScreen, squareOfScreen);

		try {
			sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		shapeRenderer.setProjectionMatrix(orthographicCamera.combined);
    	// TODO move this method to snake class
		snakeMove(this.switchDigit);
		System.out.println(this.switchDigit);
//		try {
//			sleep(250);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}



//		shapeRenderer.rect(x, y, squareOfScreen, squareOfScreen);



	}

	private void clearScreen() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

//	TODO: try refactor it
	private void snakeMove(int switchDigit){

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) ) {
			this.switchDigit = 21;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) ){
			this.switchDigit = 22;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP) ) {
			this.switchDigit = 19;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN) ){
			this.switchDigit = 20;
		}

		switch(switchDigit) {
			case 21:
				snake.setX_pos((snake.getX_pos() + -squareOfScreen));
				this.x = snake.getX_pos();
				break;
			case 22:
				snake.setX_pos((snake.getX_pos() + squareOfScreen));
				this.x = snake.getX_pos();
				break;
			case 19:
				snake.setY_pos((snake.getY_pos() + squareOfScreen));
				this.y = snake.getY_pos();
				break;
			case 20:
				snake.setY_pos((snake.getY_pos() + -squareOfScreen));
				this.y = snake.getY_pos();
				break;
		}
		shapeRenderer.rect(x, y, squareOfScreen, squareOfScreen);
		shapeRenderer2.end();
		shapeRenderer.end();


//		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) ) {
//			snake.setX_pos((snake.getX_pos() + -squareOfScreen));
//			this.x = snake.getX_pos();
//		}
//		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) ){
//			snake.setX_pos((snake.getX_pos() + squareOfScreen));
//			this.x = snake.getX_pos();
//		}
//		if (Gdx.input.isKeyPressed(Input.Keys.UP) ) {
//			snake.setY_pos((snake.getY_pos() + squareOfScreen));
//			this.y = snake.getY_pos();
//		}
//		if (Gdx.input.isKeyPressed(Input.Keys.DOWN) ){
//			snake.setY_pos((snake.getY_pos() + -squareOfScreen));
//			this.y = snake.getY_pos();
//		}


	}

	@Override
	public void dispose () {
		batch.dispose();
		shapeRenderer.dispose();
	}
}
