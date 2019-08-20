package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DunyaKontrolleri {
	
	ArrayList<ZiplamaAlani> ZiplamaAlanlari;
	Karakter karakter;
	Random rnd;
	DunyaKontrolleri(Karakter gkarakter){
		karakter = gkarakter;
		rnd = new Random();
		ZiplamaAlanlari = new ArrayList<ZiplamaAlani>();
		for(int i=0;i<3;i++) {
			ZiplamaAlanlari.add(new ZiplamaAlani(90*i,50));
		}
	}
	void AlanlariCiz(SpriteBatch batch) {
		for(int i = 0;i<ZiplamaAlanlari.size();i++) {
			
			batch.draw(ZiplamaAlanlari.get(i).texture,ZiplamaAlanlari.get(i).KordiX,
					ZiplamaAlanlari.get(i).KordiY,ZiplamaAlanlari.get(i).GenislikX,ZiplamaAlanlari.get(i).GenislikY);
			
		}
	}
	void AlanOlustur(int AltLimit) {
		
		ZiplamaAlanlari.add(new ZiplamaAlani(rnd.nextInt(300),rnd.nextInt(250)+AltLimit+40));
	}
	
	void DusmeKontrolleri() {
		if(karakter.ZiplamaF<0) {
			
			for(int i=0;i<ZiplamaAlanlari.size();i++) {
			
				if(ZiplamaAlanlari.get(i).Alan.overlaps(karakter.Alan)) {
					
					
					karakter.Zipla(ZiplamaAlanlari.get(i).Alan.y);
					
				}
				
			}
		}
	}
	public void AlanTemizle(int TemizlemeNoktasi) {
		
		for(int i = 0;i<ZiplamaAlanlari.size();i++) {
			
			if(ZiplamaAlanlari.get(i).KordiY<TemizlemeNoktasi) {
				
				ZiplamaAlanlari.remove(i);
				i--;
				
			}
			
		}
		
	}
	
	
}
