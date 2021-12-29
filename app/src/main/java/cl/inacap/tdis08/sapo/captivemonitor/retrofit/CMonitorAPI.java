package cl.inacap.tdis08.sapo.captivemonitor.retrofit;

import java.util.ArrayList;

import cl.inacap.tdis08.sapo.captivemonitor.model.Tank;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CMonitorAPI {

    @GET("/api/list")
    Call<ArrayList<Tank>> listTanks();

}
