package com.example.gonzalo.escueladeaventuras.metadata;

/**
 * Created by gonzalo on 19/04/16.
 */
public class EscuelaDeAventuras {

    private static EscuelaDeAventuras instance;
    private Player player;
    private String time;
    private String timeQuestion;

    private EscuelaDeAventuras() {
        player = new Player();
    }

    public static EscuelaDeAventuras getInstance() {

        if (instance == null){
            instance = new EscuelaDeAventuras();
        }
        return instance;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isAnswerCorrect(String candidateAnswer) {
        //return (this.getPlayer().getLevel().getCurrentExercise().getDescription() == candidateAnswer);
        return true;
    }
}
