package com.example.gonzalo.escueladeaventuras.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.gonzalo.escueladeaventuras.R;
import com.example.gonzalo.escueladeaventuras.sqlite.DataBaseManager;

public class RecordActivity extends AppCompatActivity {

    private DataBaseManager manager;
    private Cursor cursor;
    private ListView listView;
    private SimpleCursorAdapter adapter;
    private TextView playerName;
    private TextView playerRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        manager = new DataBaseManager(this);
        listView = (ListView) findViewById(R.id.listView);
        playerName = (TextView) findViewById(R.id.name_player);
        playerRecord = (TextView) findViewById(R.id.punctuation_player);

        String[] from = new String[]{DataBaseManager.PLAYER_NAME,DataBaseManager.PLAYER_LEVEL,DataBaseManager.PLAYER_PUNCTUATION};
        //text1 y text2 son del column_row
        int[] to = new int[]{R.id.textLeft, R.id.textCenter, R.id.textRight};

        //playerName.setText(EscuelaDeAventuras.getInstance().getPlayer().getName());
        //playerRecord.setText(EscuelaDeAventuras.getInstance().getPlayer().getPunctuation());

        cursor = manager.loadCursorPlayer();

        //el cero es una bandera por defecto para que el simpleCursorAdapter no este deprecated
        adapter = new SimpleCursorAdapter(this,R.layout.column_row,cursor,from,to,0);
        listView.setAdapter(adapter);
    }

    public void onButtonClick(View view) {
        finish();
        if(view.getId() == R.id.bMenu){
            Intent intent = new Intent(RecordActivity.this, MenuActivity.class);
            startActivity(intent);
        }
    }
}
