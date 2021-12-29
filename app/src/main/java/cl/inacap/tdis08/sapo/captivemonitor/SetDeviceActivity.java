package cl.inacap.tdis08.sapo.captivemonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SetDeviceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_device);
    }

    public void cancelar(View view) {
        Intent intent = new Intent(this, SetParamsActivity.class);
        startActivity(intent);
    }

    public void siguiente(View view) {
        Intent intent = new Intent(this, SetNameIconActivity.class);
        startActivity(intent);
    }
}