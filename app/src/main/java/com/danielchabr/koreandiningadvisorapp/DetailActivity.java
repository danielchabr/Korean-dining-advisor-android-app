package com.danielchabr.koreandiningadvisorapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.danielchabr.koreandiningadvisorapp.model.Meal;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {

    Meal meal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        Bundle extras = getIntent().getExtras();
        meal = Parcels.unwrap(extras.getParcelable("selectedMeal"));

        TextView nameKorean = (TextView) findViewById(R.id.nameKorean);
        TextView nameEnglish = (TextView) findViewById(R.id.nameEnglish);
        ImageView photo = (ImageView) findViewById(R.id.meal_image);
        TextView description = (TextView) findViewById(R.id.meal_description);

        nameKorean.setText(meal.getNameKorean());
        nameEnglish.setText(meal.getNameEnglish());
        description.setText(meal.getDescription());
        if (meal.hasPhoto()) {
            photo.setImageBitmap(meal.loadPhoto(this));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_edit) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
