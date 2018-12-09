package com.khan.zayan.lendapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoanedActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loaned_area);

        final TextView amtLnd = findViewById(R.id.amtLnd);

         FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("https://lendapp-b0f25.firebaseio.com/Name89");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserActivity post = dataSnapshot.getValue(UserActivity.class);
                String r = post.toString();
                amtLnd.setText(r);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });

    }
}
