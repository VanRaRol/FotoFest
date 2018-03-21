package com.example.oriolqa.foto_fest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.List;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * Created by Oriol on 11/03/2018.
 */

public class ChannelDetailActivity extends Activity implements View.OnClickListener {

    TextView personName;
    TextView personAge;
    ImageView personPhoto;

    Button btnTackPic;
    TextView tvHasCamera, tvHasCameraApp;
    ImageView ivThumbnailPhoto;
    Bitmap bitMap;
    static int TAKE_PICTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.events);
        personName = (TextView)findViewById(R.id.person_name);
        personAge = (TextView)findViewById(R.id.person_age);
        personPhoto = (ImageView)findViewById(R.id.person_photo);

        personName.setText("Foto 1");
        personAge.setText("Lavery");
        personPhoto.setImageResource(R.drawable.lavery);



        // Get reference to views
        btnTackPic = (Button) findViewById(R.id.btnTakePic);
        btnTackPic.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        // create intent with ACTION_IMAGE_CAPTURE action
        // create intent with ACTION_IMAGE_CAPTURE action
        /*
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // this part to save captured image on provided path
        File file = new File(Environment.getExternalStorageDirectory(),
                "my-photo.jpg");
        Uri photoPath = Uri.fromFile(file);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoPath);

        // start camera activity
        startActivityForResult(intent, TAKE_PICTURE);
        */

        // create intent with ACTION_IMAGE_CAPTURE action
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // start camera activity
        startActivityForResult(intent, TAKE_PICTURE);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if (requestCode == TAKE_PICTURE && resultCode== RESULT_OK && intent != null){
            // get bundle
            Bundle extras = intent.getExtras();

            // get bitmap
            bitMap = (Bitmap) extras.get("data");
            ivThumbnailPhoto.setImageBitmap(bitMap);

        }
    }

    // method to check if you have a Camera
    private boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }

    // method to check you have Camera Apps
    private boolean hasDefualtCameraApp(String action){
        final PackageManager packageManager = getPackageManager();
        final Intent intent = new Intent(action);
        List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);

        return list.size() > 0;

    }
}
