package com.example.gonzalo.escueladeaventuras.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.gonzalo.escueladeaventuras.R;
import com.example.gonzalo.escueladeaventuras.metadata.ExerciseType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Exercise currentExercise = EscuelaDeAventuras.getInstance().getPlayer().getLevel().getCurrentExercise();
        this.setLayout(ExerciseType.Question);
    }

    public void setLayout(ExerciseType type){

        switch (type) {
            case Question:
                setContentView(R.layout.activity_question_exercise);
                startActivity(new Intent(MainActivity.this, QuestionExerciseActivity.class));
                break;
            case MultipleChoice:
                setContentView(R.layout.activity_multiple_choice_exercise);
                break;
            case Ordering:
                finish();
                startActivity(new Intent(MainActivity.this, OrderingExerciseActivity.class));
                break;
        }
        //Exercise currentExercise = EscuelaDeAventuras.getInstance().getPlayer().getLevel().getCurrentExercise();
       // this.setLayout(currentExercise.getType());
    }
}
