package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class EatingOutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //array of eats
        ArrayList<Word> eats = new ArrayList<Word>();


        eats.add(new Word("Breakfast", "Le petit déjeuner"));
        eats.add(new Word("Lunch", "Le déjeuner"));
        eats.add(new Word("Dinner", "trois"));
        eats.add(new Word("A flute of champagne", "Une coupe de champagne"));
        eats.add(new Word("I'll have", "Je prendrai…."));
        eats.add(new Word("I would like", "Je voudrais…"));
        eats.add(new Word("The bill please", "L’addition, s’il vous plaît."));
        eats.add(new Word("A fork", "Une fourchette"));
        eats.add(new Word("nine", "neuf"));
        eats.add(new Word("ten", "dix"));



        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, eats, R.color.category_eating);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the

        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

    }
}
