package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Food {

    private int x_pos;
    private int y_pos;
    private int widthScreen;
    private int heightScreen;
    private int squareOfScreen;

    public Food( int squareOfScreen, int widthScreen, int heightScreen) {
        this.widthScreen = widthScreen;
        this.heightScreen = heightScreen;
        this.squareOfScreen = squareOfScreen;
        this.x_pos=((int)((Math.random() * (widthScreen/squareOfScreen))) * squareOfScreen);
        this.y_pos=((int)((Math.random() * (heightScreen/squareOfScreen))) * squareOfScreen);
    }

    public void drawFood(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(255, 0, 0, 0);
        shapeRenderer.rect(this.x_pos,this.y_pos,squareOfScreen,squareOfScreen);
    }

    public void newFoodPosition(){
        this.x_pos=(((int)(Math.random() * (widthScreen/squareOfScreen))) * squareOfScreen);
        this.y_pos=(((int)(Math.random() * (heightScreen/squareOfScreen))) * squareOfScreen);
    }

    public int getX_pos() {
        return x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }
}

