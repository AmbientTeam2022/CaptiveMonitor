package cl.inacap.tdis08.sapo.captivemonitor;

import static cl.inacap.tdis08.sapo.captivemonitor.util.Presets.Species;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SelectSpeciesActivity extends AppCompatActivity {

    String tankUuid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_species);

        Bundle bundle = getIntent().getExtras();

        tankUuid = bundle.getString("uuid");
        Log.i("uuid", tankUuid);
    }

    public void comenzarSapitos(View view) {
        Intent intent = new Intent(this, SetParamsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("species", Species.FROG.toString());
        bundle.putString("uuid", tankUuid);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void comenzarPersonalizar(View view) {
        Intent intent = new Intent(this, SetParamsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("species", Species.CUSTOM.toString());
        bundle.putString("uuid", tankUuid);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void comenzarPeces(View view) {
        Intent intent = new Intent(this, SetParamsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("species", Species.FISH.toString());
        bundle.putString("uuid", tankUuid);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void comenzarTortugas(View view) {
        Intent intent = new Intent(this, SetParamsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("species", Species.TURTLE.toString());
        bundle.putString("uuid", tankUuid);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void comenzarLagartijas(View view) {
        Intent intent = new Intent(this, SetParamsActivity.class);
        Bundle bundle = getIntent().getExtras();
        bundle.putString("species", Species.TURTLE.toString());
        bundle.putString("uuid", tankUuid);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}