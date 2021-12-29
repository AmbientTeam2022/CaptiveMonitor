package cl.inacap.tdis08.sapo.captivemonitor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalTime;

import cl.inacap.tdis08.sapo.captivemonitor.model.Tank;
import cl.inacap.tdis08.sapo.captivemonitor.model.TankParams;
import cl.inacap.tdis08.sapo.captivemonitor.model.TankState;
import cl.inacap.tdis08.sapo.captivemonitor.retrofit.APIClient;
import cl.inacap.tdis08.sapo.captivemonitor.retrofit.CMonitorAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MonitorActivity extends AppCompatActivity {

    private CountDownTimer timer;
    private boolean paramsLoaded = false;
    private TankParams tankParams;

    private TextView textSoilCurrentHumidity;
    private TextView textSoilCurrentTemp;
    private TextView textRoomCurrentHumidity;
    private TextView textRoomCurrentTemp;
    private TextView textWaterCurrentLevel;
    private TextView textWaterCurrentTemp;

    private TextView textSoilMinHumidity;
    private TextView textSoilMaxHumidity;
    private TextView textSoilMinTemp;
    private TextView textSoilMaxTemp;
    private TextView textRoomMinHumidity;
    private TextView textRoomMaxHumidity;
    private TextView textRoomMinTemp;
    private TextView textRoomMaxTemp;
    private TextView textWaterMinLevel;
    private TextView textWaterMaxLevel;
    private TextView textWaterMinTemp;
    private TextView textWaterMaxTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.monitor_title);

        textSoilCurrentHumidity = (TextView) findViewById(R.id.text_soil_current_humidity);
        textSoilCurrentTemp     = (TextView) findViewById(R.id.text_soil_current_temp);
        textRoomCurrentHumidity = (TextView) findViewById(R.id.text_room_current_humidity);
        textRoomCurrentTemp     = (TextView) findViewById(R.id.text_room_current_temp);
        textWaterCurrentLevel   = (TextView) findViewById(R.id.text_water_current_level);
        textWaterCurrentTemp    = (TextView) findViewById(R.id.text_water_current_temp);

        textSoilMinHumidity = (TextView) findViewById(R.id.text_soil_max_humidity);
        textSoilMinHumidity = (TextView) findViewById(R.id.text_soil_min_humidity);
        textSoilMaxHumidity = (TextView) findViewById(R.id.text_soil_max_humidity);
        textSoilMinTemp     = (TextView) findViewById(R.id.text_soil_min_temp);
        textSoilMaxTemp     = (TextView) findViewById(R.id.text_soil_max_temp);
        textRoomMinHumidity = (TextView) findViewById(R.id.text_room_min_humidity);
        textRoomMaxHumidity = (TextView) findViewById(R.id.text_room_max_humidity);
        textRoomMinTemp     = (TextView) findViewById(R.id.text_room_min_temp);
        textRoomMaxTemp     = (TextView) findViewById(R.id.text_room_max_temp);
        textWaterMinLevel   = (TextView) findViewById(R.id.text_water_min_level);
        textWaterMaxLevel   = (TextView) findViewById(R.id.text_water_max_level);
        textWaterMinTemp    = (TextView) findViewById(R.id.text_water_min_temp);
        textWaterMaxTemp    = (TextView) findViewById(R.id.text_water_max_temp);

        Bundle bundle = getIntent().getExtras();
        String uuid = bundle.getString("uuid");

        CMonitorAPI service = APIClient.getClient().create(CMonitorAPI.class);

        timer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {

                Call<Tank> call = service.getTank(uuid);

                call.enqueue(new Callback<Tank>() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onResponse(Call<Tank> call, Response<Tank> response) {
                        Tank tank = response.body();
                        TankState state = tank.getState();

                        // Si el dispositivo aún no ha enviado los primeros datos
                        if (state == null) {
                            Toast.makeText(getApplicationContext(),
                                    "Esperando datos...",
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }

                        textSoilCurrentHumidity.setText(Integer.toString(state.getSoilHumidity()));
                        textSoilCurrentTemp.setText(Integer.toString(state.getSoilTemperature()));
                        textRoomCurrentHumidity.setText(Integer.toString(state.getRoomHumidity()));
                        textRoomCurrentTemp.setText(Integer.toString(state.getRoomTemperature()));
                        textWaterCurrentLevel.setText(Integer.toString(state.getWaterLevel()));
                        textWaterCurrentTemp.setText(Integer.toString(state.getWaterTemperature()));
                        Log.i("INFO", "Actualización: " + LocalTime.now());

                        if (!paramsLoaded) {
                            tankParams = tank.getParams();
                            textSoilMinHumidity.setText(Integer.toString(tankParams.getSoilHumidity().getMin()));
                            textSoilMaxHumidity.setText(Integer.toString(tankParams.getSoilHumidity().getMax()));
                            textSoilMinTemp.setText(Integer.toString(tankParams.getSoilTemperature().getMin()));
                            textSoilMaxTemp.setText(Integer.toString(tankParams.getSoilTemperature().getMax()));
                            textRoomMinHumidity.setText(Integer.toString(tankParams.getRoomHumidity().getMin()));
                            textRoomMaxHumidity.setText(Integer.toString(tankParams.getRoomHumidity().getMax()));
                            textRoomMinTemp.setText(Integer.toString(tankParams.getRoomTemperature().getMin()));
                            textRoomMaxTemp.setText(Integer.toString(tankParams.getRoomTemperature().getMax()));
                            textWaterMinLevel.setText(Integer.toString(tankParams.getWaterLevel().getMin()));
                            textWaterMaxLevel.setText(Integer.toString(tankParams.getWaterLevel().getMax()));
                            textWaterMinTemp.setText(Integer.toString(tankParams.getWaterTemperature().getMin()));
                            textWaterMaxTemp.setText(Integer.toString(tankParams.getWaterTemperature().getMax()));
                            paramsLoaded = true;
                        }

                    }

                    @Override
                    public void onFailure(Call<Tank> call, Throwable t) {
                        Log.e("Monitor", "ERROR", t);
                    }
                });
                restartTimer();

            }
        };

        timer.onFinish();

    }

    private void restartTimer() {
        timer.start();
    }
}