package com.example.sarahpomeroy.synonymfinder;

/**
 * Created by sarahpomeroy on 3/28/18.
 */
import android.app.Activity;

public class Pair extends Activity {

    String wordOne, wordTwo;

    public void setWordOne(String wordOne) {
        this.wordOne = wordOne;
    }

    public String getWordOne() {
        return this.wordOne;
    }

    public void setWordTwo(String wordTwo) {
        this.wordTwo = wordTwo;
    }

    public String getWordTwo() {
        return this.wordTwo;
    }
}