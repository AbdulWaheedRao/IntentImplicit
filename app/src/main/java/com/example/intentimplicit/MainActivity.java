package com.example.intentimplicit;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btnclick,btnpicture;
ImageView ivempty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnclick=findViewById(R.id.btnclick);
        ivempty=findViewById(R.id.ivempty);
        btnpicture=findViewById(R.id.btnpicture);
        ActivityResultLauncher<Void> resultLauncher=registerForActivityResult(new ActivityResultContracts.PickContact(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {

                Intent intent=getIntent();
                intent.setData(Uri.parse(""));
//                if (intent.resolveActivity(getPackageManager()) != null){
//                }
            }


        });

        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            resultLauncher.launch(null);
            }
        });
        ActivityResultLauncher<Void> resultLauncher1=registerForActivityResult(new ActivityResultContracts.TakePicturePreview(), new ActivityResultCallback<Bitmap>() {
            @Override
            public void onActivityResult(Bitmap result) {
               ivempty.setImageBitmap(result);
            }
        });
        btnpicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultLauncher1.launch(null);
            }
        });

    }
}