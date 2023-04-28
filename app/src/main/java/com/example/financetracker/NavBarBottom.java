package com.example.financetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.financetracker.databinding.NavbottombarBinding;
import android.os.Bundle;


public class NavBarBottom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NavbottombarBinding binding = NavbottombarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        // Add any other code that you want to run when the activity is created here
        binding.bottomNavigationView2.setOnItemSelectedListener(item -> {

                    switch (item.getItemId()){
                        case R.id.Home:
                            replaceFragment(new HomeFragment());
                        case R.id.Assets:
                            replaceFragment(new AssetsFragment());
                        case R.id.Stats:
                            replaceFragment(new StatsFragment());
                    }
                    return true;
                }

        );
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.Frame_layout , fragment);
        fragmentTransaction.commit();
    }


    private class HomeFragment extends Fragment {
    }

    private class AssetsFragment extends Fragment {
    }

    private class StatsFragment extends Fragment {
    }
}
