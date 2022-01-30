package com.example.lab5;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PirmasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PirmasFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PirmasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PirmasFragment newInstance(String param1, String param2) {
        PirmasFragment fragment = new PirmasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {

                String resultatas = bundle.getString("bundleKey");

                TextView textview = (TextView) getActivity().findViewById(R.id.textView);
                textview.setText("Antrame fragmente  įvestas tekstas: " + resultatas);

                Log.d("grazintas", "Čia grąžintas rezultatas: " + resultatas);
            }
        });


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pirmas, container, false);

        String item = getArguments().getString("aRaides");

        TextView textview = (TextView) view.findViewById(R.id.textView2);
        textview.setText("Šiame tekste yra " + item + " A arba a simbolių");

        return view;

    }
}