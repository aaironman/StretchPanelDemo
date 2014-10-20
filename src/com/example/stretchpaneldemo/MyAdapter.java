package com.example.stretchpaneldemo;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stretchpaneldemo.LstActivity.DataModel;
import com.example.widget.StretchPanel;
import com.example.widget.StretchPanel.OnStretchListener;

public class MyAdapter extends BaseAdapter {

    private List<DataModel> list;
    private Context context;
    
    public MyAdapter(List<DataModel> l, Context c) {
        this.list = l;
        this.context = c;
    }
    
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        if (position >= 0 && position < list.size()) {
            return list.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item, null);
            holder = new ViewHolder();
            holder.panel = (StretchPanel) convertView.findViewById(R.id.stretchPanel1);
            final View contentView = View.inflate(context, R.layout.view_content, null);
            final View stretchView = View.inflate(context, R.layout.view_stretch, null);
            holder.panel.setContentView(contentView);
            holder.panel.setStretchView(stretchView);
            holder.panel.setHandleClikeEventOnThis(contentView);
            holder.panel.setStretchAnimationDuration(150);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (position >= 0 && position < list.size()) {
            int num = list.get(position).getId();
            View contentView = holder.panel.getContentView();
            View stretchView =holder.panel.getStretchView();
            TextView textView1 = (TextView) contentView.findViewById(R.id.textView1);
            TextView textView2 = (TextView) stretchView.findViewById(R.id.textView1);
            textView1.setText("ContentView No." + num);
            textView2.setText("StretchView No." + num);
            holder.panel.setStretchViewOpened(list.get(position).isOpenStatus());
            holder.panel.setOnStretchListener(new OnStretchListener() {
    			
    			@Override
    			public void onStretchFinished(boolean isOpened) {
    				setOpenStatu(position,isOpened);
    			}
    		});
            return convertView;
        }
        return null;
    }
    
    private void setOpenStatu(int pos,boolean openStatus){
    	list.get(pos).setOpenStatus(openStatus);
    	notifyDataSetChanged();
    }
    
    private class ViewHolder {
        StretchPanel panel;
    }

}
