package uas.rifdah.portalberita.network;

import retrofit2.Call;
import retrofit2.http.GET;
import uas.rifdah.portalberita.model.ResponseNews;

public interface NewsService {

    @GET("tampil_berita.php")
    Call<ResponseNews> getAllBerita();


}
