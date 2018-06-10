package isauze.ma_super_appli_scolaire;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

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
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_tweet,parent, false);
            }

            TweetViewHolder viewHolder = (TweetViewHolder) convertView.getTag();
            if(viewHolder == null){
                viewHolder = new TweetViewHolder();
                viewHolder.pseudo = (TextView) convertView.findViewById(R.id.pseudo);
                viewHolder.text = (TextView) convertView.findViewById(R.id.text);
                viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
                convertView.setTag(viewHolder);
            }

            //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
            Tweet tweet = getItem(position);

            //il ne reste plus qu'à remplir notre vue
            viewHolder.pseudo.setText(tweet.getPseudo());
            viewHolder.text.setText(tweet.getText());
            viewHolder.avatar.setImageDrawable(new ColorDrawable(tweet.getColor()));

            return convertView;
        }


}

    private class CompteViewHolder{
        public ImageView avatar;
    }
