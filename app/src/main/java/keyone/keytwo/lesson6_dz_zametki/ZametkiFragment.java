package keyone.keytwo.lesson6_dz_zametki;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.Serializable;

public class ZametkiFragment extends Fragment {

    Menu currentMenu;
    boolean isLandScape;

    public static ZametkiFragment newInstance() {
        return new ZametkiFragment();
}

    // у фрагмента есть макет, задаем его , метод onCreateView

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // переопределим его. В контейнер МэйнАктивити
        //inflater впихивает в активити контейнер с макетом (макет пустой)
        View view = inflater.inflate(R.layout.fragment_zametki, container,false);
        // выводим список (заполняем пустой макет)
        LinearLayout linearLayout = (LinearLayout) view;
        String[] menu_zametki = getResources().getStringArray(R.array.menu_zametki);

        for (int i =0;i<menu_zametki.length; i++){
            String name = menu_zametki[i];
            TextView textView = new TextView(getContext());
            textView.setText(name);
            textView.setTextSize(30);
            linearLayout.addView(textView);
            int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentMenu = new Menu(finalI,
                            (getResources().getStringArray(R.array.menu_zametki)[finalI]));
                    // для ландшафтной
                    isLandScape = (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE);
                    showOpisanieZametki();
                }

                private void showOpisanieZametki() {
                    if(isLandScape){
                        showOpisanieZametkiLand();
                    }else { // portret
                        showOpisanieZametkiPort();
                    }
                }

                private void showOpisanieZametkiPort() {
                    requireActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.zametki_container, OpisanieFragment.newInstance(currentMenu))
                            .addToBackStack("") // обязательно вкл назад
                            .commit();
                }

                private void showOpisanieZametkiLand() {
                    requireActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.opisanie_zametki_container, OpisanieFragment.newInstance(currentMenu))
                            .commit();
                }
            });
        }
        return view;
    }

}
