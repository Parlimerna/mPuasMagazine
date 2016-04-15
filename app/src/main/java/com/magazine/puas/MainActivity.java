package com.magazine.puas;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.magazine.puas.features.magazine.MagazineActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private CoordinatorLayout     mCoordinatorLayout;
    private DrawerLayout          mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (null != getSupportActionBar()) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Champagne&Limousine-Bold.ttf");
            ((TextView) findViewById(R.id.toolbar_title)).setTypeface(tf);
        }

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);


        NavigationView mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(this);
        disableNavigationViewScrollbars(mNavigationView);

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
    }

    private void disableNavigationViewScrollbars(NavigationView navigationView) {
        if (navigationView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
            if (navigationMenuView != null) {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.menu_item_news_info:
                Snackbar.make(mCoordinatorLayout, item.getTitle() + " pressed", Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.menu_item_magazine:
                Snackbar.make(mCoordinatorLayout, item.getTitle() + " pressed", Snackbar.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, MagazineActivity.class));
                break;

            case R.id.menu_item_food:
                Snackbar.make(mCoordinatorLayout, item.getTitle() + " pressed", Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.menu_item_culiner:
                Snackbar.make(mCoordinatorLayout, item.getTitle() + " pressed", Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.menu_item_place:
                Snackbar.make(mCoordinatorLayout, item.getTitle() + " pressed", Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.menu_item_setting:
                Snackbar.make(mCoordinatorLayout, item.getTitle() + " pressed", Snackbar.LENGTH_SHORT).show();
                break;

            case R.id.menu_item_help:
                Snackbar.make(mCoordinatorLayout, item.getTitle() + " pressed", Snackbar.LENGTH_SHORT).show();
                break;
        }

        mDrawerLayout.closeDrawers();
        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        } else if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
