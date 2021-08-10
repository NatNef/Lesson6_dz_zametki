package keyone.keytwo.lesson6_dz_zametki;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.Serializable;

public class OpisanieFragment extends Fragment {

    public static String ARG_MENU = "menu";
    private Menu menu;


    public static OpisanieFragment newInstance(Menu menu) {
        OpisanieFragment fragment = new OpisanieFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_MENU, menu);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opisanie, container, false);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(this.menu.getName());

        TypedArray typedArray = getResources().obtainTypedArray(R.array.opisanie_imgs);
        imageView.setImageResource(typedArray.getResourceId(this.menu.getImageIndex(), -1));
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.menu = getArguments().getParcelable(ARG_MENU);
        }


    }
}
