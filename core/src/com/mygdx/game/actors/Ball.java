package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.box2d.BallUserData;
import com.mygdx.game.box2d.EnemyUserData;
import com.mygdx.game.utils.Constants;

import sun.rmi.runtime.Log;

/**
 * Created by Piotrek on 2016-05-07.
 */
public class Ball extends GameActor {

    // private Animation animation;
    // private float stateTime;
    private final TextureRegion textureRegion;
    private boolean hit;
    public Ball(Body body) {
        super(body);
        textureRegion = new TextureRegion(new Texture(Gdx.files.internal(Constants.BALL_IMAGE_PATH)));
        //  TextureRegion[] runningFrames = new TextureRegion[getUserData().getTextureRegions().length];
        //   for (int i = 0; i < getUserData().getTextureRegions().length; i++) {
        //      String path = getUserData().getTextureRegions()[i];
        //       runningFrames[i] = textureAtlas.findRegion(path);
        //   }
        //   animation = new Animation(0.1f, runningFrames);
        //   stateTime = 0f;
        // body.applyLinearImpulse(new Vector2(-0.1f, 0), body.getWorldCenter(), true);
        Gdx.app.log("Menu", "Pomyślnie załadowano balle");
    }

    @Override
    public BallUserData getUserData() {
        return (BallUserData) userData;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        body.setLinearVelocity(getUserData().getLinearVelocity());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        float x = screenRectangle.x - (screenRectangle.width * 0.1f);
        float y = screenRectangle.y;
        float width = screenRectangle.width * 1.2f;

        batch.draw(textureRegion, x, y + screenRectangle.height / 4, width, screenRectangle.height * 3 / 4);
    }
    public void enemyHit() {
        hit = true;

    }


    public boolean isenemyHit() {
        return hit;
    }
    public void resetHit(){hit=false;}

}