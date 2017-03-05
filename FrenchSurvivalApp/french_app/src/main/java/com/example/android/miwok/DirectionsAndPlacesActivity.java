package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class DirectionsAndPlacesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        //array of places
        ArrayList<Word> places = new ArrayList<Word>();


        places.add(new Word("How do I get to...?", "Pour aller à…."));
        places.add(new Word("Where is...?", "Où est... ?"));
        places.add(new Word("left", "gauche"));
        places.add(new Word("right", "droite"));
        places.add(new Word("Hotel", "hôtel"));
        places.add(new Word("Airport", "aéroport"));
        places.add(new Word("The street", "La rue"));
        places.add(new Word("The public restrooms", "Les toilettes publiques"));
        places.add(new Word("At the end of", "Au bout de"));
        places.add(new Word("At the beginning of", "Au début de"));
        places.add(new Word("The corner", "Le coin"));
        places.add(new Word("The bridge", "Le pont"));
        places.add(new Word("Next to", "neuf"));
        places.add(new Word("Is it very far?", "Est-ce que c’est loin ?"));
        places.add(new Word("Is it close by?", "Est-ce que c’est près ?"));



        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, places, R.color.category_directions);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the

        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

    }
}
