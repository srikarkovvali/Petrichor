package ca.weihu.petrichor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HighlightActivity extends AppCompatActivity implements HighlightCollection {

    /* What is this code? -T.N.
    @Override
    public Highlight[] returnHighlight() {
        return null;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_highlight);getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    public void OnWeekButton(View view) {
        Intent in = new Intent(getApplicationContext(), ExploreWeek.class);
        startActivity(in);
    }
    public void OnMonthButton(View view) {
        Intent in = new Intent(getApplicationContext(), ExploreMonth.class);
        startActivity(in);
    }
    public void OnYearButton(View view) {
        Intent in = new Intent(getApplicationContext(), ExploreYear.class);
        startActivity(in);
    }
    public void OnSameDayInPastButton(View view) {
        Intent in = new Intent(getApplicationContext(), ExploreTodayInThePast.class);
        startActivity(in);
    }
    public void OnRandomButton(View view) {
        Intent in = new Intent(getApplicationContext(), ExploreVisitARandomDay.class);
        startActivity(in);
    }

    public void onBtnBack(View view) {
        onBackPressed();
    }
}
