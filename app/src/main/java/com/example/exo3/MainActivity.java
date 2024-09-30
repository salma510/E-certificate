package com.example.exo3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox check1, check2, check3, check4;
    private RadioButton oui, non;
    private Button suivant, quitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Assurez-vous que le nom de votre layout est correct

        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.chech3);
        check4 = findViewById(R.id.chech4);
        oui = findViewById(R.id.oui);
        non = findViewById(R.id.non);
        suivant = findViewById(R.id.suivant);
        quitter = findViewById(R.id.quitter);

        // Gestionnaire d'événements pour le bouton "Suivant"
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Créer un Intent pour passer à MainActivity2
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                // Récupérer les réponses sélectionnées
                StringBuilder selectedAnswers = new StringBuilder();
                String answer1 = null;
                String answer2 = null;

                // Vérifier les cases à cocher
                if (check1.isChecked()) {
                    selectedAnswers.append(check1.getText()).append("\n");
                    answer1 = check1.getText().toString(); // Première réponse
                }
                if (check2.isChecked()) {
                    selectedAnswers.append(check2.getText()).append("\n");
                    answer2 = check2.getText().toString(); // Deuxième réponse
                }
                if (check3.isChecked()) {
                    selectedAnswers.append(check3.getText()).append("\n");
                }
                if (check4.isChecked()) {
                    selectedAnswers.append(check4.getText()).append("\n");
                }

                // Récupérer la réponse à la question 2
                String ouiNonResponse = oui.isChecked() ? "Oui" : "Non";

                // Passer les questions et les réponses à la deuxième activité
                intent.putExtra("QUESTION_1", "1. Le pattern MVC signifie:");
                intent.putExtra("RESPONSE_1", selectedAnswers.length() > 0 ? selectedAnswers.toString() : "Pas de réponse");
                intent.putExtra("QUESTION_2", "2. La syntaxe $[x] est permise dans une JSP:");
                intent.putExtra("RESPONSE_2", ouiNonResponse);
                startActivity(intent);
            }
        });

        // Gestionnaire d'événements pour le bouton "Quitter"
        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Terminer l'activité
                System.exit(0); // Quitter l'application
            }
        });
    }
}