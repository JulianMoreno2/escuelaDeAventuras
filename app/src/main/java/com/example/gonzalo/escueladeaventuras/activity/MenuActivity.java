package com.example.gonzalo.escueladeaventuras.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.gonzalo.escueladeaventuras.metadata.EscuelaDeAventuras;
import com.example.gonzalo.escueladeaventuras.R;
import com.example.gonzalo.escueladeaventuras.sqlite.DataBaseManager;

public class MenuActivity extends AppCompatActivity {

    private DataBaseManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onExitClick(View view){
        finish();
        System.exit(0);
    }

    public void onClickButtonStart(View view){

        EscuelaDeAventuras.getInstance().getPlayer().setName(((EditText) findViewById(R.id.editTextPlayerName)).getText().toString());
        EscuelaDeAventuras.getInstance().getPlayer().setAge(Integer.parseInt(((EditText) findViewById(R.id.editTextPlayerAge)).getText().toString()));

        finish();
        Intent intent = new Intent(MenuActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
