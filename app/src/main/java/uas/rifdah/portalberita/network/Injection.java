package uas.rifdah.portalberita.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injection {

    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("http://192.168.60.31:81/database_portal_berita-master/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NewsService getService(){
        return getRetrofit().create(NewsService.class);
    }

}
