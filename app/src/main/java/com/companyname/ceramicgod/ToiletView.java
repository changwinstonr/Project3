package com.companyname.ceramicgod;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ToiletView extends AppCompatActivity implements PhotoCallback, PhotoCallbackSigns {

    private ImageView mToiletView;
    private ImageView mSignView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toilet_view);

        mToiletView = (ImageView) findViewById(R.id.toilet_image_view);
        Flickr.getInstance(ToiletView.this).doRequest();

        mSignView = (ImageView) findViewById(R.id.toilet_sign_image_view);
        FlickrGroup.getInstance(ToiletView.this).doRequestSigns();
    }

    @Override
    public void handleCallback(String response) {
        Picasso.with(this)
                .load(response)
                .fit()
                .centerCrop()
                .into(mToiletView);
        }
    public void handleCallbackSigns(String response) {
        Picasso.with(this)
                .load(response)
                .fit()
                .centerCrop()
                .into(mSignView);
    }
}