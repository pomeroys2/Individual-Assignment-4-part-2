package com.example.sarahpomeroy.synonymfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.BEnterValues) {
            Intent i = new Intent(MainActivity.this, EnterValues.class);
            startActivity(i);
        }
        if (v.getId() == R.id.BResults) {
            EditText a = (EditText)findViewById(R.id.synonym);
            String str = a.getText().toString();

            String newSynonym = helper.searchSynonym(str);

                Intent i = new Intent(MainActivity.this, Results.class);

                i.putExtra("word", str);
                i.putExtra("synonym", newSynonym);

                startActivity(i);

            }
        }
    }