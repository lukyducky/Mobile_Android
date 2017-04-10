package edu.ilukcogswell.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> noteList;
    private ListView mainListView;
    private ArrayAdapter<String> listAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainListView = (ListView) findViewById(R.id.mainListView);
        String[] notes = new String[] {"something", "Another thing", "some other things"};

        noteList = new ArrayList<String>();
        noteList.addAll(Arrays.asList(notes));

        readItems();
        //use this list to make array adapter
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, noteList);

        mainListView.setAdapter(listAdapter);
    }

//adds item to the list?
    public void onAddItem(View v){
        EditText etNewItem = (EditText) findViewById(R.id.noteEditText);
        String itemText = etNewItem.getText().toString();
        listAdapter.add(itemText);
        etNewItem.setText("");

    }


    public void openNewNote(View view) {
        Intent intent = new Intent(this, newNote.class);
        //EditText editText = (EditText) findViewById(R.id.quickNote);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    private void readItems(){
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try{
            noteList = new ArrayList<String>(FileUtils.readLines(todoFile));
        }
        catch(IOException e){
            noteList = new ArrayList<String>();
        }
    }

    private void writeItems(){
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, noteList);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
