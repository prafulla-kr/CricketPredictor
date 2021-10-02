package com.nostra.cricket11predictor;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Question extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String mid;
    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    private ProgressBar progressBar;
    ImageView img1;
    String webUrl = "http://269.win.qureka.com/";
    private AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);


        getSupportActionBar().setTitle("Questions");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        tv5=findViewById(R.id.tv5);
        tv6=findViewById(R.id.tv6);

        //img1 = findViewById(R.id.rect);

        Intent i = getIntent();
        String MatchId = i.getStringExtra("Id");
        mid = MatchId;

        showQuestion();

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

       /* img1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                customIntent.setToolbarColor(ContextCompat.getColor(Question.this,R.color.customchrometab));
                openCustomTab(Question.this, customIntent.build(), Uri.parse(webUrl));
            }
        });
                    <ImageView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:src="@drawable/rect"
                android:id="@+id/rect"
                android:layout_alignParentBottom="true"
                android:layout_centerHorizontal="true"
                android:clickable="true"
                />*/

    }

    public void showQuestion() {
        progressBar = new ProgressBar(this);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("DtQuestion").child(mid);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final QuestModel dtquestmodel=dataSnapshot.getValue(QuestModel.class);
                tv1.setText(dtquestmodel.getPostedon());
                tv2.setText(dtquestmodel.getVenue());
                tv3.setText(dtquestmodel.getPitchreport());
                tv4.setText(dtquestmodel.getFavourites());
                tv5.setText(dtquestmodel.getDreamteam());
                tv6.setText(dtquestmodel.getNotes());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
    public static void openCustomTab(Activity activity, CustomTabsIntent customTabsIntent, Uri uri) {

        String packageName = "com.android.chrome";
        if (packageName != null) {
            customTabsIntent.intent.setPackage(packageName);
            customTabsIntent.launchUrl(activity, uri);
        } else {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
    }
}
