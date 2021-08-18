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

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

public class SettingsFragmentTwo extends Fragment {

    public static SettingsFragmentTwo newInstance(){
        return new SettingsFragmentTwo();
    }

    //инициализируем кнопки
    RadioButton radioButtonReplace;
    RadioButton radioButtonAdd;
//    Switch switchBackStack;
//    Switch switchBackAsRemove;
//    Switch switchDeleteBeforeAdd;

    // внедряем макет
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings_two, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        radioButtonAdd = v.findViewById(R.id.radioButtonAdd);
        radioButtonReplace = v.findViewById(R.id.radioButtonReplace);
        SwitchCompat switchBackStack = v.findViewById(R.id.switchBackStack);
        SwitchCompat switchBackAsRemove = v.findViewById(R.id.switchBackAsRemove);
        SwitchCompat switchDeleteBeforeAdd = v.findViewById(R.id.switchDeleteBeforeAdd);

        // сохранить последнее состояние
        switchDeleteBeforeAdd.setChecked(Settings.isDeleteFragmentBeforeAdd);
        switchBackAsRemove.setChecked(Settings.isBackIsRemoveFragment);
        switchBackStack.setChecked(Settings.isBackStackUsed);
        switchBackStack.setChecked(Settings.isBackStackUsed);
        radioButtonReplace.setChecked(Settings.isReplaceFragment);
        radioButtonAdd.setChecked(Settings.isAddFragmentUsed);

        radioButtonAdd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.isAddFragmentUsed = isChecked;
                //сохранение
                //вызвали настройки
                writeSettings();
            }
        });

        switchBackStack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.isBackStackUsed = isChecked;
                writeSettings();
            }
        });

        switchBackAsRemove.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.isBackIsRemoveFragment = isChecked;
                writeSettings();
            }
        });

        switchDeleteBeforeAdd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Settings.isDeleteFragmentBeforeAdd = isChecked;
                writeSettings();
            }
        });

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
        // вызываем настойки
        SharedPreferences sharedPreferences = requireActivity()
                .getSharedPreferences(Settings.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        //открываем режим записи
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //записываем по кликуна кнопку
        editor.putBoolean(Settings.IS_ADD_FRAGMENT_USED,Settings.isAddFragmentUsed);
        editor.putBoolean(Settings.IS_REPLACE_FRAGMENT,Settings.isReplaceFragment);
        editor.putBoolean(Settings.IS_BACK_STACK_USED,Settings.isBackStackUsed);
        editor.putBoolean(Settings.IS_BACK_IS_REMOVE_FRAGMENT,Settings.isBackIsRemoveFragment);
        editor.putBoolean(Settings.IS_DELETE_FRAGMENT_BEFORE_ADD,Settings.isDeleteFragmentBeforeAdd);
        editor.apply(); // применяем
    }

}
