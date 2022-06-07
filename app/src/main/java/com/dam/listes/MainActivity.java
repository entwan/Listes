package com.dam.listes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /* 1 var globales */

    private ListView listView;
    private String[] stagiaires = new String[] {
            "Nelson",
            "Charbel",
            "Hicham",
            "Walid",
            "Antoine",
            "Nassir",
            "Ben",
            "Sonia",
            "Ons",
            "Anh Hoang"
    };

    /* 2 initialisation des composants */
    private void initUI() {
        listView = findViewById(R.id.lvStagiaires);
    }

    /** Methodes perso pour l'application  ***/
    private void affichageDataDansListView(){



        // Methode 1 - Depuis un tableau situe dans le JAVA (cette classe)

//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this, android.R.layout.simple_list_item_1,stagiaires);


        // Methode 2 - Depuis un tableau présent dans le fichier strigns
        String[] listeDepuisStrings = getResources().getStringArray(R.array.liste_stagiaires);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,listeDepuisStrings);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valeurItemClique = (String) listView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,
                        "Le stagiaire : " + valeurItemClique,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }



    /*** Cycles de vies **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*  3 Lancement de la methode d'initalisation   */
        initUI();

        affichageDataDansListView();

    }
}