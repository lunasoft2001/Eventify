package la.oja.eventify;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.backendless.Backendless;


public class SplashActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        String appVersion = "v1";
        Backendless.initApp( this, "024845E1-A65E-AEB7-FFD3-F29C758DFB00", "190B66F3-4243-34F9-FF37-598F5C436F00", appVersion );

        Runnable ejecutable = new Runnable() {
            @Override
            public void run() {
                siguienteActividad();
                finish();
            }
        };

        Handler miHandler = new Handler();
        miHandler.postDelayed(ejecutable,1500);

    }

    public  void siguienteActividad(){
        Intent intento = new Intent(this,MainActivity.class);
        startActivity(intento);
    }
}
