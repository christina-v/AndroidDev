package com.example.android.ciaotwitter;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import java.io.File;

/**
 * Created by chrisvillalobos on 3/4/17.
 */

public class TweetActivity extends Activity {

    Button tweetbutton;
    Uri myImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
// TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tweet_activity);

        tweetbutton = (Button) findViewById(R.id.button2);

        //Provide the image path you want to show in your tweet.
        File myImageFile = new File("/path/to/image");
        myImageUri = Uri.fromFile(myImageFile);
        tweetbutton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                TweetComposer.Builder builder = new TweetComposer.Builder(TweetActivity.this).text("My First tweet using fabric.").image(myImageUri);
                builder.show();
            }
        });

    }
}


