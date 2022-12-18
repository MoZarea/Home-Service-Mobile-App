package com.example.homeservise.Home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.example.homeservise.OrdersFragment;
import com.example.homeservise.R;
import com.example.homeservise.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    AppBarConfiguration appBarConfiguration;
    NavController navController;
    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    CategoryViewModel categoryViewModel;
    ServicesViewModel servicesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //inflate xml layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(binding.getRoot());

        servicesViewModel=new ViewModelProvider(this).get(ServicesViewModel.class);

        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
//        categoryViewModel.


        //bind views from layout
        toolbar = binding.toolbar;
        navigationView = binding.navigationDrawer;
        bottomNavigationView = binding.bottomNavigation;
        drawerLayout = binding.drawerLayout;
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_container);


        //for bottom nav bar
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        // for nav drawer
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
                .setDrawerLayout(drawerLayout).build();
        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);


        //TODO  COMPLETE BOTTOM BAR ICON
        //TODO COMPLETE MENU ITEM
        //TODO COMPLETE UI OF SCREENS
        //TODO NAVIGATION BETWEEN SCREENS
        //TODO VIEW MODEL

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                if(navDestination.getId()==R.id.detailsFragment||
                        navDestination.getId()==R.id.pickDateTimeFragment||
                        navDestination.getId()==R.id.pickAddressFragment||
                        navDestination.getId()==R.id.profileFragment||
                        navDestination.getId()==R.id.featureFragment
                ){
                    bottomNavigationView.setVisibility(View.GONE);

                }
                else{
                    bottomNavigationView.setVisibility(View.VISIBLE);
                }

            }
        });



    }


}