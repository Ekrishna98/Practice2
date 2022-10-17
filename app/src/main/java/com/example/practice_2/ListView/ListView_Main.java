package com.example.practice_2.ListView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practice_2.R;

public class ListView_Main extends AppCompatActivity {
    ListView listView;
    TextView textView;
    String[] festivals = {
            "Diwali",
            "Holi",
            "Christmas",
            "Eid",
            "Baisakhi",
            "Halloween"
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_main);

        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.textView);

        final ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.list_items, R.id.textView, festivals);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /* appending Happy with festival name */
                String value = "Happy  " + adapter.getItem(position);
                /* Display the Toast */
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
