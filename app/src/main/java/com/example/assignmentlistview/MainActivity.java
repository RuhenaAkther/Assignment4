package com.example.assignmentlistview;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView  = findViewById(R.id.listView);

        String[] titles = getResources().getStringArray(R.array.Country_names);
        String[] subtitles = getResources().getStringArray(R.array.Country_subtitles);
        Integer[] imgIds = {
                R.drawable.bangladesh , R.drawable.bhutan, R.drawable.china, R.drawable.india ,
                R.drawable.japan, R.drawable.america, R.drawable.armenia, R.drawable.afghanistan ,
                R.drawable.nepal, R.drawable.pakistan
        };

        TechAdapter adapter = new TechAdapter(this, titles, subtitles, imgIds);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selected = titles[position];
            Toast .makeText(this, "Clicked: " + selected, Toast.LENGTH_SHORT).show();
        });
    }
}