package com.example.gonzalo.escueladeaventuras.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.gonzalo.escueladeaventuras.R;
import com.example.gonzalo.escueladeaventuras.metadata.EscuelaDeAventuras;

/**
 * Created by Rain on 23/04/2016.
 */
public class MultipleChoiceExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice_exercise);
    }

    public void onClickRadioButton(View view){

        boolean checked = ((RadioButton) view).isChecked();
        ImageView image = (ImageView) findViewById(R.id.respuesta_correcta);

        Animation movement;
        movement = AnimationUtils.loadAnimation(this, R.anim.transparente_aumenta);
        movement.reset();

        movement.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                RadioGroup group = (RadioGroup) findViewById(R.id.radio_group);
                group.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setContentView(R.layout.activity_ejercicio_1);
            }
        });

        RadioGroup group = (RadioGroup) findViewById(R.id.radio_group);
        RadioButton buttonClecked = (RadioButton) findViewById(group.getCheckedRadioButtonId());

        if (checked && EscuelaDeAventuras.getInstance().isAnswerCorrect(buttonClecked.getText().toString())){
            image.setVisibility(View.VISIBLE);
            image.startAnimation(movement);
        }else{
            System.out.println("RESPUESTA INCORRECTA");
        }

        image.setVisibility(View.INVISIBLE);
    }
}
