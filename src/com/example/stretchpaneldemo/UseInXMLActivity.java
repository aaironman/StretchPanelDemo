package com.example.stretchpaneldemo;

import com.example.widget.StretchPanel;

import android.app.Activity;
import android.os.Bundle;

public class UseInXMLActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_in_xml);
        StretchPanel stretchPanel = (StretchPanel) findViewById(R.id.stretchPanel);
        stretchPanel.setHandleClikeEventOnThis(stretchPanel.getContentView());
    }
    
}
