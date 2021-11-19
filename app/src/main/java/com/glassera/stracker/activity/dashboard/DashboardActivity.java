package com.glassera.stracker.activity.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import com.glassera.stracker.activity.login.LoginActivity;
import com.glassera.stracker.data.LoginRepository;
import com.glassera.stracker.service.ServiceLocator;
import com.glassera.stracker.util.Constants;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.glassera.stracker.R;
import com.glassera.stracker.databinding.ActivityDashboardBinding;

public class DashboardActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarDashboard.toolbar);
        /*binding.appBarDashboard.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_bank, R.id.nav_bank_card, R.id.nav_investment, R.id.nav_liability, R.id.nav_payment, R.id.nav_insurance)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_dashboard);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        // New code
        navigationView.setItemIconTintList(null); // To enable colors of drawer icons
        TextView userNameText = navigationView.getHeaderView(0).findViewById(R.id.dashHeaderUsername);
        userNameText.setText(getApplicationContext().getSharedPreferences(Constants.PREFERENCE, MODE_PRIVATE)
                .getString(Constants.USER_DISPLAY_NAME, ""));
        TextView userEmailText = navigationView.getHeaderView(0).findViewById(R.id.dashHeaderUserEmail);
        userEmailText.setText(getApplicationContext().getSharedPreferences(Constants.PREFERENCE, MODE_PRIVATE)
                .getString(Constants.USER_EMAIL, ""));
        TextView userMobileText = navigationView.getHeaderView(0).findViewById(R.id.dashHeaderUserMobile);
        userMobileText.setText(getApplicationContext().getSharedPreferences(Constants.PREFERENCE, MODE_PRIVATE)
                .getString(Constants.USER_MOBILE, ""));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_dashboard);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sign_out:
                ServiceLocator.getStrackerService().logOut();
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}