package com.example.stretchpaneldemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.widget.StretchPanel;
import com.example.widget.StretchPanel.OnStretchListener;

public class SimpleActivity extends Activity implements OnStretchListener, OnClickListener {
    
    private ImageView arrowView;
    private StretchPanel panel;
    private boolean isCurrentChangingStretchView = false;
    private int changeToLayoutId;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        init();
    }
    
    private void init() {
        findViewById(R.id.show_view_1).setOnClickListener(this);
        findViewById(R.id.show_view_2).setOnClickListener(this);
        panel = (StretchPanel) findViewById(R.id.stretchPanel);
        final View contentView = View.inflate(this, R.layout.view_content, null);
        final View stretchView = View.inflate(this, R.layout.view_stretch, null);
        panel.setStretchView(stretchView);
        panel.setContentView(contentView);
        panel.setOnStretchListener(this);
        arrowView = (ImageView) contentView.findViewById(R.id.imageView1);
        contentView.setOnClickListener(new OnClickListener() {
      
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (panel.isStretchViewOpened()) {
                    panel.closeStretchView();
                } else {
                    panel.openStretchView();
                }
            }
        });
    }
    
    private void addStretchView(int layoutId) {
        if (panel != null) {
            View stretchView = View.inflate(this, layoutId, null);
            panel.setStretchView(stretchView);
        }
    }

    @Override
    public void onStretchFinished(final boolean opened) {
        // TODO Auto-generated method stub
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.arrowrote);
        if (opened) {
            arrowView.setImageResource(R.drawable.up);
            arrowView.startAnimation(animation);
        } else {
            arrowView.setImageResource(R.drawable.down);
            arrowView.startAnimation(animation);
        }
        if (isCurrentChangingStretchView) {
            isCurrentChangingStretchView = false;
            addStretchView(changeToLayoutId);
            panel.openStretchView();
        }
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.show_view_1:
                changeToLayoutId = R.layout.view_stretch;
                break;
            case R.id.show_view_2:
                changeToLayoutId = R.layout.view_stretch2;
                break;
            default:
                break;
        }
        if (panel.isStretchViewOpened()) {
            panel.closeStretchView();
            isCurrentChangingStretchView = true;
        } else {
            addStretchView(changeToLayoutId);
            panel.openStretchView();
        }
    }
}
