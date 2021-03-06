package ca.weihu.petrichor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.*;
import com.google.firebase.database.ValueEventListener;

public class MyProfile extends AppCompatActivity {
    private TextView userEmail;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference mAccountReference;
    private ValueEventListener mValueListener;
    private static final String TAG = "Unable to update";

    Account acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        //displayInfo();
    }

    /*public void displayInfo(){
        FirebaseUser userid = firebaseAuth.getCurrentUser();
        userEmail =(TextView) findViewById(R.id.nameView);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserInfo user= dataSnapshot.getValue(UserInfo.class);
                userEmail.setText(user.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }*/
    ValueEventListener accountListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            // Get Post object and use the values to update the UI
            Account account = dataSnapshot.getValue(Account.class);
            // ...
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
        }

    };

    public void onBtnBack(View view) {
        onBackPressed();
    }
}
