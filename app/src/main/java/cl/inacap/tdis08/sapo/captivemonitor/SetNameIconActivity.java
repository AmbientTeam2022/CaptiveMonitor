package cl.inacap.tdis08.sapo.captivemonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cl.inacap.tdis08.sapo.captivemonitor.model.Tank;
import cl.inacap.tdis08.sapo.captivemonitor.model.TankParams;
import cl.inacap.tdis08.sapo.captivemonitor.retrofit.APIClient;
import cl.inacap.tdis08.sapo.captivemonitor.retrofit.CMonitorAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SetNameIconActivity extends AppCompatActivity {

    TankParams tankParams;
    String tankUuid;

    Button buttonSave;
    TextView textCountdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_name_icon);

        Bundle bundle = getIntent().getExtras();
        tankParams    = (TankParams) bundle.getSerializable("tankParams");
        tankUuid      = bundle.getString("uuid");
        Log.i("uuid", tankUuid);

        buttonSave = findViewById(R.id.btn_setname_save);
        textCountdown = findViewById(R.id.text_countdown_save);
    }

    public void guardar(View view) {
        EditText textName = (EditText) findViewById(R.id.edittext_tank_name);
        String tankName = textName.getText().toString();
        int tankIcon = 0;

        Tank newTank = new Tank(tankUuid, tankName, tankIcon, tankParams);

        CMonitorAPI servicio = APIClient.getClient().create(CMonitorAPI.class);
        Call<Tank> call = servicio.createTank(newTank);

        call.enqueue(new Callback<Tank>() {
            @Override
            public void onResponse(Call<Tank> call, Response<Tank> response) {
                buttonSave.setEnabled(false);
                Toast.makeText(getApplicationContext(),
                        "Ambiente creado.\nEspere un momento.",
                        Toast.LENGTH_LONG).show();

                CountDownTimer timer = new CountDownTimer(5000, 1000) {
                    @Override
                    public void onTick(long remaining) {
                        textCountdown.setText(Integer.toString(Math.round(remaining / 1000)));
                    }

                    @Override
                    public void onFinish() {
                        Intent intent = new Intent(getApplicationContext(), TankListActivity.class);
                        startActivity(intent);
                    }
                }.start();
            }

            @Override
            public void onFailure(Call<Tank> call, Throwable t) {
                Toast.makeText(getApplicationContext(),
                        "Error al guardar",
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    public void cancelar(View view) {
        Intent intent = new Intent(this, SetParamsActivity.class);
        startActivity(intent);
    }
}