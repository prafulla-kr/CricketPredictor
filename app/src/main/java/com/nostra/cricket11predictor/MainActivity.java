package com.nostra.cricket11predictor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    CardView c1,c2,c3,c4;
    Button button;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private ProgressBar progressBar;
    ImageView img1;
    String webUrl = "http://269.win.qureka.com/";
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("HOME");
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Cricket");

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        t1 = findViewById(R.id.tv1);
        t2 = findViewById(R.id.tv2);
        t3 = findViewById(R.id.tv3);
        t4 = findViewById(R.id.tv4);
        t5 = findViewById(R.id.tv5);
        t6 = findViewById(R.id.tv6);
        t7 = findViewById(R.id.tv7);
        t8 = findViewById(R.id.tv8);
        t9 = findViewById(R.id.tv9);
        t10 = findViewById(R.id.tv10);
        t11 = findViewById(R.id.tv11);
        t12 = findViewById(R.id.tv12);
        c1 = findViewById(R.id.cd1);
        c2 = findViewById(R.id.cd2);
        c3 = findViewById(R.id.cd3);
        c4 = findViewById(R.id.cd4);

        button = findViewById(R.id.btn);
        //img1 = findViewById(R.id.iplcricket);
    }

    @Override
    protected void onStart() {
        super.onStart();
        progressBar = new ProgressBar(this);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String val_series=dataSnapshot.child("1").child("series").getValue(String.class);
                t1.setText(val_series);
                String val_match=dataSnapshot.child("1").child("match").getValue(String.class);
                t2.setText(val_match);
                String val_desc=dataSnapshot.child("1").child("date").getValue(String.class);
                t3.setText(val_desc);
                String val_series2=dataSnapshot.child("2").child("series").getValue(String.class);
                t4.setText(val_series2);
                String val_match2=dataSnapshot.child("2").child("match").getValue(String.class);
                t5.setText(val_match2);
                String val_desc2=dataSnapshot.child("2").child("date").getValue(String.class);
                t6.setText(val_desc2);
                String val_series3=dataSnapshot.child("3").child("series").getValue(String.class);
                t7.setText(val_series3);
                String val_match3=dataSnapshot.child("3").child("match").getValue(String.class);
                t8.setText(val_match3);
                String val_desc3=dataSnapshot.child("3").child("date").getValue(String.class);
                t9.setText(val_desc3);
                String val_series4=dataSnapshot.child("4").child("series").getValue(String.class);
                t10.setText(val_series4);
                String val_match4=dataSnapshot.child("4").child("match").getValue(String.class);
                t11.setText(val_match4);
                String val_desc4=dataSnapshot.child("4").child("date").getValue(String.class);
                t12.setText(val_desc4);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"User Not Found",Toast.LENGTH_LONG).show();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://269.win.qureka.com/"));
                startActivity(intent);*/
                CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                customIntent.setToolbarColor(ContextCompat.getColor(MainActivity.this,R.color.customchrometab));
                openCustomTab(MainActivity.this, customIntent.build(), Uri.parse(webUrl));
            }
        });

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,Question.class);
                i.putExtra("Id","1");

                startActivity(i);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,Question.class);
                i.putExtra("Id","2");

                startActivity(i);
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,Question.class);
                i.putExtra("Id","3");

                startActivity(i);
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(MainActivity.this,Question.class);
                i.putExtra("Id","4");

                startActivity(i);
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
      /*  img1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                customIntent.setToolbarColor(ContextCompat.getColor(MainActivity.this,R.color.customchrometab));
                openCustomTab(MainActivity.this, customIntent.build(), Uri.parse(webUrl));
            }
        });
           <ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/iplcricket"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:clickable="true"
        android:src="@drawable/banner"/>*/
    }
    public static void openCustomTab(Activity activity, CustomTabsIntent customTabsIntent, Uri uri) {
        // package name is the default package
        // for our custom chrome tab
        String packageName = "com.android.chrome";
        if (packageName != null) {
            customTabsIntent.intent.setPackage(packageName);
            customTabsIntent.launchUrl(activity, uri);
        } else {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
    }
}