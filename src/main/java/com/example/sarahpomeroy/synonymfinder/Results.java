package com.example.sarahpomeroy.synonymfinder;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by sarahpomeroy on 3/27/18.
 */

public class Results extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        String synonym = getIntent().getStringExtra("synonym");

        TextView tv2 = findViewById(R.id.TVSynonym);
        tv2.setText(synonym);

    }
}