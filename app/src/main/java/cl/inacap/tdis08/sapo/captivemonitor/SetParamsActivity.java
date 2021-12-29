package cl.inacap.tdis08.sapo.captivemonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_params);

        Bundle bundle = getIntent().getExtras();
        String species = bundle.getString("species");

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

        edittext_soil_min_humidity.setText(Integer.toString(p.getSoilHumidity().getMin()));
        edittext_soil_max_humidity.setText(Integer.toString(p.getSoilHumidity().getMax()));
        edittext_soil_min_temp.setText(Integer.toString(p.getSoilTemperature().getMin()));
        edittext_soil_max_temp.setText(Integer.toString(p.getSoilTemperature().getMax()));
        edittext_room_min_humidity.setText(Integer.toString(p.getRoomHumidity().getMin()));
        edittext_room_max_humidity.setText(Integer.toString(p.getRoomHumidity().getMax()));
        edittext_room_min_temp.setText(Integer.toString(p.getRoomTemperature().getMin()));
        edittext_room_max_temp.setText(Integer.toString(p.getRoomTemperature().getMax()));
        edittext_water_min_level.setText(Integer.toString(p.getWaterLevel().getMin()));
        edittext_water_max_level.setText(Integer.toString(p.getWaterLevel().getMax()));
        edittext_water_min_temp.setText(Integer.toString(p.getWaterTemperature().getMin()));
        edittext_water_max_temp.setText(Integer.toString(p.getWaterTemperature().getMax()));


    }


    public void cancelar(View view) {
        Intent intent = new Intent(this, SelectSpeciesActivity.class);
        startActivity(intent);
    }

    public void siguiente(View view) {
        Intent intent = new Intent(this, SetNameIconActivity.class);
        startActivity(intent);
    }
}