package keyone.keytwo.lesson6_dz_zametki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class  MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        // для кнопок
        //открыли файл
        SharedPreferences sharedPreferences = getSharedPreferences(Settings.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        Settings.isDeleteFragmentBeforeAdd = sharedPreferences.getBoolean(Settings.IS_DELETE_FRAGMENT_BEFORE_ADD, false);
        Settings.isBackIsRemoveFragment = sharedPreferences.getBoolean(Settings.IS_BACK_IS_REMOVE_FRAGMENT, false);
        Settings.isBackStackUsed = sharedPreferences.getBoolean(Settings.IS_BACK_STACK_USED, false);
        Settings.isReplaceFragment = sharedPreferences.getBoolean(Settings.IS_REPLACE_FRAGMENT, false);
        Settings.isAddFragmentUsed = sharedPreferences.getBoolean(Settings.IS_ADD_FRAGMENT_USED, false);


//        ZametkiFragment zametkiFragment = ZametkiFragment.newInstance();

        // получаем фрагмент-менедер(жанглер)
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.zametki_container, ZametkiFragment.newInstance())
                .commit();

        // описание применяем в ландшафтной ориентации
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.opisanie_zametki_container, OpisanieFragment.newInstance(new Menu(0, "test")))
                    .commit();
        }
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
                break;

            case R.id.buttonMain:

                showFragment(SettingsFragment.newInstance());
                break;

            case R.id.buttonFavorite:
                showFragment(SettingsFragmentTwo.newInstance());
                break;

            case R.id.buttonSetting:
                showFragment(FavoriteFragment.newInstance());
                break;

        }

    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}