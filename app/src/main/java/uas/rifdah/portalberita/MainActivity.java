package uas.rifdah.portalberita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uas.rifdah.portalberita.adapter.BeritaAdapter;
import uas.rifdah.portalberita.model.BeritaItem;
import uas.rifdah.portalberita.model.ResponseNews;
import uas.rifdah.portalberita.network.Injection;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewBerita;
    List<BeritaItem> dataBerita;
    BeritaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewBerita = findViewById(R.id.recyclerViewBerita);
        getBerita();
//        adapter = new BeritaAdapter(this, dataBerita);
//        recyclerViewBerita.setLayoutManager(new LinearLayoutManager(this));
//        recyclerViewBerita.setAdapter(adapter);
    }

    private void getBerita() {
        Injection.getService().getAllBerita().enqueue(new Callback<ResponseNews>() {
            @Override
            public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
                if (response.isSuccessful()){
                    dataBerita = response.body().getBerita();
                    adapter = new BeritaAdapter(getApplicationContext(), dataBerita);
                    recyclerViewBerita.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recyclerViewBerita.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseNews> call, Throwable t) {

            }
        });
    }
}
