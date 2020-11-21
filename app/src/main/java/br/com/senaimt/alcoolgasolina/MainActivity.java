package br.com.senaimt.alcoolgasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtValorAlcool;
    TextView txtValorGasolina;
    Button btnVerificar;
    String menssagem;
    TextView txtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //declarando os componentes
        txtValorAlcool = findViewById(R.id.txtValorAlcool);
        txtValorGasolina = findViewById(R.id.txtValorGasolina);
        btnVerificar = findViewById(R.id.btnVerificar);
        txtResultado = findViewById(R.id.txtResultado);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    //recebe os valores da tela
                    String valorAlcool = txtValorAlcool.getText().toString().replace(",",".");
                    String valorGasolina = txtValorGasolina.getText().toString().replace(",",".");
                    //convertendo
                    float converteAlcool = Float.parseFloat(valorAlcool);
                    float convertGasolina = Float.parseFloat(valorGasolina);
                    //regras de negocio

                    float resultado = converteAlcool/convertGasolina;
                    if(resultado  < 0.7){
                        menssagem = "É melhor abastacer com Álcool";
                    }else {

                        menssagem = "É melhor abastacer com Gasolina";
                    }
                    //exibe na tela o resultado
                    txtResultado.setText(menssagem);
                    txtResultado.setVisibility(View.VISIBLE);
                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Valor incorreeto", Toast.LENGTH_LONG );

                }
            }
        });

    }
}