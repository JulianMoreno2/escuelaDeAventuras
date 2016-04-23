package com.example.gonzalo.escueladeaventuras.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.gonzalo.escueladeaventuras.R;
import com.example.gonzalo.escueladeaventuras.metadata.EscuelaDeAventuras;
import com.example.gonzalo.escueladeaventuras.metadata.Exercise;
import com.example.gonzalo.escueladeaventuras.metadata.Level;
import com.example.gonzalo.escueladeaventuras.sqlite.DataBaseManager;

import java.util.LinkedList;

/**
 * Created by Rain on 23/04/2016.
 */
public class QuestionExerciseActivity extends AppCompatActivity {

    private DataBaseManager manager;
    private LinkedList<Exercise> listExercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_exercise);
        manager = new DataBaseManager(this);
        listExercises = new LinkedList<Exercise>();
    }

    public LinkedList<Exercise> getListExercises(){

        Cursor cursor = manager.loadCursorExercise();
        //recorre el cursor de ejercicios y lo añade a la lista de ejercicios
        while(cursor.moveToNext()) {
            Exercise exerciseActual = new Exercise();
            exerciseActual.setDescription(cursor.getString(cursor.getColumnIndex("description")));
            exerciseActual.setAnswer(cursor.getString(cursor.getColumnIndex("answer")));
            exerciseActual.setPunctuation(Integer.parseInt(cursor.getString(cursor.getColumnIndex("punctuation"))));
            exerciseActual.setLevel(Integer.parseInt(cursor.getString(cursor.getColumnIndex("level"))));

            this.listExercises.add(exerciseActual);
        }
        cursor.close();
        //hay que verificar que efectivamente esta guardando las preguntas en la lista
        return this.listExercises;
    }

    public void onClickNext(View view){

        Level level = new Level();
        EscuelaDeAventuras juego = EscuelaDeAventuras.getInstance();
        //la puntuacion se tiene que ir acumulando cada vez que le das a siguiente
        juego.getPlayer().setPunctuation(100);
        juego.getPlayer().setLevel(level);

        manager.insertPlayer(juego.getPlayer());
        //Cuando apretas en siguiente, te lleva al record activity,
        // la intencion es que intere las preguntas
        finish();
        Intent intent = new Intent(QuestionExerciseActivity.this, RecordActivity.class);
        startActivity(intent);
    }
}
