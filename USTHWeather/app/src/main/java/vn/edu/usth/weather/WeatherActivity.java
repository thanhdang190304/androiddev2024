package vn.edu.usth.weather;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {

    private static final String TAG = "WeatherActivity";

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
    }

    // Create the options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu); // Inflate the menu
        return true;
    }

    // Handle menu item selections
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

                // Simulate network request


            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Simulate a network request using Thread and Handler
    private void simulateNetworkRequest() {
        // Show a toast to indicate that refresh started
        Toast.makeText(this, "Refreshing...", Toast.LENGTH_SHORT).show();

        // Start a new thread to simulate a network request
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Simulate network delay (2 seconds)
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // After delay, update the UI on the main thread using a Handler
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        // Show a toast to indicate that refresh is complete
                        Toast.makeText(WeatherActivity.this, "Refresh Complete!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();
    }
}

