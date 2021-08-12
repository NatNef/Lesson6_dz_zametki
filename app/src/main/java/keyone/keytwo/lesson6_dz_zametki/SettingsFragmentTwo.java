package keyone.keytwo.lesson6_dz_zametki;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class SettingsFragmentTwo extends Fragment {

    public static SettingsFragmentTwo newInstance(){
        return new SettingsFragmentTwo();
    }

    // внедряем макет
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_setting, container, false);
        return v;
    }
}
