package com.example.ji.lab4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button button;
    LinearLayout page1;
    LinearLayout page2;

    Animation right_close;
    Animation left_open;
    boolean pageState = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        page1 = (LinearLayout)findViewById(R.id.page1);
        page2 = (LinearLayout)findViewById(R.id.page2);

        right_close = AnimationUtils.loadAnimation(this, R.anim.translate_right);
        left_open = AnimationUtils.loadAnimation(this, R.anim.translate_left);

        button.setOnClickListener(new View.OnClickListener() { //if you press button
            public void onClick(View view) {

                if(pageState) //ture :page2 oepned -> page2 closing
                {
                    page2.setVisibility(View.GONE);
                    page2.startAnimation(right_close);
                    button.setText("OPEN PAGE");
                    pageState = false;
                }
                else //false : page2 closed -> page2 oepning
                {
                    page2.startAnimation(left_open );
                    page2.setVisibility(View.VISIBLE);
                    button.setText("CLOSE PAGE");
                    pageState = true;
                }
            }
        });

    }
}