package com.example.gonzalo.escueladeaventuras.metadata;

import com.example.gonzalo.escueladeaventuras.metadata.Level;

/**
 * Created by ddavi on 21/4/2016.
 */
public class Player {

    private String name;
    private Level level;
    private int age;
    private int punctuation;

    public int getCurse(){
        return (getAge() - 5);
    }

    public Level getLevel() {
        return this.level;
    }

    public void setLevel(Level level){
        this.level = level;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPunctuation() {
        return this.punctuation;
    }

    public void setPunctuation(int punctuation) {
        this.punctuation = punctuation;
    }

}
