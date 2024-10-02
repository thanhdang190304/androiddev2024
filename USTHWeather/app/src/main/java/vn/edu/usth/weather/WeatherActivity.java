package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = "WeatherActivity";
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_activity);

        // Set up the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // Set the Toolbar as the action bar

        // Setup ViewPager and TabLayout
        ViewPager viewPager = findViewById(R.id.viewPager);
        WeatherAndForecastPagerAdapter adapter = new WeatherAndForecastPagerAdapter(getSupportFragmentManager(), WeatherAndForecastPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        // Optionally, set tab titles
        if (tabLayout.getTabCount() >= 3) {
            tabLayout.getTabAt(0).setText("Viet Nam");
            tabLayout.getTabAt(1).setText("France");
            tabLayout.getTabAt(2).setText("India");
        }

        // Initialize MediaPlayer with the MP3 file from the raw folder
        mediaPlayer = MediaPlayer.create(this, R.raw.musicc); // Make sure your MP3 file is named correctly (musicc.mp3)

        // Start playing the audio when the app starts
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(true); // Loop the audio if needed
            mediaPlayer.start(); // Start playing the MP3
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "=== APP STARTED ===");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "=== APP RESUMED ===");

        // Resume the audio when the activity resumes
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "=== APP PAUSED ===");

        // Pause the audio when the activity is paused
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "=== APP STOPPED ===");

        // Stop the audio when the activity is stopped
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            try {
                mediaPlayer.prepare(); // Reprepare it to be ready for the next play
            } catch (Exception e) {
                Log.e(TAG, "Error preparing MediaPlayer", e);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "=== APP DESTROYED ===");

        // Release the MediaPlayer resources when the activity is destroyed
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    // Create the options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu); // Inflate the menu
        return true;
    }


}

