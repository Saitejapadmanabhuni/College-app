package apple.teja.mycollegenotes.home;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import apple.teja.mycollegenotes.R;
import apple.teja.mycollegenotes.slideradapter.SliderAdapter;
import apple.teja.mycollegenotes.slideradapter.SliderData;


public class HomeFragment extends Fragment {

    private RecyclerView deleteNoticeRecycler;

    private ProgressBar progressBar;
    private ArrayList<NoticeData1> list;
    private NoticeAdapter1 adapter;
    private DatabaseReference reference;

    private Context context;


    final String url1 = "https://firebasestorage.googleapis.com/v0/b/my-app-admin-61aa6.appspot.com/o/slidingimages%2FWhatsApp%20Image%202023-02-11%20at%2011.59.13%20AM.jpeg?alt=media&token=5dd705a9-592e-4665-8a09-d7bca1bdbdca";
    final String url2 = "https://firebasestorage.googleapis.com/v0/b/my-app-admin-61aa6.appspot.com/o/slidingimages%2FWhatsApp%20Image%202023-02-11%20at%2011.59.14%20AM.jpeg?alt=media&token=eb2ff23c-b887-4976-86ab-7b456cb9804c";
    final String url3 = "https://firebasestorage.googleapis.com/v0/b/my-app-admin-61aa6.appspot.com/o/slidingimages%2FWhatsApp%20Image%202023-02-11%20at%2011.59.14%20AM%20(1).jpeg?alt=media&token=74c5b3f1-5214-4f8d-b764-38a7dcb46d40";


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);


        MobileAds.initialize(getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        AdView mAdView;
        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();
        SliderView sliderView = view.findViewById(R.id.slider);
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setSliderAdapter(adapter);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();


        deleteNoticeRecycler = view.findViewById(R.id.deleteNoticeRecycler);
        progressBar = view.findViewById(R.id.progressBar);

        reference = FirebaseDatabase.getInstance().getReference().child("Notice");


        deleteNoticeRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        deleteNoticeRecycler.setHasFixedSize(true);

        getNotice();

        return view;


    }

    private void getNotice() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    NoticeData1 data = snapshot.getValue(NoticeData1.class);
                    list.add(0, data);
                }
                adapter = new NoticeAdapter1(getContext(), list);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
                deleteNoticeRecycler.setLayoutManager(deleteNoticeRecycler.getLayoutManager());
                deleteNoticeRecycler.setAdapter(adapter);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                progressBar.setVisibility(View.GONE);

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


}



