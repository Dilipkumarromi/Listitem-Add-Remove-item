package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
        ListView listview;
        ArrayList<String>list;
        Button btn,Rmbtn;
        EditText editText;
        ArrayAdapter<String>arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=(ListView)findViewById(R.id.listview);
        btn=(Button)findViewById(R.id.btn);
        Rmbtn=(Button)findViewById(R.id.Rmbtn);
        editText=(EditText)findViewById(R.id.txtBox);
        list=new ArrayList<String>();
        arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,list);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=editText.getText().toString();
                list.add(name);
                listview.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
                editText.setText("");//empty textbox

            }
        });
        //remove ListItem in the List
        Rmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0;i<list.size();i++)
                {
                    String getname=editText.getText().toString();
                    if(list.get(i).equals(getname))
                    {
                        list.remove(i);
                        arrayAdapter.notifyDataSetChanged();
                        break;

                    }
                    else {
                        Toast.makeText(MainActivity.this, "no item matched", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

       
    }
}