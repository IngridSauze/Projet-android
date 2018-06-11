package isauze.ma_super_appli_scolaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class liste_exercices extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_exercices);

        // Récupérer les objets de l'arbre graphique avec leur id
        Button maths = (Button) findViewById(R.id.l_maths) ;
        Button culture = (Button) findViewById(R.id.l_culture_g) ;

        // La classe "écoute"
        maths.setOnClickListener(this);
        culture.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = getIntent().getIntExtra("ID_COMPTE", 0) ; // Récupérer les valeurs passées par l'intent
        switch (v.getId()) { // récupération de l'id du bouton qui a été cliqué
            case R.id.l_maths :
                Intent intent = new Intent(this, maths_accueil.class) ;
                intent.putExtra("ID_COMPTE", id) ;
                startActivity(intent);
                break;

            case R.id.l_culture_g :
                Intent intent1 = new Intent(this, culture_generale.class) ;
                intent1.putExtra("ID_COMPTE", id) ;
                startActivity(intent1);
                break;
        }
    }
}
