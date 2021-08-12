package keyone.keytwo.lesson6_dz_zametki;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;

import androidx.fragment.app.Fragment;

public class SettingsFragmentTwo extends Fragment {

    public static SettingsFragmentTwo newInstance(){
        return new SettingsFragmentTwo();
    }

    //инициализируем кнопки
    RadioButton radioButtonReplace;
    RadioButton radioButtonAdd;
    Switch switchBackStack;
    Switch switchBackAsRemove;
    Switch switchDeleteBeforeAdd;

    // внедряем макет
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings_two, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        radioButtonAdd = v.findViewById(R.id.radioButtonAdd);
        radioButtonAdd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.isAddFragmentUsed = isChecked;

                //сохранение

                //вызвали настройки
                writeSettings();
            }
        });

        radioButtonReplace = v.findViewById(R.id.radioButtonReplace);
        radioButtonAdd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.isReplaceFragment = isChecked;
                //сохранение
                //вызвали настройки
                writeSettings();
            }
        });
    }
    private void writeSettings() {
        SharedPreferences sharedPreferences = requireActivity()
                .getSharedPreferences(Settings.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        //открываем режим записи
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //записываем по кликуна кнопку
        editor.putBoolean(Settings.IS_ADD_FRAGMENT_USED,Settings.isAddFragmentUsed);
        editor.putBoolean(Settings.IS_REPLACE_FRAGMENT,Settings.isReplaceFragment);
        editor.apply(); // применяем
    }

}
