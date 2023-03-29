package apple.teja.mycollegenotes.gallery;

import static apple.teja.mycollegenotes.R.layout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import apple.teja.mycollegenotes.R;

public class GalleryFragment extends Fragment {

    private RecyclerView  otherRecycler;
    private GalleryAdapter adapter;
    private ProgressBar progressBar;
    private List<String> imageList;


    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(layout.fragment_gallery, container, false);

        otherRecycler = view.findViewById(R.id.otherRecycler);
        progressBar = view.findViewById(R.id.progressbar2);


        otherRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        otherRecycler.setHasFixedSize(true);


        reference = FirebaseDatabase.getInstance().getReference().child("gallery");


        getOtherImage();


        return view;
    }

    private void getOtherImage() {
        reference.child("Other Events").addValueEventListener(new ValueEventListener() {

            final List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(0,data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                otherRecycler.setLayoutManager(new GridLayoutManager(getContext(),1));
                otherRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}