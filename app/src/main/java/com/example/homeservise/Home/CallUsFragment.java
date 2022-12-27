package com.example.homeservise.Home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homeservise.R;


public class CallUsFragment extends Fragment {

    public CallUsFragment() {
        // Required empty public constructor
    }

/*--------------->here we dont need to open layout,
                  so we're applying the code on (on attach) method<---------------*/

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        /*--------------->intent to go to whatsapp at specific chat/number <---------------*/
        Intent sendIntent = new Intent();
                    String  number= "+201150191031";
                    startActivity(
                            new Intent(Intent.ACTION_VIEW,
                                    Uri.parse(
                                            String.format("https://api.whatsapp.com/send?phone=%s&text=%s", number, " ")
                                    )
                            )
                    );
        getActivity().getSupportFragmentManager().popBackStack();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        /*--------------->here we bind root to null asa we dont need root <---------------*/
        return inflater.inflate(R.layout.fragment_call_us, null, false);
    }
}