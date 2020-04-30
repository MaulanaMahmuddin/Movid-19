package com.example.movid_19.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.movid_19.R;
import com.example.movid_19.tentang;

public class BantuanFragment extends Fragment implements View.OnClickListener {

    private LinearLayout dial,tentang;
    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_bantuan,container,false);

        dial = (LinearLayout) v.findViewById(R.id.hotline);
        dial.setOnClickListener(this);

        tentang = (LinearLayout) v.findViewById(R.id.tentang1);
        tentang.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.hotline:
                String phoneNumber = "119";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;

            case R.id.tentang1:
                Intent moveIntent = new Intent(getActivity(), tentang.class);
                startActivity(moveIntent);
                break;
        }

    }
}
