package com.example.sarahpomeroy.synonymfinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by sarahpomeroy on 3/27/18.
 */

public class EnterValues extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_values);

        String wordOne = getIntent().getStringExtra("wordOne");
        final TextView tv1 = (TextView)findViewById(R.id.wordOne);
        tv1.setText(wordOne);

        String wordTwo = getIntent().getStringExtra("wordTwo");
        final TextView tv2 = (TextView)findViewById(R.id.wordTwo);
        tv2.setText(wordTwo);

        Button btn = findViewById(R.id.BSubmit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = tv1.getText().toString();
                String str2 = tv2.getText().toString();

                Pair p = new Pair();
                p.setWordOne(str1);
                p.setWordTwo(str2);

                helper.insertPair(p);

                Intent i = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(i);
            }
        });
    }
}