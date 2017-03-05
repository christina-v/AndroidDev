package com.example.android.miwok;

/**
 * Created by chrisvillalobos on 2/17/17.
 */

public class Word {


    private String mFrenchTrans;
    private String mEnglishTrans;


    public Word(String english, String french) {

        mEnglishTrans = english;
        mFrenchTrans = french;

    }

   /*
    public void setFrench(){

    }

    public void setEnglish() {

    }
    */


    public String getFrenchTrans() {
        return mFrenchTrans;
    }

    public String getEnglishTrans() {
        return mEnglishTrans;
    }

}
