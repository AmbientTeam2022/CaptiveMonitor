package cl.inacap.tdis08.sapo.captivemonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_new_habitat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_new_habitat = (Button)findViewById(R.id.btn_new_habitat);
    }

    public void comenzar(View view) {

        Intent intent = new Intent(this, SetDeviceActivity.class);
        //intent.putExtras(intent);
        startActivity(intent);

    }

    public void comenzar2(View view) {
        Intent intent = new Intent(this, TankListActivity.class);
        startActivity(intent);
    }
}