package ca.weihu.petrichor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ExploreYear extends AppCompatActivity {

    private List<Highlight> highlights;
    private ListView listViewHighlights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_explore_year);getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        ((TextView) findViewById(R.id.textViewYear)).setText(Time.currentYear());

        listViewHighlights = (ListView) findViewById(R.id.listViewThisYear);

        highlights = new ArrayList<>();
    }

    @Override
    protected void onStart() {

        super.onStart();

        Account.getDbRefUserTPCs().child("years/" + Time.currentYear() + "/highlights")
                .orderByValue().addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                highlights.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    Highlight highlight = postSnapshot.getValue(Highlight.class);

                    // show only highlights of this year
                    if ( (Time.currentYear().compareTo(
                            Time.convertToYear(highlight.getId()) ) == 0) ) {

                        highlights.add(highlight);
                    }
                }

                HighlightListAdapter highlightsAdapter =
                        new HighlightListAdapter(ExploreYear.this, highlights,
                                HighlightListAdapter.hListPurpose.YEAR);

                listViewHighlights.setAdapter(highlightsAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ExploreYear.this, "Error retrieving highlights.",
                        Toast.LENGTH_SHORT);
            }
        });
    }

    public void onBtnBack(View view) {
        onBackPressed();
    }
}