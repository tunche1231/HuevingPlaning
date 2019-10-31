package com.hueving.planner.Actividades;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.hueving.planner.R;

public class PerfilProveedor extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_proveedor);
        imageView = findViewById(R.id.img_perfil);
        Glide.with(this).load("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQA6YZyDt5lblGDHH4O68O3eS3HXYTdl0bbHP_3WsjWk_e3k7mk")
                .apply(RequestOptions.circleCropTransform()).into(imageView);
    }
}
