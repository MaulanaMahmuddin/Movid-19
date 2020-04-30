package com.example.movid_19.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.movid_19.R;
import com.example.movid_19.self_check;
import com.example.movid_19.web_mencegah;
import com.example.movid_19.web_mengantisipasi;
import com.example.movid_19.web_mengenal;
import com.example.movid_19.web_mengobati;

import java.util.zip.Inflater;

public class InfoFragment extends Fragment implements View.OnClickListener {

    private LinearLayout web1,web2,web3,web4;
    private Button cek;
    View v;

    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v =  inflater.inflate(R.layout.fragment_info,container,false);


        cek = (Button) v.findViewById(R.id.checkk);
        cek.setOnClickListener(this);

        web1 = (LinearLayout) v.findViewById(R.id.mencegah);
        web1.setOnClickListener(this);

        web2 = (LinearLayout) v.findViewById(R.id.mengenal);
        web2.setOnClickListener(this);

        web3 = (LinearLayout) v.findViewById(R.id.mengobati);
        web3.setOnClickListener(this);

        web4 = (LinearLayout) v.findViewById(R.id.mengantisipasi);
        web4.setOnClickListener(this);


        return v;


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.checkk:
                Intent moveIntent5 = new Intent(getActivity(), self_check.class);
                startActivity(moveIntent5);
                break;

            case R.id.mencegah:
                Intent moveIntent = new Intent(getActivity(), web_mencegah.class);
                startActivity(moveIntent);
                break;

            case R.id.mengenal:
                Intent moveIntent1 = new Intent(getActivity(), web_mengenal.class);
                startActivity(moveIntent1);
                break;

            case R.id.mengobati:
                Intent moveIntent2 = new Intent(getActivity(), web_mengobati.class);
                startActivity(moveIntent2);
                break;

            case R.id.mengantisipasi:
                Intent moveIntent3 = new Intent(getActivity(), web_mengantisipasi.class);
                startActivity(moveIntent3);
                break;
        }

    }
}
