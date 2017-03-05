package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //array of phrases
        ArrayList<Word> phrases = new ArrayList<Word>();


        phrases.add(new Word("Hello", "Bonjour"));
        phrases.add(new Word("Goodbye", "Au revoir"));
        phrases.add(new Word("Good evening", "Bonne soirée"));
        phrases.add(new Word("Good night", "Bonne soirée"));
        phrases.add(new Word("Yes", "Oui"));
        phrases.add(new Word("No", "Non"));
        phrases.add(new Word("My name is...", "Je m' appelle..."));
        phrases.add(new Word("What is your name...?", "Comment vous appelez-vous?"));
        phrases.add(new Word("Do you speak English?", "Parlez-vous anglais?"));
        phrases.add(new Word("I do not speak French.", "Je ne parle pas le francais"));
        phrases.add(new Word("Please", "S’il vous plaît"));
        phrases.add(new Word("Thank you", "Merci"));
        phrases.add(new Word("Excuse me", "Excusez-moi"));
        phrases.add(new Word("How are you? (informal)", "Comment vas-tu?"));
        phrases.add(new Word("It is going well.", "Ça va bien"));



        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, phrases, R.color.category_phrases);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the

        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
    }
}
