package com.example.soronto.myapplication;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

import static android.R.attr.startX;
import static android.R.attr.startY;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Integer> dataList=new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void refresh(View v){
        Log.d("123","LOAD");
        dataList.clear();
        LinearLayout paper=(LinearLayout)findViewById(R.id.view);
        EditText mainInput=(EditText)findViewById(R.id.editText);
        String temp2=mainInput.getText().toString();
        String[] temp1=temp2.split(",");
        for(String i:temp1){
            dataList.add(Integer.parseInt(i));
        }
        paper.removeAllViews();
        paper.addView(new View(this){
            public void onDraw(Canvas canvas){
                final int defaultX=100;
                final int defaultY=1000;

                canvas.drawColor(Color.BLACK);
                Paint MyPaint = new Paint();
                MyPaint.setColor(Color.BLUE);
                MyPaint.setStrokeWidth(30f);
                int startX=defaultX;
                int startY=defaultY;
                int destX=defaultX;
                int destY=defaultY;
                for(int i=0;i<dataList.size();i++){
                    destX+=defaultX;
                    destY=defaultY-dataList.get(i)*100;
                    Log.d("123",startX+":"+startY+":"+destX+":"+destY+":");
                    canvas.drawLine(startX,startY,destX,destY,MyPaint);
                    startX=destX;
                    startY=destY;
                }


            }
        });
    }
}
//
//    public void drawLineXY(Canvas c,Paint p,int startX,int startY,int destX,int destY){
//        final int defaultX=100;
//        final int defaultY=1000;
//        c.drawLine(defaultX+startX,startY,destX,destY,p);
//    }