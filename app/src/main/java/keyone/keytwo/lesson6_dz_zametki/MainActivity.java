package keyone.keytwo.lesson6_dz_zametki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ZametkiFragment zametkiFragment = ZametkiFragment.newInstance();

        // получаем фрагмент-менедер(жанглер)
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.zametki,ZametkiFragment.newInstance())
                .commit();

        // описание применяем в ландшафтной ориентации
        if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.opisanie_zametki,OpisanieFragment.newInstance())
                    .commit();
}
    }
}