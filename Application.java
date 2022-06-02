import java.time.*;
import java.time.format.DateTimeFormatter;  
import java.util.Scanner;



public class Application {
    public static void main(String[] args) {
    Bibliothecaire B = new Bibliothecaire();
    Media M = new Livre("Maths", "Analyse", "b123", 1, "Page Bleue", "Laib");
    B.Add_Media(M);
    M = new CD("Maths", "Algebre", "00gh", 1, "Page Bleue");
    B.Add_Media(M);
    M = new CD("Informatique", "Algorithme", "cc1145", 1, "Page Bleue");
    B.Add_Media(M);
    M = new CD("Informatique", "Architecture des ordinateurs", "df456", 1, "Page Bleue");
    B.Add_Media(M);
    M = new CD("Informatique", "Base de donnees", "23ggf", 1, "Page Bleue");
    B.Add_Media(M);
    M = new CD("Informatique", "Programmation orientee objet", "2345", 1, "Page Bleue");
    B.Add_Media(M);
    M = new CD("Informatique", "Probabilitees", "z1234", 1, "Page Bleue");
    B.Add_Media(M);
    M = new CD("Informatique", "Intelligence artificielle", "hg4567", 1, "Page Bleue");
    B.Add_Media(M);
    M = new CD("Informatique", "PHP", "dfr45670", 1, "Page Bleue");
    B.Add_Media(M);
    
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
    
    LocalDate Date1 = LocalDate.of(2022, 05, 29);
    LocalDate Date2 = LocalDate.of(2022, 04, 14);
    LocalDate Date3 = LocalDate.of(2022, 03, 20);
    LocalDate Date4 = LocalDate.of(2022, 01, 04);
    LocalDate Date5 = LocalDate.of(2022, 02, 19);
    LocalDate D1 = Date1.plusDays(10);
    LocalDate D2 = Date2.plusDays(10);
    LocalDate D3 = Date3.plusDays(10);
    LocalDate D4 = Date4.plusDays(10);
    LocalDate D5 = Date5.plusDays(10);
    
    Emprunt E1= new Emprunt(Date1 , D1 , 2222 , 1 , "Analyse");
    Emprunt E2= new Emprunt(Date2 , D2 , 2223 , 3 , "Algebre");
    Emprunt E3= new Emprunt(Date3 , D3 , 2224 , 3 , "Architecture des ordinateurs");
    Emprunt E4= new Emprunt(Date4 , D4 , 2225 , 3 , "Probabilitees");
    Emprunt E5= new Emprunt(Date5 , D5 , 2226 , 3 , "PHP");
    B.Add_Emprunt(E1);
    B.Add_Emprunt(E2);
    B.Add_Emprunt(E3);
    B.Add_Emprunt(E4);
    B.Add_Emprunt(E5);
     Scanner e = new Scanner(System.in);
    int Type=0 , Mat=0;
    int Choix=0;
    String Titre="";
    int C = 0;
    String Cote=" ";
    int Nbr=0;
    String Specialitee = "";
    String Edition = "";
    String Auteur = "";
    String Nom="";
    String Prenom="";
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd "); 
    LocalDate now = LocalDate.now(); 
    B.MENU();
    System.out.println("Entrez votre choix");
    Choix=e.nextInt();
    boolean W = true;
    while(W==true) {
        switch(Choix) {
            case 1 :
            B.Afficher_Media();
            B.MENU();
        System.out.println("Entrez votre choix");
        Choix=e.nextInt();
            break;
            case 2 :
            System.out.println("Donnez le matricule de l'adherent qui va emprunter");
             Mat=e.nextInt();
            System.out.println("Choisissez le numero du type du media a emprunter");
            System.out.println("1-Livre  2-Memoire  3=CD");
             Type=e.nextInt();
            System.out.println("Donnez le titre du media a emprunter");
            Titre = e.next();
            LocalDate Debut = now;
            LocalDate Fin = now.plusDays(10);
            Emprunt E = new Emprunt(Debut, Fin, Mat, Type, Titre);
            B.Add_Emprunt(E);
            B.MENU();
        System.out.println("Entrez votre choix");
        Choix=e.nextInt();
            break;
            case 3 :
            System.out.println("Donnez le matricule de l'adherent qui va retourner le media");
            Mat=e.nextInt();
           System.out.println("Choisissez le numero du type du media a retourner");
           System.out.println("1-Livre  2-Memoire  3=CD");
            Type=e.nextInt();
           System.out.println("Donnez le titre du media a retourner");
           Titre = e.next();
            B.Retourner_Emprunt(Titre, Mat, Type);
            B.Remove_Emprunt(Titre, Type, Mat);
            B.MENU();
        System.out.println("Entrez votre choix");
        Choix=e.nextInt();
            break;
            case 4 :
            System.out.println("Choisissez le numero du type du media a modifier");
            System.out.println("1-Livre  2-Memoire  3=CD");
             Type=e.nextInt();
            System.out.println("Donnez le titre du media a modifier");
            Titre = e.next();
            System.out.println("Entrer votre choix de modification : ");
            System.out.println("1-Modifier la cote  2-Modifier le nombre d'exemplaires");
            C=e.nextInt();
            if(C==1) {
                System.out.println("Donnez la nouvelle cote");
                    Cote = e.next();
                    B.Modifier_Media_Cote(Type, Titre, Cote);
    
            }
            else {
                if(C==2) {
                    System.out.println("Donnez le nombre d'exemplaire ");
                    Nbr = e.nextInt();
                    B.Modifier_Media_Nbr_Exp(Type, Titre, Nbr);
                }
                else {
                    System.out.println("EREUR");
                }
            }
    
    
            B.MENU();
        System.out.println("Entrez votre choix");
        Choix=e.nextInt();
            break;
            case 5 :
            System.out.println("Entrez la cote du media");
            Cote = e.next();
            System.out.println("Entrez le titre du media");
            Titre=e.next();
            System.out.println("Entrez la specialitee du media ");
            Specialitee = e.next();
            
            
                System.out.println("Choisissez le numero du type du media a modifier");
                System.out.println("1-Livre  2-Memoire  3=CD");
                Type=e.nextInt();
                if(Type==1) {
                    System.out.println("Entrez l'edition du livre");
                    Edition=e.next();
                    System.out.println("Entrez l'auteur du livre ");
                    Auteur = e.next();
                    
                    M= new  Livre(Specialitee, Titre, Cote, 1, Edition, Auteur);
                    B.Add_Media(M);
             }
             else {
                 if(Type==2) {
                    System.out.println("Entrez l'auteur de la memoire ");
                    Auteur = e.next();
                     M = new Memoire(Specialitee, Titre, Cote, 1, Auteur);
                     B.Add_Media(M);
                 }
                 else {
                    System.out.println("Entrez le createur du CD ");
                    Auteur = e.next();
                    M = new CD(Specialitee, Titre, Cote, 1, Auteur);
                    B.Add_Media(M);
                 }
             }
            B.MENU();
        System.out.println("Entrez votre choix");
        Choix=e.nextInt();
            break;
            case 6 :
    
            System.out.println("Entrez la cote du media ");
            Cote = e.next();
            System.out.println("Entrez le titre du media");
            Titre=e.next();
            System.out.println("Entrez la specialitee du media ");
            Specialitee = e.next();
            
            
                System.out.println("Choisissez le numero du type du media a modifier");
                System.out.println("1-Livre  2-Memoire  3=CD");
                Type=e.nextInt();
                if(Type==1) {
                    System.out.println("Entrez l'edition du livre");
                    Edition=e.next();
                    System.out.println("Entrez l'auteur du livre ");
                    Auteur = e.next();
                    
                    M= new  Livre(Specialitee, Titre, Cote, 1, Edition, Auteur);
                    B.Remove_Media(M);
             }
             else {
                 if(Type==2) {
                    System.out.println("Entrez l'auteur de la memoire ");
                    Auteur = e.next();
                     M = new Memoire(Specialitee, Titre, Cote, 1, Auteur);
                     B.Remove_Media(M);
    
                 }
                 else {
                    System.out.println("Entrez le createur du CD ");
                    Auteur = e.next();
                    M = new CD(Specialitee, Titre, Cote, 1, Auteur);
                    B.Remove_Media(M);
                 }
                }
            
    
            B.MENU();
        System.out.println("Entrez votre choix");
        Choix=e.nextInt();
            break;
            case 7 :
                System.out.println("La liste des adherents est : ");
                B.Afficher_Adherent();
            B.MENU();
        System.out.println("Entrez votre choix");
        Choix=e.nextInt();
            break;
            case 8 :
                System.out.println("Donnez le matricule de l'adherent a modifier");
                Mat = e.nextInt();
                System.out.println("Entrez votre Numero de choix"); 
                System.out.println("1-Modifier le nom  2-   Modifier le prenom");
                Choix = e.nextInt();
                if(Choix==1) {
                    System.out.println("Donnez le nouveau nom");
                    Nom = e.next();
                    
                    B.Modifier_Adherent(Mat, Choix, Nom);
                }
                else {
                    if(Choix==2) {
                        System.out.println("Donnez le nouveau prenom");
                        Nom = e.next();
                        B.Modifier_Adherent(Mat, Choix, Nom);
                    }
                    else {
                        System.out.println("error");
                    }
                }
            B.MENU();
        System.out.println("Entrez votre choix");
        Choix=e.nextInt();
            break;
            case 9 :
            System.out.println("Entrez le matricule de l'adherent a ajouter");
            Mat = e.nextInt();
            System.out.println("Entrez le nom");
            Nom = e.next();
            System.out.println("Entrez le prenom");
            Prenom = e.next();
            Adherant H = new Adherant(Nom, Prenom, Mat);
            B.Add_Adherant(H);
    
            B.MENU();
        System.out.println("Entrez votre choix");
        Choix=e.nextInt();
            break;
            case 10 :
    
            System.out.println("Entrez le matricule de l'adherent a supprimer");
            Mat = e.nextInt();
            System.out.println("Entrez le nom");
            Nom = e.next();
            System.out.println("Entrez le prenom");
            Prenom = e.next();
            Adherant F = new Adherant(Nom, Prenom, Mat);
            B.Remove_Adherant(F);
    
            B.MENU();
        System.out.println("Entrez votre choix");
        Choix=e.nextInt();
            break;
            case 11 :
                System.out.println("La liste des emprunts est : ");
                B.Afficher_Emprunt();
            B.MENU();
        System.out.println("Entrez votre choix");
        Choix=e.nextInt();
            break;
            case 12 :
                System.out.println("La liste noire est : ");
                B.Afficher_ListeNoire();
            B.MENU();
        System.out.println("Entrez votre choix ");
        Choix=e.nextInt();
            break;
            case 13 :
    
           System.out.println("END OF PROGRAM");
           W=false;
            break;
            default : 
            
            B.MENU();
            System.out.println("Rechoisissez votre choix entre 1 et 13 ");
            Choix=e.nextInt();
            
    
    
    
        }
    }



        // 1=Livre 2 = Memoire 3=CD
        // 1=Nom  2=Prenom

        // LocalDate.of(jr , mois ,yyyy)
    /*LocalDate Date = LocalDate.of(2022, 05, 29);
    System.out.println(Date); */
   
    }
    
    
}
