package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.Texture;

public class ZiplamaAlani {
	
	float KordiX;
	float KordiY;
	float GenislikX;
	float GenislikY;
	Rectangle Alan;
	Texture texture;
	
	ZiplamaAlani(float gelenX,float gelenY){
		texture = new Texture("bulut.png");
		KordiX = gelenX;
		KordiY = gelenY;
		GenislikX = 110;
		GenislikY = 35;
		Alan = new Rectangle((int)KordiX, (int)KordiY+20, (int)GenislikX-5, (int)GenislikY-40);
	
	}
	
}
