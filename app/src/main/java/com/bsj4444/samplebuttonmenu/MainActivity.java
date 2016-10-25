package com.bsj4444.samplebuttonmenu;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bsj4444.samplebuttonmenu.test.DropTest;
import com.bsj4444.samplebuttonmenu.test.PropertyTest;
import com.bsj4444.samplebuttonmenu.test.TimerTest;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnDrop(View view) {
        startActivity(new Intent(this, DropTest.class));
    }

    public void btnProperty(View view) {
        startActivity(new Intent(MainActivity.this, PropertyTest.class));
    }

    public void btnTimer(View view) {
        startActivity(new Intent(this, TimerTest.class));
    }
}
