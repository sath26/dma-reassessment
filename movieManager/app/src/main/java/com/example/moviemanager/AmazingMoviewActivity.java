package com.example.moviemanager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviemanager.model.Movie;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

public class AmazingMoviewActivity extends AppCompatActivity {

    private ImageView ivImageViewBackdrop;
    private TextView tvOverView;
    private Movie movie;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        Toolbar toolbar;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
     setSupportActionBar(toolbar);

        ivImageViewBackdrop = findViewById(R.id.ivMovieBackdrop);
        tvOverView = findViewById(R.id.tvOverview);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Movie saved as favourite", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            movie = (Movie)extras.getSerializable("Movie");
            this.setTitle(movie.getTitle());
            tvOverView.setText(movie.getOverview());
            Picasso.get().load(movie.getBackdropPath()).into(ivImageViewBackdrop);
        }
    }
}