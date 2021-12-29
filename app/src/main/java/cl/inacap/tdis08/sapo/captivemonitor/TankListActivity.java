package cl.inacap.tdis08.sapo.captivemonitor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.stream.Collectors;

import cl.inacap.tdis08.sapo.captivemonitor.adapter.TankListAdapter;
import cl.inacap.tdis08.sapo.captivemonitor.model.Tank;
import cl.inacap.tdis08.sapo.captivemonitor.retrofit.APIClient;
import cl.inacap.tdis08.sapo.captivemonitor.retrofit.CMonitorAPI;
import cl.inacap.tdis08.sapo.captivemonitor.util.Presets;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TankListActivity extends AppCompatActivity {

    private ArrayList<Tank> tankData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tank_list);

        getSupportActionBar().setTitle(R.string.room_list_text);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CMonitorAPI servicio = APIClient.getClient().create(CMonitorAPI.class);
        Call<ArrayList<Tank>> call = servicio.listTanks();

        call.enqueue(new Callback<ArrayList<Tank>>() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<ArrayList<Tank>> call, Response<ArrayList<Tank>> response) {
                String responseText = response.body().stream().map(Object::toString).collect(Collectors.joining(", "));
                Log.i("Respuesta", responseText);

                setTankData(response.body());
                renderData();
            }

            @Override
            public void onFailure(Call<ArrayList<Tank>> call, Throwable t) {
                Log.w("ERROR", t);
            }
        });

    }

    private void setTankData(ArrayList<Tank> tankData) {
        this.tankData = tankData;
    }

    private void renderData() {
        TankListAdapter adapter = new TankListAdapter(this, tankData);
        ListView listView = findViewById(R.id.listview_tanks);
        listView.setAdapter(adapter);

        adapter.setOnEditButtonListener((position) -> {
            // hacer cosas
        });

        adapter.setOnDeleteButtonListener((position) -> {
            // hacer cosas
        });

        adapter.setOnViewButtonListener(new TankListAdapter.ViewListener() {
            @Override
            public void onViewButtonListener(int position) {
                Intent intent = new Intent(getApplicationContext(), MonitorActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("uuid", tankData.get(position).getUuid());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}