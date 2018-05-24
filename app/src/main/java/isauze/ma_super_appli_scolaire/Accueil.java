package isauze.ma_super_appli_scolaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;
import com.orm.SugarRecord;

public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Surcharge du XML pour créer la hiérarchie des composants graphiques
        setContentView(R.layout.accueil);

        SugarContext.terminate();
        SchemaGenerator schemaGenerator = new SchemaGenerator(getApplicationContext());
        schemaGenerator.deleteTables(new SugarDb(getApplicationContext()).getDB());
        SugarContext.init(getApplicationContext());
        schemaGenerator.createDatabase(new SugarDb(getApplicationContext()).getDB());

        // Récupérer les objets de l'arbre graphique avec leur id
        Button creer = (Button) findViewById(R.id.a_bouton_nouv_compte) ;

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
    }
}
