package isauze.ma_super_appli_scolaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;
import com.orm.SugarRecord;

import java.util.List;

import classes_base.Compte;

import static classes_base.CompteDAO.selectTous;

public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SugarContext.init(this) ;

        // Surcharge du XML pour créer la hiérarchie des composants graphiques
        setContentView(R.layout.accueil);

//        SugarContext.terminate();
//        SchemaGenerator schemaGenerator = new SchemaGenerator(getApplicationContext());
//        schemaGenerator.deleteTables(new SugarDb(getApplicationContext()).getDB());
//        SugarContext.init(getApplicationContext());
//        schemaGenerator.createDatabase(new SugarDb(getApplicationContext()).getDB());

        // Récupérer les valeurs passées par l'intent
        final int id = getIntent().getIntExtra("ID_COMPTE", 0) ;

        // Récupérer les objets de l'arbre graphique avec leur id
        final Button creer = (Button) findViewById(R.id.a_bouton_nouv_compte) ;
        final Button exercices = (Button) findViewById(R.id.a_liste_ex) ;
        final TextView texte = (TextView) findViewById(R.id.a_choix) ;

        texte.setVisibility(View.INVISIBLE);

        // Si l'utilisateur n'est pas connecté
        if(id == 0) {
            // Rendre invisible le texte de choix du compte
            texte.setVisibility(View.VISIBLE);
            // Récupération de la ListView
            final ListView listeView = (ListView) findViewById(R.id.a_liste) ;
            List<Compte> liste_comptes = selectTous() ; // liste de tous les comptes
            if(!(liste_comptes.isEmpty())) {
                Compte_adapter adapter = new Compte_adapter(Accueil.this, liste_comptes);
                listeView.setAdapter(adapter);
                listeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                });
            }


            // Basculer sur la page de création du compte en cas de clic sur le bouton
            creer.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             // Création de l'intention
                                             Intent intent = new Intent(Accueil.this, creer_compte.class) ;
                                             startActivity(intent);
                                         }
                                     }
            ) ;
            exercices.setVisibility(View.INVISIBLE);
        }
        else {
            exercices.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Création de l'intention
                    Intent intent = new Intent(Accueil.this, liste_exercices.class) ;
                    intent.putExtra("ID_COMPTE", id) ;
                    startActivity(intent);
                }
                                         }
            );
            creer.setVisibility(View.INVISIBLE);
        }

    }
}
