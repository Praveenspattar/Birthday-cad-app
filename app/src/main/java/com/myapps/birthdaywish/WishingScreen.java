package com.myapps.birthdaywish;

import androidx.appcompat.app.AppCompatActivity;

import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.myapps.birthdaywish.databinding.ActivityWishingScreenBinding;

import java.io.File;
import java.io.FileOutputStream;

public class WishingScreen extends AppCompatActivity {

    //View Binding
    ActivityWishingScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWishingScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //To take the input
        Intent intent = getIntent();
        String name = intent.getExtras().getString("Name");

        binding.name.setText(name);

        //Share button
        binding.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Share the image
                Bitmap image = getBitmapFromView(binding.finalImage);
                shareImageAndText(image);

            }
        });
    }

    private void shareImageAndText(Bitmap image) {
        Uri uri = getImageToShare(image);
        Intent intent = new Intent(Intent.ACTION_SEND);

        //putting the uri of image to be shared
        intent.putExtra(Intent.EXTRA_STREAM,uri);

        //adding the message of happy birthday
        intent.putExtra(Intent.EXTRA_SUBJECT,"Happy Birthday and many many Happy returns of the day");

        //setting type of image
        intent.setType("image/png");

        //calling startActivity to share
        startActivity(Intent.createChooser(intent, "Share image via:"));

    }

    private Uri getImageToShare(Bitmap image) {
        File imageFolder = new File(getCacheDir(), "images");
        Uri uri = null;
        try{
            imageFolder.mkdirs();
            File file = new File(imageFolder, "birthday_image.png");
            FileOutputStream outputStream = new FileOutputStream(file);
            image.compress(Bitmap.CompressFormat.PNG,100,outputStream);
            outputStream.flush();
            outputStream.close();
            uri = FileProvider.getUriForFile(this,"com.myapps.shareimage.fileprovider",file);

        }catch (Exception e){
            Toast.makeText(this,"" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    return uri;}

    private Bitmap getBitmapFromView(View view) {
        //Define Bitmap of same size
        Bitmap returnBitmap = Bitmap.createBitmap(view.getWidth(),view.getHeight(),Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnBitmap);
        //Get the background view of layout
        Drawable background = view.getBackground();
        if (background != null){
            background.draw(canvas);
        }else {
            canvas.drawColor(Color.WHITE);
        }
        //drawing view on canvas
        view.draw(canvas);

        return returnBitmap;
    }
}