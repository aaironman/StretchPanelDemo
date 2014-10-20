package com.example.stretchpaneldemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private void init() {
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);   
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.button1: 
                intent.setClass(MainActivity.this, SimpleActivity.class);
                break;
            case R.id.button2:
                intent.setClass(MainActivity.this, ScrollActivity.class);
                break;
            case R.id.button3:
                intent.setClass(MainActivity.this, LstActivity.class);
                break;
            case R.id.button4:
                intent.setClass(MainActivity.this, UseInXMLActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }

}
