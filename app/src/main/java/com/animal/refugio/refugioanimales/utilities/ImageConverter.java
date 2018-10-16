package com.animal.refugio.refugioanimales.utilities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageConverter {

    public ImageConverter(){}

    public Bitmap byteToBmp(byte[] image){
        Bitmap bmp = BitmapFactory.decodeByteArray(image, 0, image.length);
        return bmp;
    }
}
