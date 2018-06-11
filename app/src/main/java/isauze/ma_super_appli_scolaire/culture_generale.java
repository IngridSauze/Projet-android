package isauze.ma_super_appli_scolaire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class culture_generale extends AppCompatActivity {
    private String[] questions = {"Quelle est la date de la bataille de Marignan ?",
            "Quel pays n'est pas situé en Europe ?",
            "Quelle est la capitale de l'Allemagne ?",
            "Quel est le plus lourd : un kilo de plumes ou un kilo de plomb ?",
            "Qui est le premier empereur de Rome ?",
            "Qui a été le dernier roi des Français ?",
            "Quel était le titre du fils de Napoléon Ier ?",
            "Quel est le successeur d'Akhénaton ?",
            "Quel fut le prédécesseur de Toutankhamon ?",
            "Combien font deux plus trois ?",
            "Quel est la date de la révolution française ?",
            "Comment s'appelle l'hymne national français ?",
            "Quel est le fondateur de la Cinquième République ?"
    } ;

    private String[] reponse = {
            "1515", "Pérou", "Berlin", "Ni l'un ni l'autre", "Auguste", "Louis-Philippe Ier", "Roi de Rome", "Smenkharê",
            "Smenkharê", "5", "1789", "La Marseillaise", "Charles de Gaulle"
    } ;

    private String[] faux1 = {
            "1456", "Italie", "Paris", "Les plumes", "Jules César", "Louis XVI", "Prince de Padoue", "Toutankhamon",
            "Akhénaton", "15", "1790", "God Save the Queen", "Georges Pompidou"
    } ;

    private String[] faux2 = {
            "1517", "Pologne", "Oslo", "Le plomb", "Romulus Augustule", "Louis XVIII", "Prince de Corse", "Ramsès XVII",
            "Toutencarton", "2", "1678", "Le Chant des Partisans", "Vincent Auriol"
    } ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.culture_generale);

        // Récupérer les valeurs passées par l'intent
        final int id = getIntent().getIntExtra("ID_COMPTE", 0);

        // Récupérer les objets de l'arbre graphique avec leur id
        final Button valider = (Button) findViewById(R.id.g_exercice);
        final Button exercices = (Button) findViewById(R.id.g_exercice);
        final Button accueil = (Button) findViewById(R.id.g_b_accueil);
        final TextView texte = (TextView) findViewById(R.id.g_texte_accueil_ac) ;
        final RadioGroup groupe = (RadioGroup) findViewById(R.id.g_groupe) ;
        final RadioButton radio1 = (RadioButton) findViewById(R.id.g_radio1) ;
        final RadioButton radio2 = (RadioButton) findViewById(R.id.g_radio2) ;
        final RadioButton radio3 = (RadioButton) findViewById(R.id.g_radio3) ;

        groupe.addView(radio1); ;
//        groupe.addView(radio2) ;
//        groupe.addView(radio3) ;
//
//        exercices.setVisibility(View.INVISIBLE);
//        accueil.setVisibility(View.INVISIBLE);
//
//        // Variables de contrôle
//        int nb_question = 0 ;
//
//        // Mise en place des quetions
//        for(int i = 0 ; i < 10 ; i++) {
//            // Hasard
//            Random r_question = new Random();
//            final int valeur = 0 + r_question.nextInt(questions.length - 0) ;
//
//            texte.setText(questions[valeur]);
//            radio1.setText(reponse[valeur]);
//            radio2.setText(faux1[valeur]);
//            radio3.setText(faux2[valeur]);
//
//            valider.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int erreurs = 0 ;
//                    RadioButton r = (RadioButton) groupe.getChildAt(groupe.getCheckedRadioButtonId()) ;
//                    if (!(r.getText().equals(reponse[valeur])))  {
//                        erreurs++ ;
//                    }
//                }
//        }) ;
//
//    }
//
//        exercices.setVisibility(View.VISIBLE);
//        accueil.setVisibility(View.VISIBLE);
//        valider.setVisibility(View.INVISIBLE);
}
}