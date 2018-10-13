package com.bce.toshba.screenshotofwholescrollview;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ScrollView sv_take_ss;
    LinearLayout ll_take_ss;
    Button btn_take_ss1, btn_take_ss2;
    //ListView lv_take_ss;

    Dialog dialogTakeSSAndShare;
    ImageView dialogTakeSSAndShare_iv_screenshot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogTakeSSAndShare = new Dialog(this);
        dialogTakeSSAndShare.setContentView(R.layout.custom_dialog_take_ss_and_show);
        //dialogTakeSSAndShare.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialogTakeSSAndShare_iv_screenshot = (ImageView) dialogTakeSSAndShare.findViewById(R.id.iv_screenshot);

        sv_take_ss = (ScrollView) findViewById(R.id.sv_take_ss);
        ll_take_ss = (LinearLayout) findViewById(R.id.ll_take_ss);
        /*
        lv_take_ss = (ListView) findViewById(R.id.lv_take_ss);

        String[] values = {
                "1)Android - Alert Dialogs", "2)Android - Animations", "3)Android - Auto Complete",
                "4)Android - Bluetooth", "5)Android - Camera", "6)Android - Database", "7)Android - Fonts",
                "8)Android - Gestures", "9)Android - Image", "10)Android - Loading", "11)Android - NFC",
                "12)Android - Text to Speech", "13)Android - Speech to Text", "14)Android - WiFi"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_row, values);
        lv_take_ss.setAdapter(adapter);
*/
        btn_take_ss1 = (Button) findViewById(R.id.btn_take_ss1);
        btn_take_ss2 = (Button) findViewById(R.id.btn_take_ss2);

        btn_take_ss1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap = Bitmap.createBitmap(sv_take_ss.getChildAt(0).getWidth(), sv_take_ss.getChildAt(0).getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                Drawable bgDrawable = sv_take_ss.getBackground();
                if (bgDrawable != null)
                    bgDrawable.draw(canvas);
                else
                    canvas.drawColor(Color.WHITE);
                sv_take_ss.draw(canvas);
                dialogTakeSSAndShare_iv_screenshot.setImageBitmap(bitmap);
                dialogTakeSSAndShare.show();
            }
        });

        btn_take_ss2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap = Bitmap.createBitmap(sv_take_ss.getChildAt(0).getWidth(), sv_take_ss.getChildAt(0).getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                ll_take_ss.draw(canvas);
                dialogTakeSSAndShare_iv_screenshot.setImageBitmap(bitmap);
                dialogTakeSSAndShare.show();
            }
        });
    }
}
