import java.time.*;
public class Application {
    public static void main(String[] args) {
    Bibliothecaire B = new Bibliothecaire();
    Media M = new Livre("Maths", "Analyse", "b123", 1, "Page Bleue", "Laib");
    B.Add_Media(M);
    M = new CD("Physique", "Algebre", "00gh", 1, "Page Bleue");
    B.Add_Media(M);
    M = new CD("Maths", "Algorithme", "cc1145", 1, "Page Bleue");
    B.Add_Media(M);
    M = new CD("Maths", "Architecture des ordinateurs", "df456", 1, "Page Bleue");
    B.Add_Media(M);
    M = new CD("Maths", "Base de donnees", "23ggf", 1, "Page Bleue");
    B.Add_Media(M);
    M = new CD("Maths", "Programmation orientee objet", "2345", 1, "Page Bleue");
    B.Add_Media(M);
    M = new CD("Maths", "Probabilitee", "z1234", 1, "Page Bleue");
    B.Add_Media(M);
    M = new CD("Maths", "Intelligence artificielle", "hg4567", 1, "Page Bleue");
    B.Add_Media(M);
    M = new CD("Maths", "PHP", "dfr45670", 1, "Page Bleue");
    B.Add_Media(M);
    B.Afficher_Media();
    Adherant a = new Adherant ("laraba" , "yamina" , 1234);
    Adherant a1 = new Adherant ("laib" , "wissal" , 2222);
    Adherant a2 = new Adherant ("hanafi" , "yasmine" , 2223);
    Adherant a3 = new Adherant ("boulkaboul" , "amira" , 2224);
    Adherant a4 = new Adherant ("kasmi" , "rafik" , 2225);
    Adherant a5 = new Adherant ("kaci" , "imene" , 2226);
    Adherant a6 = new Adherant ("khellaf" , "hichem" , 2227);
    B.Add_Adherant(a);
    B.Add_Adherant(a1);
    B.Add_Adherant(a2);
    B.Add_Adherant(a3);
    B.Add_Adherant(a4);
    B.Add_Adherant(a5);
    B.Add_Adherant(a6);
    B.Afficher_Adherent();
    LocalDate Date1 = LocalDate.of(2022, 05, 29);
    LocalDate Date2 = LocalDate.of(2022, 04, 14);
    LocalDate Date3 = LocalDate.of(2022, 03, 20);
    LocalDate Date4 = LocalDate.of(2022, 01, 04);
    LocalDate Date5 = LocalDate.of(2022, 02, 19);
    Emprunt E1= new Emprunt(Date1 , Date1 , 2222 , 1 , "Arabe");
    B.Add_Emprunt(E1);




        // 1=Livre 2 = Memoire 3=CD

        // LocalDate.of(jr , mois ,yyyy)
    /*LocalDate Date = LocalDate.of(2022, 05, 29);
    System.out.println(Date); */
    
    }
    

}
