package com.bsj4444.samplebuttonmenu.test;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bsj4444.samplebuttonmenu.R;

/**
 * Created by Administrator on 2016.10.25.
 */
public class DropTest extends Activity{

    private LinearLayout mHiddenView;
    private float mDensity;
    private int mHiddenViewMeasureHeight;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.drop_layout);
        mHiddenView=(LinearLayout)findViewById(R.id.hidden_view);
        //获取像素密度
        mDensity=getResources().getDisplayMetrics().density;
        Log.d("bei","density is "+mDensity);
        //获取布局高度
        mHiddenViewMeasureHeight=(int)(mDensity*40+0.5);
    }

    public void llClick(View view){
        if(mHiddenView.getVisibility()== View.GONE){
            animateOpen(mHiddenView);
        }else{
            animateClose(mHiddenView);
        }
    }

    public void animateOpen(LinearLayout view){
        view.setVisibility(View.VISIBLE);
        ValueAnimator animator=createDropAnimator(view,0,mHiddenViewMeasureHeight);
        animator.start();
    }
    public void animateClose(final LinearLayout view){
        int origHeight=view.getHeight();
        ValueAnimator animator=createDropAnimator(view,origHeight,0);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.GONE);
            }
        });
        animator.start();
    }
    private ValueAnimator createDropAnimator(final View view,int start,int end){
        ValueAnimator animator=ValueAnimator.ofInt(start,end);
        animator.addUpdateListener(
                new ValueAnimator.AnimatorUpdateListener(){

                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int value=(Integer)animation.getAnimatedValue();
                        ViewGroup.LayoutParams layoutParams=view.getLayoutParams();
                        layoutParams.height=value;
                        view.setLayoutParams(layoutParams);
                    }
                }
        );
        return animator;
    }
}
