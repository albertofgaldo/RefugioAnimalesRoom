package com.animal.refugio.refugioanimales.utilities;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ShowMessage {

    public ShowMessage(){}

    public void setMessage(Context context, String text){
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.makeText(context, text,Toast.LENGTH_SHORT).show();
    }
}
