package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Karakter {

	float TemelZiplamaY;
	float KordiX;
	float KordiY;
	float ZiplamaF;
	float YerCekimiIvmesi;
	Rectangle Alan;
	Texture texture;
	
	Karakter(){
		
		KordiX = 50;
		KordiY = 0;
		TemelZiplamaY = 0;
		texture = new Texture("top2.png");
		YerCekimiIvmesi = 0.2f;
		ZiplamaF = 7;
		Alan = new Rectangle(KordiX,KordiY,50,25);
		
	}
	
	void KarakteriCiz(SpriteBatch batch) {
		batch.draw(texture, KordiX, KordiY,50,25);
		Alan.x = KordiX;
		Alan.y = KordiY;
	}
	
	void Zipla(float ZiplamaNoktasi) {
		
		if(KordiY+ZiplamaF <= ZiplamaNoktasi) {

			ZiplamaF = 7;
			KordiY = ZiplamaNoktasi;
		}else{

			ZiplamaF -= YerCekimiIvmesi;
			KordiY += ZiplamaF;
		}
		
	}
	
	
}
