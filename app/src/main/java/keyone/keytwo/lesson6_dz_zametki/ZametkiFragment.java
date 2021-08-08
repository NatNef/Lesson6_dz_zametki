package keyone.keytwo.lesson6_dz_zametki;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ZametkiFragment extends Fragment {

    // создаем экземпляры через фабричный метод
    // создание фрагмента в одном месте, для удобства поменять
    public static ZametkiFragment newInstance(){
        return new ZametkiFragment();
    }

    // у фрагмента есть макет, задаем его , метод onCreateView

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
        // переопределим его
    }
}
