
import java.time.LocalDate;

public class Emprunt {
    LocalDate DateDebut , DateRt;
    int Matricule,Type;  
    String Titre;

    public Emprunt(LocalDate D1 , LocalDate D2 , int Mat , int Type , String Titre) {
        this.DateDebut=D1; // Constructeur d'emprunts
        this.DateRt=D2;
        this.Type=Type;
        this.Matricule=Mat;
        this.Titre=Titre;
    }
    


   
}
