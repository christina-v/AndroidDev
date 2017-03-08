package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by chrisvillalobos on 3/5/17.
 */

public class MiscActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //array of words
        final ArrayList<Word> words = new ArrayList<Word>();


        words.add(new Word("one", "un"));
        words.add(new Word("two", "deux"));
        words.add(new Word("three", "trois"));
        words.add(new Word("four", "quatre"));
        words.add(new Word("five", "cinq"));
        words.add(new Word("six", "six"));
        words.add(new Word("seven", "sept"));
        words.add(new Word("eight", "huit"));
        words.add(new Word("nine", "neuf"));
        words.add(new Word("ten", "dix"));
        words.add(new Word("twenty", "vingt"));
        words.add(new Word("thirty", "trente"));
        words.add(new Word("forty", "quarante"));
        words.add(new Word("fifty", "cinquante"));
        words.add(new Word("sixty", "soixante"));
        words.add(new Word("seventy", "soixante-dix"));
        words.add(new Word("eighty", "quatre-vingts"));
        words.add(new Word("ninety", "quatre-vingt-dix"));
        words.add(new Word("one-hundred", "cent"));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.misc_list);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the

        ListView listView = (ListView) findViewById(R.id.list);


        /*MAKE PRONOUNCIATION APPEAR
        listView.setOnLongClickListener(new AdapterView.OnLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = words.get(position);

                    Toast.makeText(getApplicationContext(),word.getPronounciation(), Toast.LENGTH_LONG );
                    return true;
            }
                                        });

        listView.setOnItemLongClickListener(new AdapterView.OnLongClickListener() {
                                                @Override
                           public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long 1) {

                     Toast.makeText(this, position, Toast.LENGTH_LONG).show();
                            return true;
                                                }
                                            });*/

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

    }

}
