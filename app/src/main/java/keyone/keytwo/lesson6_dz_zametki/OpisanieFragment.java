package keyone.keytwo.lesson6_dz_zametki;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OpisanieFragment extends Fragment {

    public static OpisanieFragment newInstance(){
        return new OpisanieFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opisanie,container, false);

        return view;
    }
}
