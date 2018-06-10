package isauze.ma_super_appli_scolaire;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import classes_base.Compte;

/**
 * Created by Ingrid on 10/06/2018.
 */

public class Compte_adapter extends ArrayAdapter<Compte> {

        //tweets est la liste des models à afficher
        public Compte_adapter(Context context, List<Compte> compte) {
            super(context, 0, compte);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.compte_vue,parent, false);
            }

            CompteViewHolder viewHolder = (CompteViewHolder) convertView.getTag();
            if(viewHolder == null){
                viewHolder = new CompteViewHolder();
                viewHolder.prenom = (TextView) convertView.findViewById(R.id.compte_texte);
                viewHolder.nom = (TextView) convertView.findViewById(R.id.compte_texte2);
                viewHolder.avatar = (ImageView) convertView.findViewById(R.id.compte_image);
                convertView.setTag(viewHolder);
            }

            //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
            Compte compte = getItem(position);

            //il ne reste plus qu'à remplir notre vue
            viewHolder.prenom.setText(compte.getPrenom());
            viewHolder.nom.setText(compte.getNom());
            //viewHolder.avatar.setImageDrawable(new ColorDrawable(tweet.getColor()));

            return convertView;
        }


}
