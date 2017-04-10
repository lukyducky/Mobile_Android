package edu.ilukcogswell.notes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    private ListView mainListView;
    private ArrayAdapter<String> listAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finds listView

        mainListView = (ListView) findViewById(R.id.mainListView);

        String[] notes = new String[] {"something", "Another thing", "some other things"};

        ArrayList<String> noteList = new ArrayList<String>();
        noteList.addAll(Arrays.asList(notes));

        //use this list to make array adapter
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, noteList);



        mainListView.setAdapter(listAdapter);






    }


    public void onAddItem(View v){
        EditText etNewItem = (EditText) findViewById(R.id.quickNote);
        String itemText = etNewItem.getText().toString();
        listAdapter.add(itemText);
        etNewItem.setText("");

    }
}
