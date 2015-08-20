package com.example.henri_000.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;


public class MainActivity extends ActionBarActivity {

    private EditText topInput;
    private EditText bottomInput;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topInput = (EditText)findViewById(R.id.topEditText);
        bottomInput = (EditText)findViewById(R.id.bottomEditText);
        text = (TextView)findViewById(R.id.preferencesDisplay);

    }


    public void onSave(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", topInput.getText().toString());
        editor.putString("password", bottomInput.getText().toString());
        editor.apply();
    }

    public void onDisplay(View view){
        SharedPreferences preferences = getSharedPreferences("userInfo", CONTEXT_RESTRICTED);
        text.setText(preferences.getString("username", "") + "\n" + preferences.getString("password", ""));
    }

}
