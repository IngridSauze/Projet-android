package isauze.ma_super_appli_scolaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class addition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addition);

        // Récupérer les objets de l'arbre graphique avec leur id
        final Button valider = (Button) findViewById(R.id.ad_valider);
        final NumberPicker np = (NumberPicker) findViewById(R.id.ad_num);

        // Récupérer les valeurs passées par l'intent
        final int id = getIntent().getIntExtra("ID_COMPTE", 0);

        // Maximum et minimum
        np.setMaxValue(10);
        np.setMinValue(1);
        np.setWrapSelectorWheel(true);

        // Basculer sur la page de l'exercice en cas de clic sur le bouton
        valider.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           // Création de l'intention
                                           Intent intent = new Intent(addition.this, addition_1.class);
                                           intent.putExtra("ID_COMPTE", id);
                                           intent.putExtra("TABLE", ((int) np.getValue()));
                                           startActivity(intent);
                                       }
                                   }
        );
    }
}

