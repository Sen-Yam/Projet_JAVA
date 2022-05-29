public class Application {
    public static void main(String[] args) {
    Bibliothecaire B = new Bibliothecaire();
    Media M = new Livre("Maths", "Analyse", "b123", 1, "Page Bleue", "Laib");
    B.Add_Media(M);
    Media S = new CD("Maths", "Analyse", "b123", 1, "Page Bleue");
    B.Add_Media(S);
    B.Afficher_Media();
        // 1=Livre 2 = Memoire 3=CD
    }
}
