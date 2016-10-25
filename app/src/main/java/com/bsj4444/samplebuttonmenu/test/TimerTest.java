package com.bsj4444.samplebuttonmenu.test;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bsj4444.samplebuttonmenu.R;

/**
 * Created by Administrator on 2016.10.25.
 */
public class TimerTest extends Activity{

    private TextView textView;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.timer);
        textView=(TextView)findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTimer(textView);
            }
        });
    }

    public void tvTimer(final View view){
        ValueAnimator valueAnimator=ValueAnimator.ofInt(0,100);
        valueAnimator.addUpdateListener(
                new ValueAnimator.AnimatorUpdateListener(){
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation){
                        ((TextView)view).setText("$"+(Integer)animation.getAnimatedValue());
                    }
                }
        );
        valueAnimator.setDuration(3000);
        valueAnimator.start();
    }
}
