package com.example.android.ciaotwitter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.core.services.AccountService;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import io.fabric.sdk.android.Fabric;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "lXS0eGpl8JZ8Odlv7PjHvbX01";
    private static final String TWITTER_SECRET = "OBko4yPEbADorVhlykZknyNq08aCO8Mlcf670jTWJracquPw8G";

    private TwitterLoginButton loginButton;
    TextView screen_name, user_name, user_location, user_timezone, user_description;
    TwitterSession session;
    ImageView user_picture;
    String screenname, username, twitterImage, location, timeZone, description;

    Twitter twitter;
    TwitterApiClient api;
    AccountService service;
    Call<User> user;

    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig), new TweetComposer());
        setContentView(R.layout.activity_main);

        /* LOGIN BUTTON */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);

        loginButton.setCallback(new Callback<TwitterSession>() {

            @Override
            public void success(Result<TwitterSession> result) {

                Log.d("TWITTERLOGIN", "Entering success method");

                session = result.data;
                twitter = Twitter.getInstance();
                api = twitter.core.getApiClient(session);
                service = api.getAccountService();
                user = service.verifyCredentials(true, true);

                user.enqueue(new Callback<User>() {

                /*session = Twitter.getSessionManager().getActiveSession();

                Twitter.getApiClient(session)
                        .getAccountService()
                        .verifyCredentials(true, false, new Callback<User>() {*/

                    @Override
                    public void success(Result<User> userResult) {

                        User user = userResult.data;

                        twitterImage = user.profileImageUrl;
                        screenname = user.screenName;
                        username = user.name;
                        location = user.location;
                        timeZone = user.timeZone;
                        description = user.description;

                        setUpViewsForTweetComposer();



                        /*user_picture = (ImageView) findViewById(R.id.profile_pic);
                        Picasso.with(getApplicationContext()).load(twitterImage.toString())
                                .into(user_picture);

                        screen_name = (TextView) findViewById(R.id.screen_name);
                        screen_name.setText("Username : " + screenname);

                        user_name = (TextView) findViewById(R.id.user_name);
                        user_name.setText("Name : " + username);

                        user_location = (TextView) findViewById(R.id.user_location);
                        user_location.setText("Location : " + location);

                        user_timezone = (TextView) findViewById(R.id.user_timezone);
                        user_timezone.setText("Timezone : " + timeZone);

                        user_description = (TextView) findViewById(R.id.user_description);
                        user_description.setText("Description : " + description);*/

                    }

                    @Override
                    public void failure(TwitterException e) {
                        System.out.println("Failing to login");
                    }

                });

                loginButton.setVisibility(View.GONE);

            }

            @Override
            public void failure(TwitterException exception) {
                Log.d("TwitterKit", "Login with Twitter failure", exception);
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Make sure that the loginButton hears the result from any
        // Activity that it triggered.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        return true;
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
            if(id==R.id.action_settings){
            return true;
            }
        return super.onOptionsItemSelected(item);
        }

    
    private void setUpViewsForTweetComposer() {

        TweetComposer.Builder builder = new TweetComposer.Builder(this).text("Hello people of twitter!");
        builder.show();

    }



}

