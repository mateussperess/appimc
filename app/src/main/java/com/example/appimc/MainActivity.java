package com.example.appimc;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public EditText etWeight;
    public EditText etHeight;
    public TextView txtResult;
    public Button btnResult;
    public ImageView imgResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        txtResult = findViewById(R.id.txtResult);
        imgResult = findViewById(R.id.imgResult);
        btnResult = findViewById(R.id.btnResult);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TESTE", "Botao clicado!");
                float weight = Float.parseFloat(etWeight.getText().toString());
                float height = Float.parseFloat(etHeight.getText().toString());
                float result = weight / (height * height);

                if(result < 18.5) {
                    Log.d("CALCULO", "Abaixo do peso");
                    imgResult.setImageResource(R.drawable.abaixo_peso);
                } else if (result >= 18.5 && result < 25) {
                    Log.d("CALCULO", "Peso normal");
                    imgResult.setImageResource(R.drawable.peso_normal);
                } else if (result >= 25 && result < 30) {
                    Log.d("CALCULO", "Sobrepeso");
                    imgResult.setImageResource(R.drawable.sobrepeso);
                } else if (result >= 30 && result < 35) {
                    Log.d("CALCULO", "Obesidade I");
                    imgResult.setImageResource(R.drawable.obesidade1);
                } else if (result >= 35 && result < 40) {
                    Log.d("CALCULO", "Obesidade II");
                    imgResult.setImageResource(R.drawable.obesidade2);
                } else {
                    Log.d("CALCULO", "Obesidade mórbida");
                    imgResult.setImageResource(R.drawable.obesidade_morbida);
                }

                txtResult.setText("IMC: " + result);
            }
        });
    }
}