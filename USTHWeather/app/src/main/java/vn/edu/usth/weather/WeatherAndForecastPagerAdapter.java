package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class WeatherAndForecastPagerAdapter extends FragmentPagerAdapter {

    public WeatherAndForecastPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // Return different fragments based on the tab position
        switch (position) {
            case 0:
                return WeatherFragment.newInstance("Viet Nam");
            case 1:
                return WeatherFragment.newInstance("France");
            case 2:
                return ForecastFragment.newInstance("India");
            default:
                return WeatherFragment.newInstance("Viet Nam"); // Fallback in case of error
        }
    }

    @Override
    public int getCount() {
        return 3; // Number of pages
    }
}
