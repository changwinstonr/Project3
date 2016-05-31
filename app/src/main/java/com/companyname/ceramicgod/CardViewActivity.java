package com.companyname.ceramicgod;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CardViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        Cursor cursor = DatabaseHelper.getInstance(CardViewActivity.this).getAllReviews();
        CursorAdapter cursorAdapter = new CursorAdapter(this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                View view = layoutInflater.inflate(R.layout.simple_review, viewGroup, false);
                return view;
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView name = (TextView) view.findViewById(R.id.name);
                String nameText = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
                name.setText("Name: " + nameText);

                TextView rating = (TextView) view.findViewById(R.id.rating);
                String ratingText = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_RATING));
                rating.setText("Rating: " + ratingText);

                TextView date = (TextView) view.findViewById(R.id.date);
                String dateText = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DATE));
                date.setText("Date: " + dateText);

                TextView comments = (TextView) view.findViewById(R.id.comments);
                String commentsText = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_COMMENTS));
                comments.setText("Comments: " + commentsText);

                TextView address = (TextView) view.findViewById(R.id.address);
                String addressText = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_ADDRESS));
                address.setText("Address: " + addressText);

                ImageView image = (ImageView) view.findViewById(R.id.image);
                image.setImageResource(R.mipmap.ic_launcher);
            }
        };

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(cursorAdapter);
    }
}