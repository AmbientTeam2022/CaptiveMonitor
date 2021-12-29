package cl.inacap.tdis08.sapo.captivemonitor.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://104.131.186.247:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;

    }

}
