package com.example.cs50.wordlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SingerItemView extends LinearLayout {// 뷰 기본 생성자 2개?
    TextView textView, textView2;
    ImageView imageView;
    public SingerItemView(Context context) {
        super(context);
        init(context);
    }

    public SingerItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
     private  void init(Context context){
        //초기화 위한 메소드
         LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         inflater.inflate(R.layout.singer_item, this,true);
            //inflate 하고 참조 가능
          textView = findViewById(R.id.textView);
          textView2 = findViewById(R.id.textView2);
          imageView = findViewById(R.id.imageView);
     }
     public void setName(String name){
        textView.setText(name);
     }
     public  void setMobile(String mobile){
        textView2.setText(mobile);
     }
     public void setImg(int resId){
        imageView.setImageResource(resId);
     }
}
