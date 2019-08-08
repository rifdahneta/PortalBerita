package uas.rifdah.portalberita.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;
import uas.rifdah.portalberita.DetailActivity;
import uas.rifdah.portalberita.R;
import uas.rifdah.portalberita.model.BeritaItem;

public class BeritaAdapter  extends RecyclerView.Adapter<BeritaAdapter.ViewHolder> {
    Context context;
    List<BeritaItem> beritaItems;
    String urlGambar;


    public BeritaAdapter(Context context, List<BeritaItem> beritaItems) {
        this.context = context;
        this.beritaItems = beritaItems;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        holder.judulBerita.setText(beritaItems.get(position).getJudulBerita());
        holder.penulisBerita.setText(beritaItems.get(position).getPenulis());
        holder.tanggalBerita.setText(beritaItems.get(position).getTanggalPosting());
        urlGambar = "http://192.168.60.31:81/database_portal_berita-master/images/";
        Glide.with(context)
                .load(urlGambar+beritaItems.get(position).getFoto())
                .into(holder.fotoBerita);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BeritaItem berita = beritaItems.get(position);
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("judul", berita.getJudulBerita());
                intent.putExtra("penulis", berita.getPenulis());
                intent.putExtra("tanggal", berita.getTanggalPosting());
                intent.putExtra("gambar",urlGambar + berita.getFoto());
                intent.putExtra("isiBerita",berita.getIsiBerita());
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return beritaItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView judulBerita;
        TextView tanggalBerita;
        TextView penulisBerita;
        ImageView fotoBerita;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            judulBerita = itemView.findViewById(R.id.txtJudul);
            tanggalBerita = itemView.findViewById(R.id.txtTanggal);
            penulisBerita = itemView.findViewById(R.id.txtPenulis);
            fotoBerita = itemView.findViewById(R.id.gambarBerita);


        }
    }
}
