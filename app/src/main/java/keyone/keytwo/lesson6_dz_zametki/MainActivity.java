package keyone.keytwo.lesson6_dz_zametki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ZametkiFragment zametkiFragment = ZametkiFragment.newInstance();
    }
}