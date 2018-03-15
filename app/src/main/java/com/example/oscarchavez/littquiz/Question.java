package com.example.oscarchavez.littquiz;

/**
 * Created by Oscar Chavez on 3/12/2018.
 */

public class Question {

    private int mTextResId;
/*
    private boolean mAnswerTrue; // change to char for hardmode
*/

    private char mAnswerTrue;



    public Question(int textResId, char answerTrue){
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

   /* public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }*/

    public char getAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(char answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
