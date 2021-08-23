package keyone.keytwo.lesson6_dz_zametki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

import java.util.List;


public class  MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initView();
        // для кнопок
        //открыли файл
        readSetting();
        initToolbar();
        initDrawer(initToolbar()); //для nav_header_main.xml


        }

        //указываем новый тулбар
    private Toolbar initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        return toolbar;


    }

    private void initDrawer(Toolbar toolbar) {
       DrawerLayout drawerLayout = findViewById(R.id.draver_layout);

        // связываем 2 меню по клику на бургер выезжает
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,toolbar, R.string.add,R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

// обработка навигационного меню
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    //обработчики нажатий на пункты меню
                    case R.id.action_main:
                        showFragment(SettingsFragment.newInstance());
                        break;
                    case R.id.action_favorite:
                        showFragment(FavoriteFragment.newInstance());
                        break;
                    case R.id.action_settings:
                        showFragment(SettingsFragmentTwo.newInstance());
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    //для тулбара
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            //обработчики нажатий на пункты меню
            case R.id.action_main:
                showFragment(SettingsFragment.newInstance());
                break;
            case R.id.action_favorite:
                showFragment(FavoriteFragment.newInstance());
                break;
            case R.id.action_settings:
                showFragment(SettingsFragmentTwo.newInstance());
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    //определить меню и вызвать
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }



    // для кнопок
    //открыли файл
    private void readSetting() {
        SharedPreferences sharedPreferences = getSharedPreferences(Settings.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        Settings.isDeleteFragmentBeforeAdd = sharedPreferences.getBoolean(Settings.IS_DELETE_FRAGMENT_BEFORE_ADD, false);
        Settings.isBackIsRemoveFragment = sharedPreferences.getBoolean(Settings.IS_BACK_IS_REMOVE_FRAGMENT, false);
        Settings.isBackStackUsed = sharedPreferences.getBoolean(Settings.IS_BACK_STACK_USED, false);
        Settings.isReplaceFragment = sharedPreferences.getBoolean(Settings.IS_REPLACE_FRAGMENT, false);
        Settings.isAddFragmentUsed = sharedPreferences.getBoolean(Settings.IS_ADD_FRAGMENT_USED, false);
    }

    // для кнопок меню
    private void initView() {
        Button buttonBack = findViewById(R.id.buttonBack);
        Button buttonFavorite = findViewById(R.id.buttonFavorite);
        Button buttonSetting = findViewById(R.id.buttonSetting);
        Button buttonMain = findViewById(R.id.buttonMain);

        //клик
        buttonBack.setOnClickListener(this);
        buttonFavorite.setOnClickListener(this);
        buttonSetting.setOnClickListener(this);
        buttonMain.setOnClickListener(this);




    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonBack:
                FragmentManager fragmentManager = getSupportFragmentManager();
                if (Settings.isBackIsRemoveFragment) {
                    Fragment fragmentForDelete = getVisibleFragment(fragmentManager);
                    if (fragmentForDelete != null) {
                        fragmentManager.beginTransaction().remove(fragmentForDelete).commit();
                    }
                }else {
                    fragmentManager.popBackStack();
                }
                break;

            case R.id.buttonMain:

                showFragment(SettingsFragment.newInstance());
                break;

            case R.id.buttonFavorite:
                showFragment(FavoriteFragment.newInstance());
                break;

            case R.id.buttonSetting:
                showFragment(SettingsFragmentTwo.newInstance());
                break;

        }


    }

    Fragment getVisibleFragment(FragmentManager fragmentManager){
        List<Fragment> flist = fragmentManager.getFragments();
        for (int i=0; i<flist.size();i++) {
            Fragment fragment = flist.get(i);
            if(fragment.isVisible()){
                return fragment;
            }
        }
        return null;
    }

    void showFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        if (Settings.isDeleteFragmentBeforeAdd) {
            Fragment fragmentForDelete = getVisibleFragment(fragmentManager);
            if (fragmentForDelete != null) {
                fragmentTransaction.remove(fragmentForDelete);
            }
        }
        if (Settings.isAddFragmentUsed) {
            fragmentTransaction
                    .add(R.id.fragment_container, fragment);
        }else if (Settings.isReplaceFragment)  {
            fragmentTransaction
                    .replace(R.id.fragment_container, fragment);

        }
        if(Settings.isBackStackUsed) {
            fragmentTransaction.addToBackStack("");
        }
        fragmentTransaction.commit();

        }
    }
