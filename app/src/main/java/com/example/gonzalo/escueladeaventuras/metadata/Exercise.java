package com.example.gonzalo.escueladeaventuras.metadata;

/**
 * Created by ddavi on 21/4/2016.
 */
public class Exercise {

    private String description;
    private String answer;
    private int level;
    private int punctuation;
    private ExerciseType type;

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(int punctuation) {
        this.punctuation = punctuation;
    }

    public void setType(ExerciseType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public ExerciseType getType() {
        return type;
    }
}
