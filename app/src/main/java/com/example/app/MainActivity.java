package com.example.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private RadioButton Radio1, Radio2, Radio3;
    private RadioGroup RadioGroup;
    private ImageView Obraz;
    private TextView Napis;
    private Button Przycisk;
    private int indeksAktualnegoPytania = 0;
    private int liczbaPunktow = 0;
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

        String[] NapisyObrazek = new String[] {"Które to schronisko?", "Zwierzę na zdjęciu to", "W oddali są widoczne"};

        String[] OdpowiedziRadio1 = new String[] {"Na Rysiance.", "owczarek.", "Himalaje."};
        String[] OdpowiedziRadio2 = new String[] {"Na Wielkiej Raczy", "wilk.", "Alpy."};
        String[] OdpowiedziRadio3 = new String[] {"Na Wielkiej Rycerzowej.", "kozica.", "Tatry."};

        int[] OdpowiedziPoprawne = new int[] {2, 1, 3};
        int[] obrazkiZadan = {R.drawable.zad1, R.drawable.zad2, R.drawable.zad3};

        RadioGroup RadioGroup = findViewById(R.id.RadioGroup);
        Radio1 = findViewById(R.id.Radio1);
        Radio2 = findViewById(R.id.Radio2);
        Radio3 = findViewById(R.id.Radio3);
        Obraz = findViewById(R.id.Obraz);
        Napis = findViewById(R.id.Napis);
        Przycisk = findViewById(R.id.Przycisk);

        Przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int WybranyRadio = RadioGroup.indexOfChild(findViewById(RadioGroup.getCheckedRadioButtonId()));
                boolean Poprawny = (WybranyRadio + 1 == OdpowiedziPoprawne[indeksAktualnegoPytania]);
                if(Poprawny) {
                    liczbaPunktow++;
                }
                //Toast.makeText(MainActivity.this, "Punkty: " + liczbaPunktow, Toast.LENGTH_SHORT).show();
                indeksAktualnegoPytania++;

                if(indeksAktualnegoPytania >= NapisyObrazek.length) {
                    indeksAktualnegoPytania = 0;
                }

                Napis.setText(NapisyObrazek[indeksAktualnegoPytania]);
                Radio1.setText(OdpowiedziRadio1[indeksAktualnegoPytania]);
                Radio2.setText(OdpowiedziRadio2[indeksAktualnegoPytania]);
                Radio3.setText(OdpowiedziRadio3[indeksAktualnegoPytania]);
                Obraz.setImageResource(obrazkiZadan[indeksAktualnegoPytania]);
                RadioGroup.clearCheck();
                }



                /*
                String aktualnyTekst = Napis.getText().toString();

                if(aktualnyTekst.equals("Które to schronisko?")){
                    if(Radio2.isChecked()){
                        liczbaPunktow++;
                    }
                    Napis.setText("Zwierzę na zdjęciu to");
                    Radio1.setText("owczarek.");
                    Radio2.setText("wilk.");
                    Radio3.setText("kozica.");
                    Obraz.setImageResource(R.drawable.zad2);
                }
                else if(aktualnyTekst.equals("Zwierzę na zdjęciu to")){
                    if(Radio1.isChecked()){
                        liczbaPunktow++;
                    }
                    Napis.setText("W oddali są widoczne");
                    Radio1.setText("Himalaje.");
                    Radio2.setText("Alpy.");
                    Radio3.setText("Tatry.");
                    Obraz.setImageResource(R.drawable.zad3);
                }
                else if(aktualnyTekst.equals("W oddali są widoczne")){
                    if(Radio3.isChecked()){
                        liczbaPunktow++;
                    }
                    Napis.setText("Które to schronisko?");
                    Radio1.setText("Na Rysiance.");
                    Radio2.setText("Na Wielkiej Raczy.");
                    Radio3.setText("Na Wielkiej Rycerzowej.");
                    Obraz.setImageResource(R.drawable.zad1);
                    RadioGroup.clearCheck();
                }*/
        });
    }
}
