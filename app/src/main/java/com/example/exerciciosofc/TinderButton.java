package com.example.exerciciosofc;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TinderButton extends androidx.appcompat.widget.AppCompatButton {

    public TinderButton(Context context) {
        super(context);
        this.setText("Tinder Button");
    }

    public TinderButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TinderButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setText("Tinder Button");
    }

    // onDraw: Recebe um canvas, que vai conter a região que vai ser desenhada. O que desenhar no canvas vai aparecer pro usuario
    //
    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
    }

    int x0, xy, colorR, colorG, colorB;
    // onTouch: chamada quando o componente for clicado
    // EventLoop
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getRawX();
        float y = event.getRawY();
        int action = event.getAction();
        Log.d("position", "X: " + x + " Y: " + " Event: " + event.getAction());

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            x0 =  (int)x;
            xy = (int)y;
        }

        int dx = (int)(x - x0);
        if(event.getAction() == MotionEvent.ACTION_MOVE){
            colorR = Math.min(255, Math.max(0, 120 - dx / 5));
            colorG = Math.min(255, Math.max(0, 120 + dx / 5));
            colorB = 120;
        }

        if(event.getAction() == MotionEvent.ACTION_UP){
            colorR=120; colorG=120; colorB=120;
        }

        this.setBackgroundColor(Color.rgb(colorR, colorG, colorB));

        return super.onTouchEvent(event);
    }
}