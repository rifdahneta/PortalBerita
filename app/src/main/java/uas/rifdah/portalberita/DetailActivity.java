package uas.rifdah.portalberita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import uas.rifdah.portalberita.adapter.BeritaAdapter;
import uas.rifdah.portalberita.model.BeritaItem;

public class DetailActivity extends AppCompatActivity {
    TextView detailJudul;
    TextView detailPenulis;
    TextView detailTanggal;
    ImageView detailGambar;
    List<BeritaItem> beritaItems;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initData();
        tampilBerita();

    }

    private void tampilBerita() {
        Intent intent = getIntent();
        String dJudul = intent.getStringExtra("judul");
        String dPenulis = intent.getStringExtra("penulis");
        String dTanggal = intent.getStringExtra("tanggal");
        String dgambar = intent.getStringExtra("gambar");
        detailJudul.setText(dJudul);
        detailTanggal.setText(dTanggal);
        detailPenulis.setText(dPenulis);
        Glide.with(this)
                .load(dgambar)
                .into(detailGambar);

        webView = findViewById(R.id.newsContentDetail);
        String isi_berita   = intent.getStringExtra("isiBerita");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(isi_berita, "text/html; charset=utf-8", "UTF-8");

    }


    private void initData() {
        detailJudul = findViewById(R.id.txtJudulDetail);
        detailPenulis = findViewById(R.id.txtPenulisDetail);
        detailGambar = findViewById(R.id.gambarBeritaDetail);
        detailTanggal = findViewById(R.id.txtTanggalDetail);

    }
}
