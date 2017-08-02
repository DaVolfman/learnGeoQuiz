package com.example.steven.geoquiz;

/**
 * Created by Steven on 8/1/2017.
 */

public class TFQuestion {
    private int mTextResID;
    private boolean mAnswerTrue;

    public int getTextResID() {
        return mTextResID;
    }

    public void setTextResID(int textResID) {
        mTextResID = textResID;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public TFQuestion(int textResID, boolean answerTrue){
        mTextResID = textResID;
        mAnswerTrue = answerTrue;
    }
}
