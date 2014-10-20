package com.example.stretchpaneldemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class LstActivity extends Activity {
    
    private List<DataModel> list = new ArrayList<DataModel>();
    private MyAdapter adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        list.clear();
        for (int i = 0; i < 30; i++) {
        	DataModel dataModel = new DataModel();
        	dataModel.setId(i);
            list.add(dataModel);
        }
        setContentView(R.layout.activity_list);
        init();
    }

    public class DataModel{
    	int id;
    	boolean openStatus = false;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public boolean isOpenStatus() {
			return openStatus;
		}
		public void setOpenStatus(boolean openStatus) {
			this.openStatus = openStatus;
		}
    	
    	
    	
    }
    
    private void init() {
        ListView listView = (ListView) findViewById(R.id.listView1);
        adapter = new MyAdapter(list, this);
        listView.setAdapter(adapter);
    }
}
