package com.example.anonymous.implicit_intents;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
     String[] ACTIVITY_CHOICES = new String[] {
            "My Website",
            "Start Voice Command"
    };
    final String searchTerms = "superman";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, ACTIVITY_CHOICES));
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        getListView().setTextFilterEnabled(true);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int arg2, long arg3) {
                switch(arg2) {
                    case 0: //opens web browser and navigates to given website
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://www.lineofcode.in.com/")));
                        break;
                    case 1: //starts the voice command
                        startActivity(new
                                Intent(Intent.ACTION_VOICE_COMMAND));
                        break;
                    default: break;
                }
            }
        });
    }
}