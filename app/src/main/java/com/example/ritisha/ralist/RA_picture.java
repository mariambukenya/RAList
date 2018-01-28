package com.example.ritisha.ralist;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class RA_picture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ra_picture);

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.ritisha.ralist.ITEM_INDEX", -1);

        if (index > -1){
            int pic = getImage(index);
            ImageView img = (ImageView)findViewById(R.id.imageView);
            scaleImg(img, pic);
        }

    }

    private int getImage(int index){
        switch (index) {
            case 0: return R.drawable._lilo;
            case 1: return R.drawable._stitch;
            case 2: return R.drawable._belle;
            case 3: return R.drawable._jasmine;
            case 4: return R.drawable._jafar;
            case 5: return R.drawable._aladdin;
            case 6: return R.drawable._moana;
            case 7: return R.drawable._maui;
            case 8: return R.drawable._elsa;
            case 9: return R.drawable._anna;
            case 10: return R.drawable._ariel;
            case 11: return R.drawable._mulan;
            case 12: return R.drawable._merida;
            case 13: return R.drawable._judy;
            default: return -1;
        }
    }

    private void scaleImg (ImageView img, int pic){
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imgWidth > screenWidth){
            int ratio = Math.round((float)imgWidth/(float)screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);
    }
}
