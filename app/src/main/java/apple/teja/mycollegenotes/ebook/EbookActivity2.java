package apple.teja.mycollegenotes.ebook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;
import java.util.List;

import apple.teja.mycollegenotes.R;


public class EbookActivity2 extends AppCompatActivity{

    private RecyclerView ebookRecycler2;

    private Context context;
    private ProgressBar progressebook2;
    private DatabaseReference reference;
    private List<EbookData2>list;
    private EbookAdapter2 adapter;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook2);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        AdView mAdView;
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ebookRecycler2 = findViewById(R.id.ebookRecycler2);
        reference = FirebaseDatabase.getInstance().getReference().child("pdf2");

        progressebook2 = findViewById(R.id.progressebook2);

        getData();
    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list = new ArrayList<>();
                for(DataSnapshot  snapshot : dataSnapshot.getChildren()){
                    EbookData2 data = snapshot.getValue(EbookData2.class);
                    list.add(0,data);
                }

                adapter = new EbookAdapter2(EbookActivity2.this,list);
                ebookRecycler2.setAdapter(adapter);
                ebookRecycler2.setLayoutManager(new LinearLayoutManager(EbookActivity2.this));
                progressebook2.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                progressebook2.setVisibility(View.GONE);

                Toast.makeText(EbookActivity2.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}