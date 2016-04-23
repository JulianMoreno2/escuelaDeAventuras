package com.example.gonzalo.escueladeaventuras.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gonzalo.escueladeaventuras.metadata.Exercise;
import com.example.gonzalo.escueladeaventuras.metadata.Player;

/**
 * Created by Rain on 22/04/2016.
 */
public class DataBaseManager {

    public static final String TABLE_PLAYER = "player";

    public static final String PLAYER_ID = "_id";
    public static final String PLAYER_NAME = "name";
    public static final String PLAYER_AGE = "age";
    public static final String PLAYER_LEVEL = "level";
    public static final String PLAYER_PUNCTUATION = "punctuation";

    public static final String TABLE_EXERCISE = "exercise";

    public static final String EXERCISE_ID = "_id";
    public static final String EXERCISE_DESCRIPTION = "description";
    public static final String EXERCISE_ANSWER = "answer";
    public static final String EXERCISE_LEVEL = "level";


    public static final String CREATE_TABLE_PLAYER = String.format("create table %s (%s integer primary key autoincrement, " +
                    "%s text not null, %s integer not null, %s integer, %s integer)",
            TABLE_PLAYER, PLAYER_ID, PLAYER_NAME, PLAYER_AGE, PLAYER_LEVEL, PLAYER_PUNCTUATION);

    public static final String CREATE_TABLE_EXERCISES = String.format("create table %s (%s integer primary key autoincrement, "+
                    "%s text not null, %s text not null, %s integer",
            TABLE_EXERCISE, EXERCISE_ID, EXERCISE_DESCRIPTION, EXERCISE_ANSWER, EXERCISE_LEVEL);

    private DbHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context context) {
        this.helper = new DbHelper(context);
        this.db = helper.getWritableDatabase();
    }

    public void insertPlayer(Player player){
        ContentValues values = new ContentValues();
        values.put(PLAYER_NAME, player.getName());
        values.put(PLAYER_AGE, player.getAge());
        values.put(PLAYER_LEVEL, player.getLevel().getNumber());
        values.put(PLAYER_PUNCTUATION, player.getPunctuation());

        db.insert(TABLE_PLAYER, null, values);
    }

    public void deletePlayer(String name){
        db.delete(TABLE_PLAYER, PLAYER_NAME + "=?", new String[]{name});
    }

    public void updatePunctuationPlayer(Player player){
        ContentValues values = new ContentValues();
        values.put(PLAYER_NAME,player.getName());
        values.put(PLAYER_AGE,player.getAge());
        values.put(PLAYER_LEVEL, player.getLevel().getNumber());
        values.put(PLAYER_PUNCTUATION, player.getPunctuation());

        db.update(TABLE_PLAYER, values, null, null);
    }

    public void insertExercise(Exercise exercise){
        ContentValues values = new ContentValues();
        values.put(EXERCISE_DESCRIPTION, exercise.getDescription());
        values.put(EXERCISE_ANSWER, exercise.getAnswer());
        values.put(EXERCISE_LEVEL, exercise.getLevel());

        db.update(TABLE_PLAYER, values, null, null);
    }

    public void deleteExercise(String description){
        db.delete(TABLE_EXERCISE, EXERCISE_DESCRIPTION + "=?", new String[]{description});
    }

    public Cursor loadCursorExercise(){
        String[] columns = new String[]{EXERCISE_ID,EXERCISE_DESCRIPTION,EXERCISE_ANSWER,EXERCISE_LEVEL};
        //query (String table, String[] columns, String selection,
        // String selectionArgs, String groupBy, String having, String orderBy(
        return db.query(TABLE_EXERCISE, columns,null,null,null,null,null);
    }

    //El cursor sirve para crear una lista con los datos de la db
    public Cursor loadCursorPlayer(){
        String[] columns = new String[]{PLAYER_ID,PLAYER_NAME,PLAYER_AGE,PLAYER_LEVEL,PLAYER_PUNCTUATION};
        //query (String table, String[] columns, String selection,
        // String selectionArgs, String groupBy, String having, String orderBy(
        return db.query(TABLE_PLAYER, columns,null,null,null,null,null);
    }
}
