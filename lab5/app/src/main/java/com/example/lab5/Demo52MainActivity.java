package com.example.lab5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.lab5.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class Demo52MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    DrawerLayout drawerLayout;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo52_main);
        drawerLayout=findViewById(R.id.drawer_layout_52);
        NavigationView navigationView=findViewById(R.id.navigation_view_52);
        viewPager=findViewById(R.id.demo53_viewPager);
        tabLayout=findViewById(R.id.demo53_tabLayout);
        addTabLayout(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.demo51_menu_item1){
                    viewPager.setCurrentItem(0);
                    closeDrawer();
                    return true;
                }
                else if(item.getItemId()==R.id.demo51_menu_item2){
                    viewPager.setCurrentItem(1);
                    closeDrawer();
                    return true;
                }
                else if(item.getItemId()==R.id.demo51_menu_item3){
                    viewPager.setCurrentItem(2);
                    closeDrawer();
                    return true;
                }
                return false;
            }
        });
    }
    private void closeDrawer(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public void addTabLayout(ViewPager viewPager){
        //tao moi adapter
        Demo53Adapter adapter=new
                Demo53Adapter(getSupportFragmentManager());
        //them fragment vao adapter
        adapter.addFrag(new BlankFragment1(),"ONE");
        adapter.addFrag(new BlankFragment2(),"TWO");
        adapter.addFrag(new BlankFragment3(),"THREE");
        //
        viewPager.setAdapter(adapter);
    }
}