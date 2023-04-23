package devandroid.paulo.appcoordenadasgps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtValorLatitude, txtValorLongitude;
    double latitude, longitude;
    boolean gpsAtivo = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValorLatitude = findViewById(R.id.txtValorLatitude);
        txtValorLongitude = findViewById(R.id.txtValorLongitude);

        if (gpsAtivo) {

            obterCoordenadas();

        } else {
            latitude = 0.00;
            longitude = 0.00;

            txtValorLatitude.setText(String.valueOf(latitude));
            txtValorLongitude.setText(String.valueOf(longitude));

            Toast.makeText(this, "Coordenadas não disponíveis.", Toast.LENGTH_LONG).show();
        }
    }

    private void obterCoordenadas(){

        boolean permissaoAtiva = true;

        if (permissaoAtiva) {
            capturarUltimaLocalizacaoValida();
        } else {
            solicitarPermissaoParaObterLocalizacao();
        }


    }

    private void solicitarPermissaoParaObterLocalizacao() {

        Toast.makeText(this, "Aplicação não tem permissão de localização...", Toast.LENGTH_LONG).show();
    }

    private void capturarUltimaLocalizacaoValida() {

        latitude = 1.98;
        longitude = -1.67;

        txtValorLatitude.setText(String.valueOf(latitude));
        txtValorLongitude.setText(String.valueOf(longitude));
    }
}