package isauze.ma_super_appli_scolaire;

/**
 * Created by Ingrid on 12/06/2018.
 */

public enum Questions {
    H1("Quelle est la date de la bataille de Marignan ?", "1515", "1515", "1456", "300"),
    H2("Qui est le premier empereur de Rome ?", "Auguste", "Marc-Aurèle", "Jules César", "Auguste"),
    H3("Qui a été le dernier roi des Français ?", "Louis-Philippe Ier", "Louis XVI", "Louis-Philippe Ier", "Louis XVIII"),
    H4("Quel était le titre du fils de Napoléon Ier ?", "Roi de Rome", "Prince de Padoue", "Roi de Rome", "Prince de Rome"),
    H5("Quel est le successeur d'Akhénaton ?", "Smenkharê", "Smenkharê", "Toutankhamon", "Ramsès II"),
    H6("Quel fut le prédécesseur de Toutankhamon ?", "Smenkharê", "Ramsès III", "Smenkharê", "Akhénaton"),
    H7("Quel est la date de la révolution française ?", "1789", "1789", "1515", "1712"),
    H8("Quel est le fondateur de la Cinquième République ?", "Charles de Gaulle", "Charles de Gaulle", "Georges Pompidou", "Vincent Auriol"),
    H9("Quelle est la date de la fondation de la Cinquième République ?", "1958", "1918", "1945", "1958"),
    H10("Quelle est la date de la fin de la Première Guerre Mondiale ?", "1918", "1914", "1945", "1918"),
    H11("Qui a déménagé la Cour à Versailles ?", "Louis XIV", "Louis XIII", "Napoléon", "Louis XIV");

    private final String nom;
    private final String reponse;
    private final String[] tab;

    private Questions(String nom, String reponse, String... args) {
        this.nom = nom;
        this.reponse = reponse;
        this.tab = args;
    }

    public String getNom() {
        return nom ;
    }

    public String getReponse() {
        return reponse ;
    }

    public String[] getTab() {
        return tab ;
    }
}
