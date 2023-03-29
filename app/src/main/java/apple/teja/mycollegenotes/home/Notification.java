package apple.teja.mycollegenotes.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.squareup.picasso.Picasso;

import apple.teja.mycollegenotes.R;

public class Notification extends AppCompatActivity {


    ImageView deleteNoticeImage;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        TextView deleteNoticeTitle = findViewById(R.id.deleteNoticeTitle);
        deleteNoticeImage = findViewById(R.id.deleteNoticeImage);
        TextView time = findViewById(R.id.time);
        TextView date = findViewById(R.id.date);

        deleteNoticeTitle.setText(getIntent().getExtras().getString("title"));
        date.setText(getIntent().getExtras().getString("date"));
        time.setText(getIntent().getExtras().getString("time"));
        Picasso.get().load(getIntent().getStringExtra("image")).into(deleteNoticeImage);






        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        AdView mAdView;
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

}