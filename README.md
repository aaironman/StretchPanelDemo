StretchPanelDemo
================

The layout that can stretch with animation.

Instruction
===========
The layout that can stretch with animation.You can add the listener of the animation and deal with what you want.

![alt text](https://github.com/aaironman/StretchPanelDemo/raw/master/sreen1.png "mickey1")        ![alt text](https://github.com/aaironman/StretchPanelDemo/raw/master/screen2.png "mickey2")

Usage
=======
##Layout

```java
<com.example.widget.StretchPanel
        xmlns:stretch="http://schemas.android.com/apk/res-auto"
        android:id="@+id/stretchPanel"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:layout_marginTop="10dp"
        stretch:contentView="@layout/view_content"
        stretch:stretchView="@layout/view_stretch"
        android:padding="2dip" >
    </com.example.widget.StretchPanel>
 ```
##Init with code
```java
 // if no ids of the view in xml
    final StretchPanel panel = (StretchPanel) findViewById(R.id.stretchPanel);
    final View contentView = View.inflate(this, R.layout.view_content, null);
    final View stretchView = View.inflate(this, R.layout.view_stretch, null);
    panel.setStretchView(stretchView);
    panel.setContentView(contentView);
    panel.setStretchAnimationDuration(200);
    panel.setHandleClikeEventOnThis(contentView);//set the view response the click event
```
```java 
 // have the id in xml
    final StretchPanel panel = (StretchPanel) findViewById(R.id.stretchPanel);
    panel.setHandleClikeEventOnThis(panel.getContentView());
```

