
package com.example.todolist2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText addtext1;
    EditText delete1;
    Button add;
    Button delete2;
    Button save;
    int n = 0, s = 1;
    int k,l2=1;

    int j;
    String msg, lt, l;
    public String[] hii = new String[100];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView MyList = findViewById(R.id.Mylist);
        MyList.setLayoutManager(new LinearLayoutManager(this));
        MyList.setAdapter(new ProgAdapter(hii));
        loaddata("task");
        addtext1 = findViewById(R.id.addtext);
        add = findViewById(R.id.addbutton);
        delete1 = findViewById(R.id.delete);
        delete2 = findViewById(R.id.delete1);
        save = findViewById(R.id.savechange);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hii[0]="your tasks";
                msg = addtext1.getText().toString();
                hii[n+1] = (n + 1) + " " + msg;
                n++;
                MyList.setAdapter(new ProgAdapter(hii));
            }
        });
        delete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l = delete1.getText().toString();
                k = Integer.parseInt(l);
                n--;
                for (j = k; j <= 99; j++) {
                    if (j < 99) {
                        lt = hii[j + 1];
                        hii[j] = lt;
                        hii[j + 1] = "";

                    }
                    if (j == 99) {
                        hii[j] = "";
                    }

                }
                MyList.setAdapter(new ProgAdapter(hii));

            }

        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata( hii,"task");
            }


        });
    }


    private void savedata(String[] tii, String key) {
        SharedPreferences shrd = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = shrd.edit();
        Gson gson = new Gson();
        String store = gson.toJson(tii);
        editor.putString("task", store);
        editor.apply();
    }

    private ArrayList<String> loaddata(String key) {
        SharedPreferences shrd = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String store = shrd.getString("task", null);


            Type type = new TypeToken<ArrayList<String>>() 
            {}.getType();
            return gson.fromJson(store, type);


    }
}







