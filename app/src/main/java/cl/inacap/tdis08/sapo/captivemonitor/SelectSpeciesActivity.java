package cl.inacap.tdis08.sapo.captivemonitor;

import static cl.inacap.tdis08.sapo.captivemonitor.util.Presets.Species;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SelectSpeciesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_species);
    }

    public void comenzarSapitos(View view) {
        Intent intent = new Intent(this, MonitorActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("species", Species.FROG.toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void comenzarPersonalizar(View view) {
        Intent intent = new Intent(this, SetParamsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("species", Species.CUSTOM.toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void comenzarPeces(View view) {
        Intent intent = new Intent(this, SetParamsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("species", Species.FISH.toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void comenzarTortugas(View view) {
        Intent intent = new Intent(this, SetParamsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("species", Species.TURTLE.toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void comenzarLagartijas(View view) {
        Intent intent = new Intent(this, SetParamsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("species", Species.TURTLE.toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}