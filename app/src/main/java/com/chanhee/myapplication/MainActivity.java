package com.chanhee.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    RadioGroup radioGroup;
    Switch aSwitch;
    SeekBar seekBar;
    RadioButton btn1,btn2,btn3;
    int red,green,blue=0;
    int shade=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.cat);
        radioGroup=findViewById(R.id.radioGroup);
        aSwitch=findViewById(R.id.swit);
        seekBar=findViewById(R.id.seekbar);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.btn1:
                        red=255;
                        green=0;
                        blue=0;
                        imageView.setColorFilter(Color.argb(shade,red,green,blue));
                        break;
                    case R.id.btn2:
                        red=0;
                        green=255;
                        blue=0;
                        imageView.setColorFilter(Color.argb(shade,red,green,blue) );
                        break;
                    case R.id.btn3:
                        red=0;
                        green=0;
                        blue=255;
                        imageView.setColorFilter(Color.argb(shade,red,green,blue));
                    break;
                    default:imageView.clearColorFilter();
                    break;
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                shade=progress;
                imageView.setColorFilter(Color.argb(progress,red,green,blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
