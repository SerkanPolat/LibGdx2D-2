package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor{
	SpriteBatch batch;
	int ZiplaY;
	int KordiY;
	Texture ZiplamaAlani;
	Karakter karakter;
	OrthographicCamera kamera;
	Viewport viewport;
	int viewPortX,viewPortY;
	int YerCekimiIvmesi;
	Texture ArkaPlan;
	DunyaKontrolleri kontroller;
	ShapeRenderer shaperenderer;
	
	boolean OYUN_CALISIYOR = true;
	boolean OYUN_DURDURULDU = false;
	boolean OyunState;
	
	@Override
	public void create () {
		OyunState = OYUN_CALISIYOR;
		viewPortX = Gdx.graphics.getWidth();
		viewPortY = Gdx.graphics.getHeight();
		kamera = new OrthographicCamera();
		batch = new SpriteBatch();
		karakter = new Karakter();
		Gdx.input.setInputProcessor(this);
		
		viewport = new FitViewport(510, 300);
		viewport.setCamera(kamera);
		viewport.apply();
		kamera.position.set(255, 150, 0);
		
		ArkaPlan = new Texture("arka.png");
		kontroller = new DunyaKontrolleri(karakter);
		//shaperenderer = new ShapeRenderer();
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		
		/*
		shaperenderer.setProjectionMatrix(kamera.combined);
		shaperenderer.begin(ShapeType.Line);
		shaperenderer.setColor(Color.WHITE);
		shaperenderer.rect(karakter.KordiX,karakter.KordiY,50, 25);
		for(int i = 0;i<kontroller.ZiplamaAlanlari.size();i++) {
			shaperenderer.rect(kontroller.ZiplamaAlanlari.get(i).KordiX, kontroller.ZiplamaAlanlari.get(i).KordiY+15,
					kontroller.ZiplamaAlanlari.get(i).GenislikX, kontroller.ZiplamaAlanlari.get(i).GenislikY-30);
		}
		
		shaperenderer.end();
		*/

		batch.setProjectionMatrix(kamera.combined);
		kamera.update();
		karakter.KordiX -= 3*Gdx.input.getAccelerometerX();
			batch.begin();

			OyunGrafikleriniGuncelle();

			if(OyunState) {

				OyunMantiginiGuncelle();
			}
			
			batch.end();
			
			
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			
			karakter.KordiX+=4;
			
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			
			karakter.KordiX-=4;
			
		}
	}
	
	private void OyunMantiginiGuncelle() {

		kamera.position.y++;
		kontroller.DusmeKontrolleri();
		karakter.KarakteriCiz(batch);
		karakter.Zipla(karakter.TemelZiplamaY);
		AlanOlustur();
		if(OyunBittiKontrolu()) {
			OyunState = OYUN_DURDURULDU;
		}
		
	}

	private boolean OyunBittiKontrolu() {
		
		if(karakter.KordiY<kamera.position.y-175) {
			return true;
			
		}else {
			
			return false;
		}
		
	}

	private void OyunGrafikleriniGuncelle() {
		
		System.out.println("Denemelr");
		batch.draw(ArkaPlan, 0, kamera.position.y-150,510, 300);
		kontroller.AlanlariCiz(batch);
		
	}

	private void AlanOlustur() {
		
		if(kamera.position.y%25<1) {
		
			kontroller.AlanOlustur((int)kamera.position.y-200);
			kontroller.AlanTemizle((int)kamera.position.y-350);
		}
		
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		if(Keys.A==keycode) {
			
			karakter.KordiX-=10;
			
		}else if(Keys.D==keycode){
			
			karakter.KordiX+=10;
			
		}
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		if(keycode == Keys.B) {
			OyunState = OYUN_CALISIYOR;
			karakter.KordiX = kamera.position.x;
			karakter.KordiY = kamera.position.y;
			karakter.ZiplamaF = 7;
		}
		
		
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
