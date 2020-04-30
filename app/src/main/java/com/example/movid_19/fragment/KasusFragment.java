package com.example.movid_19.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.movid_19.API.BaseAPiSpinner;
import com.example.movid_19.API.UtilsApi;
import com.example.movid_19.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KasusFragment extends Fragment {

    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.datapositif)
    TextView positif;
    @BindView(R.id.datasembuh)
    TextView sembuh;
    @BindView(R.id.datameninggal)
    TextView meninggal;
    ProgressDialog loading;
    Unbinder unbinder;

    Context mContext;
    BaseAPiSpinner mApiService;

    List<ListBerita> listBeritas = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View view = inflater.inflate(R.layout.fragment_kasus, container, false);
     unbinder = ButterKnife.bind(this, view);
        mContext = getContext();
        mApiService = UtilsApi.getAPISpiner();

        initSpinnerDosen();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedName = parent.getItemAtPosition(position).toString();
               // requestDetail(selectedName);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
     return  view;

    }

    private void initSpinnerDosen() {
        loading = ProgressDialog.show(mContext, null, "harap tunggu...", true, false);

        mApiService.getSemuaBerita().enqueue(new Callback<respon>() {
            @Override
            public void onResponse(Call<respon> call, Response<respon> response) {
                if (response.isSuccessful()) {
                    loading.dismiss();
                    List<ListBerita> listItems = (List<ListBerita>) response.body().getAttribut();
                    List<String> listSpinner = new ArrayList<String>();
                    for (int i = 0; i < listItems.size(); i++) {
                        listSpinner.add(listItems.get(i).getProvinsi());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, listSpinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal mengambil data dosen", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<respon> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
                Log.d("RESPONSE", "message" + t.getMessage());
            }
        });
    }
}
