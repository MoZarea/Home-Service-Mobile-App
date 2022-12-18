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

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                if(item.getItemId()==R.id.callUs){
//                    Intent sendIntent = new Intent();
//
////                    sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
////                    sendIntent.setType("text/plain");
//                    String  number= "+201150191031";
//                    startActivity(
//                            new Intent(Intent.ACTION_VIEW,
//                                    Uri.parse(
//                                            String.format("https://api.whatsapp.com/send?phone=%s&text=%s", number, "بطل صياح")
//                                    )
//                            )
//                    );
//
//                }
//                if(item.getItemId()==R.id.Suggestion){
//                    Intent sendIntent = new Intent();
//                    String  number= "+201150191031";
//                    startActivity(
//                            new Intent(Intent.ACTION_VIEW,
//                                    Uri.parse(
//                                            String.format("https://api.whatsapp.com/send?phone=%s&text=%s", number, "قدم لنا ملاحظاتك او اى شكاوي او مشكلات واجهتها لنتمكن من تحسين الخدمة المقدمة اليكم")
//                                    )
//                            )
//                    );
//
//                }
//
//
//                return false;
//            }
//        });





    }


}