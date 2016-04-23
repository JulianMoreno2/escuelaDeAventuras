package com.example.gonzalo.escueladeaventuras.metadata;

import java.util.ArrayList;

/**
 * Created by ddavi on 21/4/2016.
 */
public class Level {

    private int number;
    private ArrayList<Exercise> exercisesCollection;
    private int currentExerciseIndex;;

    public Level(){
        this.number = 1;
        this.exercisesCollection = new ArrayList<>();
        this.currentExerciseIndex = 0;
        this.preguntasDePrueba();
    }

    //Ejercicios de prueba
    private void preguntasDePrueba() {

        Exercise pregunta1 = new Exercise();
        pregunta1.setType(ExerciseType.Question);
        pregunta1.setDescription("¿Cuanto es 5 + 3?");
        pregunta1.setAnswer("8");
        pregunta1.setLevel(1);
        pregunta1.setPunctuation(25);

        this.exercisesCollection.add(pregunta1);

        Exercise pregunta2 = new Exercise();
        pregunta2.setType(ExerciseType.Question);
        pregunta2.setDescription("¿Cuanto es 12 - 7?");
        pregunta2.setAnswer("5");
        pregunta2.setLevel(1);
        pregunta2.setPunctuation(35);

        this.exercisesCollection.add(pregunta2);

        Exercise pregunta3 = new Exercise();
        pregunta3.setType(ExerciseType.Question);
        pregunta3.setDescription("¿Cuanto es 17 + 11");
        pregunta3.setAnswer("28");
        pregunta3.setLevel(1);
        pregunta3.setPunctuation(30);

        this.exercisesCollection.add(pregunta3);
    }

    public Exercise getCurrentExercise() {
        //if(this.exercisesCollection.size() > currentExerciseIndex){
        Exercise currentExercise = this.exercisesCollection.get(currentExerciseIndex);
        currentExerciseIndex++;
        return currentExercise;
    /*
        } else {
            return null;
        }
    */
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }
}
