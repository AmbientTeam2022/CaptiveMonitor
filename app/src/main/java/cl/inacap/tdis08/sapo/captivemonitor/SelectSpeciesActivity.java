package cl.inacap.tdis08.sapo.captivemonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectSpeciesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_species);
    }


    public void comenzarSapitos(View view) {
        Intent intent = new Intent(this, MonitorActivity.class);
        startActivity(intent);
    }

    public void comenzarPersonalizar(View view) {
        Intent intent = new Intent(this, SetParamsActivity.class);
        startActivity(intent);
    }
}