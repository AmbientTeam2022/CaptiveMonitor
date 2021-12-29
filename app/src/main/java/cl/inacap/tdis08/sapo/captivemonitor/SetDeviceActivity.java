package cl.inacap.tdis08.sapo.captivemonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SetDeviceActivity extends AppCompatActivity {

    private EditText textUuid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_device);

        textUuid = (EditText) findViewById(R.id.edittext_new_uuid);
    }

    public void cancelar(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void siguiente(View view) {
        Intent intent = new Intent(this, SelectSpeciesActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("uuid", textUuid.getText().toString());
        Log.i("uuid", textUuid.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }

}

