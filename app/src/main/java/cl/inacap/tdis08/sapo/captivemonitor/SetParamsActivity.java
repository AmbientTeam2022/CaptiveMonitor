package cl.inacap.tdis08.sapo.captivemonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import cl.inacap.tdis08.sapo.captivemonitor.model.TankParams;
import cl.inacap.tdis08.sapo.captivemonitor.model.TankPreset;
import cl.inacap.tdis08.sapo.captivemonitor.util.Presets;

public class SetParamsActivity extends AppCompatActivity {
    private EditText edittext_soil_min_humidity;
    private EditText edittext_soil_max_humidity;
    private EditText edittext_soil_min_temp;
    private EditText edittext_soil_max_temp;
    private EditText edittext_room_min_humidity;
    private EditText edittext_room_max_humidity;
    private EditText edittext_room_min_temp;
    private EditText edittext_room_max_temp;
    private EditText edittext_water_min_level;
    private EditText edittext_water_max_level;
    private EditText edittext_water_min_temp;
    private EditText edittext_water_max_temp;

    String tankUuid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_params);

        Bundle bundle = getIntent().getExtras();
        String species = bundle.getString("species");
        tankUuid = bundle.getString("uuid");
        Log.i("uuid", tankUuid);

        TankPreset p = Presets.get(Presets.Species.valueOf(species));

        edittext_soil_min_humidity = (EditText) findViewById(R.id.edittext_soil_min_humidity);
        edittext_soil_max_humidity = (EditText) findViewById(R.id.edittext_soil_max_humidity);
        edittext_soil_min_temp = (EditText) findViewById(R.id.edittext_soil_min_temp);
        edittext_soil_max_temp = (EditText) findViewById(R.id.edittext_soil_max_temp);
        edittext_room_min_humidity = (EditText) findViewById(R.id.edittext_room_min_humidity);
        edittext_room_max_humidity = (EditText) findViewById(R.id.edittext_room_max_humidity);
        edittext_room_min_temp = (EditText) findViewById(R.id.edittext_room_min_temp);
        edittext_room_max_temp = (EditText) findViewById(R.id.edittext_room_max_temp);
        edittext_water_min_level = (EditText) findViewById(R.id.edittext_water_min_level);
        edittext_water_max_level = (EditText) findViewById(R.id.edittext_water_max_level);
        edittext_water_min_temp = (EditText) findViewById(R.id.edittext_water_min_temp);
        edittext_water_max_temp = (EditText) findViewById(R.id.edittext_water_max_temp);

        edittext_soil_min_humidity.setText(Double.toString(p.getSoilHumidity().getMin()));
        edittext_soil_max_humidity.setText(Double.toString(p.getSoilHumidity().getMax()));
        edittext_soil_min_temp.setText(Double.toString(p.getSoilTemperature().getMin()));
        edittext_soil_max_temp.setText(Double.toString(p.getSoilTemperature().getMax()));
        edittext_room_min_humidity.setText(Double.toString(p.getRoomHumidity().getMin()));
        edittext_room_max_humidity.setText(Double.toString(p.getRoomHumidity().getMax()));
        edittext_room_min_temp.setText(Double.toString(p.getRoomTemperature().getMin()));
        edittext_room_max_temp.setText(Double.toString(p.getRoomTemperature().getMax()));
        edittext_water_min_level.setText(Double.toString(p.getWaterLevel().getMin()));
        edittext_water_max_level.setText(Double.toString(p.getWaterLevel().getMax()));
        edittext_water_min_temp.setText(Double.toString(p.getWaterTemperature().getMin()));
        edittext_water_max_temp.setText(Double.toString(p.getWaterTemperature().getMax()));


    }


    public void cancelar(View view) {
        Intent intent = new Intent(this, SelectSpeciesActivity.class);
        startActivity(intent);
    }

    public void siguiente(View view) {
        Intent intent = new Intent(this, SetNameIconActivity.class);

        double soil_min_humidity = Double.parseDouble(edittext_soil_min_humidity.getText().toString());
        double soil_max_humidity = Double.parseDouble(edittext_soil_max_humidity.getText().toString());
        double soil_min_temp = Double.parseDouble(edittext_soil_min_temp.getText().toString());
        double soil_max_temp = Double.parseDouble(edittext_soil_max_temp.getText().toString());
        double room_min_humidity = Double.parseDouble(edittext_room_min_humidity.getText().toString());
        double room_max_humidity = Double.parseDouble(edittext_room_max_humidity.getText().toString());
        double room_min_temp = Double.parseDouble(edittext_room_min_temp.getText().toString());
        double room_max_temp = Double.parseDouble(edittext_room_max_temp.getText().toString());
        double water_min_level = Double.parseDouble(edittext_water_min_level.getText().toString());
        double water_max_level = Double.parseDouble(edittext_water_max_level.getText().toString());
        double water_min_temp = Double.parseDouble(edittext_water_min_temp.getText().toString());
        double water_max_temp = Double.parseDouble(edittext_water_max_temp.getText().toString());

        TankParams tankParams = new TankParams(new TankPreset(new double[][] {
                {soil_min_humidity, soil_max_humidity},
                {soil_min_temp, soil_max_temp},
                {room_min_humidity, room_max_humidity},
                {room_min_temp, room_max_temp},
                {water_min_level, water_max_level},
                {water_min_temp, water_max_temp}
        }));

        Bundle bundle = new Bundle();
        bundle.putSerializable("tankParams", tankParams);
        bundle.putString("uuid", tankUuid);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}