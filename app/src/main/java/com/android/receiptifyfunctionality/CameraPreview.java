package com.android.receiptifyfunctionality;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import java.io.IOException;

import static android.content.ContentValues.TAG;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder surfaceHolder;
    private Camera camera;

    public CameraPreview(Context context, Camera camera) {
        super(context);

        this.camera = camera;

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

        //Tell camera where to draw preview
        try {
            camera.setPreviewDisplay(surfaceHolder);
            camera.startPreview();
        } catch (IOException e) {
            Log.d(TAG, "surfaceCreated: " + e.getMessage());
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        //If preview can change or rotate, take care of events here

        if(surfaceHolder.getSurface() == null) {
            //preview surface does not exist
            return;
        }

        Camera.Parameters parameters = camera.getParameters();

        camera.setDisplayOrientation(90);

        //stop preview before making changes
        try {
            camera.stopPreview();
        } catch (Exception e) {
            //Ignore: tried to stop a non-existent preview
        }

        try {
            camera.setPreviewDisplay(surfaceHolder);
            camera.startPreview();
        } catch(Exception e) {
            Log.d(TAG, "surfaceChanged: " + e.getMessage());
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
