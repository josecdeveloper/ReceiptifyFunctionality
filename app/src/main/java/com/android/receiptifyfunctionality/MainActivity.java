package com.android.receiptifyfunctionality;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    private boolean checkCameraHardware(Context context) {
//        if(context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
//            //This device has a camera
//            return true;
//        } else {
//            //No camera on this device
//            Toast.makeText(context, "There is no camera on this device.", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//    }
}
