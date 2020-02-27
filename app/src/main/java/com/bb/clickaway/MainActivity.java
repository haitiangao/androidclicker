package com.bb.clickaway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_READ_MEDIA = 0;
    private TextView myTextView;
    private ImageView myImageView;
    private Button pressButton;
    private Button saveButton;
    private Button resetButton;
    private int age=0;
    private FileFunctions fileio = new FileFunctions(this);
    private String fileTextStuff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTextView = findViewById(R.id.main_textview);
        myImageView = findViewById(R.id.main_imageview);
        pressButton = findViewById(R.id.pressHere);
        resetButton = findViewById(R.id.resetButton);
        saveButton = findViewById(R.id.saveButton);


        File file = new File(this.getFilesDir().getPath(),"save.sav");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else
            myTextView.setText(fileio.loadDoc());


        pressButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                age=Integer.parseInt(myTextView.getText().toString());

                if (age==18)
                    Toast.makeText(MainActivity.this, "Happy 18! You can vote now!", Toast.LENGTH_SHORT).show();
                else if (age==21)
                    Toast.makeText(MainActivity.this, "Cheers to 21, you can drink now!", Toast.LENGTH_SHORT).show();
                else if (age==40)
                    Toast.makeText(MainActivity.this, "Midlife crisis hitting you yet?", Toast.LENGTH_SHORT).show();
                else if (age==60)
                    Toast.makeText(MainActivity.this, "Time to retire.", Toast.LENGTH_SHORT).show();
                else if (age==100)
                    Toast.makeText(MainActivity.this, "You're a centennial now!", Toast.LENGTH_SHORT).show();
                else if (age==123)
                    Toast.makeText(MainActivity.this, "The oldest person to date is 122 years and 164 days old. You just passed him!", Toast.LENGTH_SHORT).show();
                else if (age>130)
                    Toast.makeText(MainActivity.this, "You sure you're still alive?", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Happy birthday!", Toast.LENGTH_SHORT).show();

                myTextView.setText(Integer.toString(age+1));

                Log.d("TAG_X","Text Pressed...");

            }

        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myTextView.setText("0");
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileio.saveDoc();
            }
        });


    }





}
