package com.example.gonzalo.escueladeaventuras.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gonzalo.escueladeaventuras.R;
import com.example.gonzalo.escueladeaventuras.metadata.Music;

import java.util.ArrayList;

/**
 * Created by Rain on 23/04/2016.
 */
public class OrderingExerciseActivity extends AppCompatActivity {

    private float positionX = 0;
    private int countViews = -1;
    private ArrayList<Integer> beforeViews;
    private ArrayList<Float> positions;
    private Music mediaPlayer;

    public class AniListener implements Animation.AnimationListener{

        private View view;
        private float positionX;
        private float positionY;

        public AniListener(View view,float positionX,float positionY){
            this.view = view;
            this.positionX = positionX;
            this.positionY = positionY;
        }

        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            view.setX(this.positionX);
            view.setY(this.positionY);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering_exercise);

        beforeViews = new ArrayList<Integer>();
        positions = new ArrayList<Float>();

        mediaPlayer = new Music();
        /** EDIT: Rain
         * NO QUIERO MUSICA EN EL PRIMER RELEASE
         */
        //mediaPlayer.changeTrack(this, R.raw.aria_the_scarlet_ammo_opening);

        //Agregar TextView al XMl por codigo
        this.createAndAddTextView("vecina");
        this.createAndAddTextView("Mi");
        this.createAndAddTextView("caramelos");
        this.createAndAddTextView("come");
        this.createAndAddTextView("dulces");
    }

    private void  createAndAddTextView(String text) {

        LinearLayout words = (LinearLayout) findViewById(R.id.words_id);

        TextView newTextView = new TextView(this);

        newTextView.setText(text);
        newTextView.setBackgroundColor(Color.GRAY);
        newTextView.setTextColor(Color.BLACK);
        newTextView.setPadding(10, 10, 10, 10);
        newTextView.setId(words.getChildCount());

        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        llp.setMargins(2, 0, 0, 0);
        newTextView.setLayoutParams(llp);

        newTextView.setOnClickListener(new Listener(this));

        words.addView(newTextView);
    }

    public class Listener implements View.OnClickListener {

        OrderingExerciseActivity activity;

        public Listener (OrderingExerciseActivity activity){
            this.activity = activity;
        }

        @Override
        public void onClick(View view) {
            activity.onClickTextView(view);
        }
    }

    public void onClickTextView(View view){

        int rightSpace = 2;
        float posY = 200;
        float posX = view.getX();
        Animation movimiento;

        if ( !beforeViews.isEmpty() && beforeViews.get(countViews) == view.getId()) {

            movimiento = new TranslateAnimation(0,positions.get(countViews)- view.getX(),0,-posY);
            movimiento.setAnimationListener(new AniListener(view, positions.get(countViews), 0));
            movimiento.reset();
            view.getY();
            view.startAnimation(movimiento);

            this.positionX = this.positionX - view.getWidth() - rightSpace;
            beforeViews.remove(countViews);
            positions.remove(countViews);
            countViews--;

        }else if (view.getY() != 200){

            movimiento = new TranslateAnimation(0,(positionX- view.getX()),0,posY);
            movimiento.setAnimationListener(new AniListener(view,this.positionX,posY));
            movimiento.setDuration(800);
            movimiento.reset();
            view.startAnimation(movimiento);

            this.positionX = this.positionX + view.getWidth() + rightSpace;
            this.beforeViews.add(view.getId());
            countViews++;
            positions.add(posX);
        }
    }
}
