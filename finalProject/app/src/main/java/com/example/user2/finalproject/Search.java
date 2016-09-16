package com.example.user2.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnSearch=(Button) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText search=(EditText) findViewById(R.id.search);
                if (search.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please enter the name of the movie",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent intent =new Intent(Search.this,SearchResults.class);
                    Bundle bundle = new Bundle();

                    String textSearch=search.getText().toString();

                    bundle.putString("searchText",textSearch );

                    intent.putExtras(bundle);
                    startActivity(intent);

                    search.setText("");
                }
            }
        });
    }

}
