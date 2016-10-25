package com.bsj4444.samplebuttonmenu.test;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

import com.bsj4444.samplebuttonmenu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016.10.25.
 */
public class PropertyTest extends Activity{

    private boolean flag=false;
    private List<ImageView> mImageView;
    private int[] id={R.id.mImageView1,R.id.mImageView2,R.id.mImageView3,
                        R.id.mImageView4,R.id.mImageView5};
    @Override
    protected void onCreate(Bundle SaveInstanceState){
        super.onCreate(SaveInstanceState);
        setContentView(R.layout.property_layout);
        mImageView=new ArrayList<>();
        for(int i=0;i<5;i++){
            ImageView imageView=(ImageView)findViewById(id[i]);
            mImageView.add(imageView);
        }
        mImageView.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==false){
                    startAnim();
                }else{
                    closeAnim();
                }
            }
        });
    }

    private void startAnim(){
        ObjectAnimator animator0=ObjectAnimator.ofFloat(
                mImageView.get(0),
                "alpha",
                1f,
                0.5f
        );
        ObjectAnimator animator1=ObjectAnimator.ofFloat(
                mImageView.get(1),
                "translationY",
                200f
        );
        ObjectAnimator animator2=ObjectAnimator.ofFloat(
                mImageView.get(2),
                "translationX",
                200f
        );
        ObjectAnimator animator3=ObjectAnimator.ofFloat(
                mImageView.get(3),
                "translationY",
                -200f
        );
        ObjectAnimator animator4=ObjectAnimator.ofFloat(
                mImageView.get(4),
                "translationX",
                -200f
        );
        AnimatorSet set=new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());//反弹效果
        set.playTogether(
                animator0,
                animator1,
                animator2,
                animator3,
                animator4
        );
        set.start();
        flag=true;
    }
    private void closeAnim(){
        ObjectAnimator animator0=ObjectAnimator.ofFloat(
                mImageView.get(0),
                "alpha",
                0.5f,
                1f
        );
        ObjectAnimator animator1=ObjectAnimator.ofFloat(
                mImageView.get(1),
                "translationY",
                200f,0
        );
        ObjectAnimator animator2=ObjectAnimator.ofFloat(
                mImageView.get(2),
                "translationX",
                200f,0
        );
        ObjectAnimator animator3=ObjectAnimator.ofFloat(
                mImageView.get(3),
                "translationY",
                -200f,0
        );
        ObjectAnimator animator4=ObjectAnimator.ofFloat(
                mImageView.get(4),
                "translationX",
                -200f,0
        );
        AnimatorSet set=new AnimatorSet();
        set.setDuration(500);
        set.playTogether(
                animator0,animator1,animator2,animator3,animator4
        );
        set.start();
        flag=false;
    }
}
