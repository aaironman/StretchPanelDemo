package com.example.stretchpaneldemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.widget.StretchPanel;
import com.example.widget.StretchPanel.OnStretchListener;

public class ScrollActivity extends Activity {

    private LinearLayout mContainerLayout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        init();
    }
    
    private void init() {
        mContainerLayout = (LinearLayout) findViewById(R.id.container_layout);
        addAStretchPanel();
        addAStretchPanel();
        addAStretchPanel();
        addAStretchPanel();
        addAStretchPanel();
        addAStretchPanel();
        addAStretchPanel();
        addAStretchPanel();
        addAStretchPanel();     
    }
    
    private void addAStretchPanel() {
        StretchPanel panel = new StretchPanel(this);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        panel.setLayoutParams(params);
        panel.setPadding(2, 2, 2, 0);
        final View contentView = View.inflate(this, R.layout.view_content, null);
        final View stretchView = View.inflate(this, R.layout.view_stretch, null);
        final ImageView arrowImageView = (ImageView) contentView.findViewById(R.id.imageView1);
        panel.setContentView(contentView);
        panel.setStretchView(stretchView);
        panel.setStretchAnimationDuration(200);
        panel.setHandleClikeEventOnThis(contentView);
        mContainerLayout.addView(panel);
        panel.setOnStretchListener(new OnStretchListener() {
            
            @Override
            public void onStretchFinished(final boolean opened) {
                // TODO Auto-generated method stub
                Animation animation = AnimationUtils.loadAnimation(ScrollActivity.this, R.anim.arrowrote);
                if (opened) {
                    arrowImageView.setImageResource(R.drawable.up);
                    arrowImageView.startAnimation(animation);
                } else {
                    arrowImageView.setImageResource(R.drawable.down);
                    arrowImageView.startAnimation(animation);
                }
            }
        });
    }
}
