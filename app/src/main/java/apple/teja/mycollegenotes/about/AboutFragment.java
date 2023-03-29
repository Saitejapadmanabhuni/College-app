package apple.teja.mycollegenotes.about;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import apple.teja.mycollegenotes.R;
import apple.teja.mycollegenotes.departments.aimlactivity;
import apple.teja.mycollegenotes.departments.csactivity;
import apple.teja.mycollegenotes.departments.cseactivity;
import apple.teja.mycollegenotes.departments.dsactivity;
import apple.teja.mycollegenotes.departments.eceactivity;
import apple.teja.mycollegenotes.departments.itactivity;
import apple.teja.mycollegenotes.webactivity.WebViewActivity2;


public class AboutFragment extends Fragment {
    Intent intent;
    Button csebtn , csbtn , dsbtn , itbtn , aimlbtn , ecebtn ;

    CardView contact;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_about, container, false);

        contact = v.findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), WebViewActivity2.class));
            }
        });



        Button newPage = (Button) v.findViewById(R.id.csebtn);
        newPage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), cseactivity.class);
                startActivity(intent);
            }
        });
        Button newPage1 = (Button) v.findViewById(R.id.csbtn);
        newPage1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), csactivity.class);
                startActivity(intent);
            }
        });
        Button newPage2 = (Button) v.findViewById(R.id.dsbtn);
        newPage2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), dsactivity.class);
                startActivity(intent);
            }
        });


        Button newPage3 = (Button) v.findViewById(R.id.itbtn);
        newPage3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), itactivity.class);
                startActivity(intent);
            }
        });
        Button newPage4 = (Button) v.findViewById(R.id.aimlbtn);
        newPage4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), aimlactivity.class);
                startActivity(intent);
            }
        });
        Button newPage5 = (Button) v.findViewById(R.id.ecebtn);
        newPage5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), eceactivity.class);
                startActivity(intent);
            }
        });



        return v;
    }
}