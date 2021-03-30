package com.example.dashboardtest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Activite extends AppCompatActivity {

    ImageView imageView;
    TextView title, desc;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite);

        ActionBar actionBar=getSupportActionBar();

        if(actionBar!= null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        imageView = findViewById(R.id.another_imageView);
        title = findViewById(R.id.titleText);
        desc = findViewById(R.id.descriptionText);

        if(position==0){
            Intent intent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int pic=bundle.getInt("Image");
            String aTitle=intent.getStringExtra("Title");
            String aDescription=intent.getStringExtra("Desc");

            imageView.setImageResource(pic);
            title.setText(aTitle);
            desc.setText(aDescription);

            actionBar.setTitle(aTitle);
        }
        if(position==1){
            Intent intent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int pic=bundle.getInt("Image");
            String aTitle=intent.getStringExtra("Title");
            String aDescription=intent.getStringExtra("Desc");

            imageView.setImageResource(pic);
            title.setText(aTitle);
            desc.setText(aDescription);

            actionBar.setTitle(aTitle);
        }
        if(position==2){
            Intent intent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int pic=bundle.getInt("Image");
            String aTitle=intent.getStringExtra("Title");
            String aDescription=intent.getStringExtra("Desc");

            imageView.setImageResource(pic);
            title.setText(aTitle);
            desc.setText(aDescription);

            actionBar.setTitle(aTitle);
        }
        if(position==3){
            Intent intent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int pic=bundle.getInt("Image");
            String aTitle=intent.getStringExtra("Title");
            String aDescription=intent.getStringExtra("Desc");

            imageView.setImageResource(pic);
            title.setText(aTitle);
            desc.setText(aDescription);

            actionBar.setTitle(aTitle);
        }
        if(position==4){
            Intent intent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int pic=bundle.getInt("Image");
            String aTitle=intent.getStringExtra("Title");
            String aDescription=intent.getStringExtra("Desc");

            imageView.setImageResource(pic);
            title.setText(aTitle);
            desc.setText(aDescription);

            actionBar.setTitle(aTitle);
        }
    }
}