package apple.teja.mycollegenotes;

import static apple.teja.mycollegenotes.R.id.drawer_layout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Objects;

import apple.teja.mycollegenotes.courses.courses;
import apple.teja.mycollegenotes.ebook.EbooksAct;
import apple.teja.mycollegenotes.webactivity.WebViewActivity2;
import apple.teja.mycollegenotes.webactivity.Webacctivity3;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private BottomNavigationView bottomNavigationView ;
    private View navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    private NavHostFragment navHostFragment;
    Intent activityIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FirebaseMessaging.getInstance().subscribeToTopic("Notification");


        bottomNavigationView = findViewById(R.id.bottomNavigationView);


        drawerLayout = findViewById(drawer_layout);

        navigationView = findViewById(R.id.navigation_view);


        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();


        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        toggle.onOptionsItemSelected(item);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.navigation_ebook:
                startActivity(new Intent(this, EbooksAct.class));
                break;


            case R.id.navigation_website:
                startActivity(new Intent(this, WebViewActivity2.class));
                break;

            case R.id.navigation_rate:
                Intent intent1 = new Intent();
                intent1.setAction(Intent.ACTION_VIEW);
                intent1.addCategory(Intent.CATEGORY_BROWSABLE);
                intent1.setData(Uri.parse(getString(R.string.rate)));
                startActivity(intent1);
                break;

            case R.id.navigation_share:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Hi! Download Mrits from Play-store to stay updated on latest college updates " +
                        getString(R.string.rate1);
                String shareSubject = "Your Subject Here";
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                break;



            case R.id.navigation_placements:
                startActivity(new Intent(this, courses.class));
                break;


            case R.id.jntuhresults:
                startActivity(new Intent(this, Webacctivity3.class));
                break;


        }

        return true;
    }
}