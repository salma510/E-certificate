package com.example.exo3;

import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private EditText edit1, edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); // Assurez-vous que le nom de votre layout est correct

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);

        // Récupérer les données passées par MainActivity
        String question1 = getIntent().getStringExtra("QUESTION_1");
        String response1 = getIntent().getStringExtra("RESPONSE_1");
        String question2 = getIntent().getStringExtra("QUESTION_2");
        String response2 = getIntent().getStringExtra("RESPONSE_2");

        // Afficher les questions et les réponses dans les EditTexts
        if (question1 != null && response1 != null) {
            edit1.setText(question1 + "\n" + response1); // Affiche la question et la réponse 1
        }

        if (question2 != null && response2 != null) {
            edit2.setText(question2 + "\n" + response2); // Affiche la question et la réponse 2
        }
    }
}