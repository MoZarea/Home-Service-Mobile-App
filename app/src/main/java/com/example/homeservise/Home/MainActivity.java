package com.example.homeservise.Home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.homeservise.Data.User.UserData;
import com.example.homeservise.Login.Login;
import com.example.homeservise.R;
import com.example.homeservise.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

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
    UserViewModel userViewModel;
    UserData current_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            startActivity(new Intent(getBaseContext(), Login.class));
        }

        //inflate xml layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(binding.getRoot());


       Intent intent=getIntent();
       String id = intent.getStringExtra("id");
        if(id!=null) {
            SharedPreferences sharedPreferences = getSharedPreferences("my_id",MODE_PRIVATE);
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            myEdit.putString("id", id);
            myEdit.commit();
        }
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        servicesViewModel = new ViewModelProvider(this).get(ServicesViewModel.class);
//        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel = new ViewModelProvider((ViewModelStoreOwner) this, (ViewModelProvider.Factory) new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(UserViewModel.class);


//        categoryViewModel.
        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);


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
                if (navDestination.getId() == R.id.detailsFragment ||
                        navDestination.getId() == R.id.pickDateTimeFragment ||
                        navDestination.getId() == R.id.pickAddressFragment ||
                        navDestination.getId() == R.id.profileFragment ||
                        navDestination.getId() == R.id.featureFragment
                ) {
                    bottomNavigationView.setVisibility(View.GONE);

                } else {
                    bottomNavigationView.setVisibility(View.VISIBLE);
                }

            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if (item.getItemId() == R.id.logout) {
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(getBaseContext(), Login.class));
                    servicesViewModel.deleteAllOrders();

                }
                return false;
            }
        });


    }

}