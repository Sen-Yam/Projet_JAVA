import java.util.ArrayList;

import static java.lang.System.in;

import java.time.*;
import java.time.format.DateTimeFormatter;  


public class Bibliothecaire {
    ArrayList <Media> M;
    ArrayList <Adherant> A;
    ArrayList <Emprunt> E;
    ArrayList <Adherant> L;
    

    public Bibliothecaire() {
       this.A= new  ArrayList();
       this.M= new  ArrayList();
       this.E= new  ArrayList();
       this.L= new  ArrayList();

    }

    public void Afficher_Media() {
        System.out.println("La liste des Media-s : ");
        for(int i =0 ; i<this.M.size();i++) {
           if(this.M.get(i) instanceof Livre) {
               
               Livre L = (Livre) this.M.get(i);
               System.out.println("\nMedia "+i+" de type Livre : ");
             System.out.println( " Specialitee : "+L.Specialitee+" Titre "+L.Titre+" Cote : "+L.Cote+"  Nombre d'exemplaire "+L.Nbr_exp +" Edition : "+L.Edition+" Auteur : "+L.Author); 
           }
           else {
            System.out.println("\nMedia "+i+" de type CD : ");
               if(this.M.get(i) instanceof CD) {
               CD L = (CD) this.M.get(i);
               System.out.println(" Specialitee : "+L.Specialitee+" Titre "+L.Titre+" Cote : "+L.Cote+"  Nombre d'exemplaire "+L.Nbr_exp +" Createur : "+L.Creator); 
               }
               else {
                   Memoire L =(Memoire) this.M.get(i);
                System.out.println("\nMedia "+i+" de type Memoire : ");
                System.out.println( " Specialitee : "+L.Specialitee+" Titre "+L.Titre+" Cote : "+L.Cote+"  Nombre d'exemplaire "+L.Nbr_exp +" Auteur : "+L.Author); 
               }
           }
       
        }
       
        

    }
    public void Afficher_Adherent() {
        System.out.println("La liste des Adherents : ");
        for(int i=0 ; i<this.A.size();i++) {
            System.out.println("\nAdherent "+i+" : ");
            System.out.println("Nom : "+this.A.get(i).Nom+" Prenom : "+this.A.get(i).Penom+" Matricule : "+this.A.get(i).Matricule);
        }
    }

    public void Afficher_Emprunt() {
        String T=" ";
        System.out.println("La liste des emprunts : ");
        for(int i=0 ; i<this.E.size();i++) {
            System.out.println("Emprunt "+i+" :");
            if(this.E.get(i).Type==1) {
                T="Livre";
            }
            else {
                if(this.E.get(i).Type==2) {
                    T="Memoire";
                }
                else {
                    T="CD";
                }
            }
            System.out.println("Matricule : "+this.E.get(i).Matricule+" Titre : "+this.E.get(i).Titre+" Type : "+T+" Date du debut : "+this.E.get(i).DateDebut+" Date du retour : "+this.E.get(i).DateRt);
        }
    }

    public void Add_Media(Media M) {
        int N = 0;
        if(M instanceof Livre ) {
            N=1;
        }
        else {
            if(M instanceof Memoire) {
                N=2;
            }
            else {
                N=3;
            }
        }
        if(this.Existe_Media(M.Titre, N)!=null) {
            int i=0;
            boolean A=false;
            switch(N) {
                case 1 : 
                 i=0;
                while (i<this.M.size() && A==false) {
                    if(this.M.get(i) instanceof Livre &&  this.M.get(i).Titre.compareTo(M.Titre)==0) {
                        A=true;
                        this.M.get(i).Nbr_exp++;
                        System.out.println("Media ajoutee !");
                    }
                    else {
                        i++;
                        
                    }
                }
    
                break;
                case 2: 
                i=0;
                while (i<this.M.size() && A==false) {
                    if(this.M.get(i) instanceof Memoire &&  this.M.get(i).Titre.compareTo(M.Titre)==0) {
                        A=true;
                        this.M.get(i).Nbr_exp++;
                        System.out.println("Media ajoutee !");
                    }
                    else {
                        i++;
                        
                    }
                }
    
                break;
                case 3 : 
                 i=0;
                while (i<this.M.size() && A==false) {
                    if(this.M.get(i) instanceof CD &&  this.M.get(i).Titre.compareTo(M.Titre)==0) {
                        A=true;
                        this.M.get(i).Nbr_exp++;
                        System.out.println("Media ajoutee !");
                    }
                    else {
                        i++;
                    }
                }
    
                break;
    
               }

               
        }
        else {
            this.M.add(M);
            System.out.println("Media ajoutee !");
        }
      
    }
    public void Remove_Media(Media M) {
        int N = 0;
        if(M instanceof Livre ) {
            N=1;
        }
        else {
            if(M instanceof Memoire) {
                N=2;
            }
            else {
                N=3;
            }
        }
        if(this.Existe_Media(M.Titre, N)!=null) {
            if(this.Existe_Media(M.Titre, N).Nbr_exp==1) {
                this.M.remove(M);
            }
            else {
                boolean A=false;
                int i=0;
                switch(N) {
                    case 1 : 
                     i=0;
                    while (i<this.M.size() && A==false) {
                        if(this.M.get(i) instanceof Livre &&  this.M.get(i).Titre.compareTo(M.Titre)==0) {
                            A=true;
                            this.M.get(i).Exp_Emp--;
                        }
                        else {
                            i++;
                        }
                    }
        
                    break;
                    case 2: 
                    i=0;
                    while (i<this.M.size() && A==false) {
                        if(this.M.get(i) instanceof Memoire &&  this.M.get(i).Titre.compareTo(M.Titre)==0) {
                            A=true;
                            this.M.get(i).Exp_Emp--;
                        }
                        else {
                            i++;
                        }
                    }
        
                    break;
                    case 3 : 
                     i=0;
                    while (i<this.M.size() && A==false) {
                        if(this.M.get(i) instanceof CD &&  this.M.get(i).Titre.compareTo(M.Titre)==0) {
                            A=true;
                            this.M.get(i).Exp_Emp--;
                        }
                        else {
                            i++;
                        }
                    }
        
                    break;
        
                   }
            }
            
        }
        else {
            System.out.println("Ce media n'existe pas !");
        }
        
    }

    public void Add_Adherant(Adherant A) {
        if(this.Existe_Adherent(A.Matricule)==false) {
            this.A.add(A);
            System.out.println("Adherent ajoutee !");
        }
        else {
            System.out.println("Cet adherent existe deja");
        }
       
    }
    public void Remove_Adherant(Adherant A ) {
        if(this.Existe_Adherent(A.Matricule)==true) {
            this.A.remove(A);
            System.out.println("Adherent supprimee");
        }
        else {
            System.out.println("Cet adherent n'existe pas !");
        }
        
    }

    public void Add_Emprunt(Emprunt E) {
       
         Media Z =  this.Existe_Media(E.Titre, E.Type); 

         
         if(this.Existe_Emprunt(E.Matricule, E.Titre, E.Type)==null) {  
        if( this.Existe_Adherent(E.Matricule)==true &&  Z!=null && Z.Nbr_exp-Z.Exp_Emp>0) {
            this.E.add(E);
            boolean A=false;
            int i=0;
           switch(E.Type) {
            case 1 : 
             i=0;
            while (i<this.M.size() && A==false) {
                if(this.M.get(i) instanceof Livre &&  this.M.get(i).Titre.compareTo(E.Titre)==0) {
                    A=true;
                    this.M.get(i).Exp_Emp++;
                    System.out.println("Emprunt ajoutee !");
                }
                else {
                    i++;
                }
            }

            break;
            case 2: 
            i=0;
            while (i<this.M.size() && A==false) {
                if(this.M.get(i) instanceof Memoire &&  this.M.get(i).Titre.compareTo(E.Titre)==0) {
                    A=true;
                    this.M.get(i).Exp_Emp++;
                    System.out.println("Emprunt ajoutee !");
                }
                else {
                    i++;
                }
            }

            break;
            case 3 : 
             i=0;
            while (i<this.M.size() && A==false) {
                if(this.M.get(i) instanceof CD &&  this.M.get(i).Titre.compareTo(E.Titre)==0) {
                    A=true;
                    this.M.get(i).Exp_Emp++;
                    System.out.println("Emprunt ajoutee !");
                }
                else {
                    i++;
                }
            }

            break;

           }
        }
        else {
            System.out.println("Ce media n'est pas disponible");
        }
    }
    else { 
        System.out.println("Cet emprunt existe deja !");
    }
       

    }
    public void Remove_Emprunt(String Titre , int Type , int Matricule) {
         Emprunt Z =  this.Existe_Emprunt(Matricule , Titre, Type); 
        if(Z!=null) {
            this.E.remove(E);
            boolean A=false;
            int i=0;
           switch(Type) {
            case 1 : 
             i=0;
            while (i<this.M.size() && A==false) {
                if(this.M.get(i) instanceof Livre &&  this.M.get(i).Titre.compareTo(Titre)==0) {
                    A=true;
                    this.M.get(i).Exp_Emp--;
                }
                else {
                    i++;
                }
            }

            break;
            case 2: 
            i=0;
            while (i<this.M.size() && A==false) {
                if(this.M.get(i) instanceof Memoire &&  this.M.get(i).Titre.compareTo(Titre)==0) {
                    A=true;
                    this.M.get(i).Exp_Emp--;
                }
                else {
                    i++;
                }
            }

            break;
            case 3 : 
             i=0;
            while (i<this.M.size() && A==false) {
                if(this.M.get(i) instanceof CD &&  this.M.get(i).Titre.compareTo(Titre)==0) {
                    A=true;
                    this.M.get(i).Exp_Emp--;
                }
                else {
                    i++;
                }
            }

            break;

           }
        }
        else {
            System.out.println("Ce media n'est pas disponible");
        }
       

    }


    public Media Existe_Media(String Titre , int N) {
        Boolean E=false;
        Media M = null;
        int i=0;
        switch(N)  {
            case 1 : 
             i=0;
            while (i<this.M.size() && E==false) {
                if(this.M.get(i) instanceof Livre &&  this.M.get(i).Titre.compareTo(Titre)==0) {
                    E=true;
                    M=this.M.get(i);
                }
                else {
                    i++;
                }
            }

            break;
            case 2: 
            i=0;
            while (i<this.M.size() && E==false) {
                if(this.M.get(i) instanceof Memoire &&  this.M.get(i).Titre.compareTo(Titre)==0) {
                    E=true;
                    M=this.M.get(i);
                }
                else {
                    i++;
                }
            }

            break;
            case 3 : 
             i=0;
            while (i<this.M.size() && E==false) {
                if(this.M.get(i) instanceof CD &&  this.M.get(i).Titre.compareTo(Titre)==0) {
                    E=true;
                    M=this.M.get(i);
                }
                else {
                    i++;
                }
            }

            break;
        }

        
        return M;
    }

    public Boolean Existe_Adherent(int Mat) {
        Boolean E=false;
        int i=0;
        
            while (i<this.A.size() && E==false) {
                if( this.A.get(i).Matricule==Mat) {
                    E=true;
                }
                else {
                    i++;
                }
            }

            
           
        
        return E;
    }
    public Emprunt Existe_Emprunt(int Mat , String Titre , int Type) {
        Boolean E=false;
        Emprunt Z=null;
        int i=0;
        
            while (i<this.E.size() && E==false) {
                if( this.E.get(i).Matricule==Mat && this.E.get(i).Titre==Titre && this.E.get(i).Type==Type ) {
                    E=true;
                    Z=this.E.get(i);
                }
                else {
                    i++;
                }
            }

            
           
        
        return Z;
    }

    public void Retourner_Emprunt(String Titre , int Matricule , int Type) {
        Emprunt E = this.Existe_Emprunt(Matricule, Titre, Type);
        if(E==null) {
            System.out.println("Cet emprunt n'existe pas !");
        }
        else {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd "); 
             LocalDate now = LocalDate.now(); 
             Adherant A = new Adherant(" ", " ", 00) ;
            if(now.isAfter(E.DateRt)) {
                System.out.println("Vous avez depasee le delai ! ");
                int i=0;
                while (i<this.A.size()) {
                    if(Matricule==this.A.get(i).Matricule) {
                        A = this.A.get(i);
                    }
                    i++;
                }
                this.L.add(A);

            }
        }
    }

    public void Afficher_ListeNoire() {
        if(this.L.size()==0) {
            System.out.println("La liste noire est vide");
        }
        else {
            for(int i=0 ; i<this.L.size() ; i++) {
                System.out.println("\nAdherent "+i+" : ");
            System.out.println("Nom : "+this.A.get(i).Nom+" Prenom : "+this.A.get(i).Penom+" Matricule : "+this.A.get(i).Matricule);
            }
        }
    }

    public  void Modifier_Adherent(int Matricule , int Choix , String New) {
        if(this.Existe_Adherent(Matricule)==false) {
            System.out.println("Cet adherent n'existe pas !");
        }
        else {
            
            boolean E=false;
            int i=0;
            while(E==false && i<this.A.size()) {
                if(this.A.get(i).Matricule==Matricule) {
                    if(Choix==1) {
                        this.A.get(i).Nom=New;
                       
                    }
                    else {
                        this.A.get(i).Penom=New;
                    }
                    E=true;
                    
                }
            }
            System.out.println("Adherent modifiee");
            
        }
       

    }

    public void Modifier_Media_Cote(int Type , String Titre , String NewCote) {

        if(this.Existe_Media(Titre, Type)!=null) {

        
        boolean E=false;
        int i=0;
        switch(Type) {
            case 1 :
            while(E==false && i<this.M.size()) {
                if(this.M.get(i) instanceof Livre &&  this.M.get(i).Titre==Titre) {
                        this.M.get(i).Cote=NewCote;
                        E=true;
                }
                i++;
            }
            
                
            break;
            case 2 :
            while(E==false && i<this.M.size()) {
                if(this.M.get(i) instanceof Memoire &&  this.M.get(i).Titre==Titre) {
                        this.M.get(i).Cote=NewCote;
                        E=true;
                }
                i++;
            }
            break;
            case 3 :
            while(E==false && i<this.M.size()) {
                if(this.M.get(i) instanceof CD &&  this.M.get(i).Titre==Titre) {
                        this.M.get(i).Cote=NewCote;
                        E=true;
                }
                i++;
            }
            break;
        }
        System.out.println("Media modifiee !");
    }
    else {
        System.out.println("Ce media n'existe pas !");
    }
        
    }

    public void Modifier_Media_Nbr_Exp(int Type , String Titre , int Newnbr) {

        if(this.Existe_Media(Titre, Type)!=null) {

        
        boolean E=false;
        int i=0;
        switch(Type) {
            case 1 :
            while(E==false && i<this.M.size()) {
                if(this.M.get(i) instanceof Livre &&  this.M.get(i).Titre==Titre) {
                        this.M.get(i).Nbr_exp=Newnbr;
                        E=true;
                }
                i++;
            }
            
                
            break;
            case 2 :
            while(E==false && i<this.M.size()) {
                if(this.M.get(i) instanceof Memoire &&  this.M.get(i).Titre==Titre) {
                        this.M.get(i).Nbr_exp=Newnbr;
                        E=true;
                }
                i++;
            }
            break;
            case 3 :
            while(E==false && i<this.M.size()) {
                if(this.M.get(i) instanceof CD &&  this.M.get(i).Titre==Titre) {
                        this.M.get(i).Nbr_exp=Newnbr;
                        E=true;
                }
                i++;
            }
            break;
        }
        System.out.println("Media modifiee !");
    }
    else {
        System.out.println("Ce media n'existe pas !");
    }
        
    }

    public void MENU() {
        System.out.println("************MENU***************");
        System.out.println("1-Consulter la liste des media");
        System.out.println("2-Emprunter un media");
        System.out.println("3-Retourner un media");
        System.out.println("4-Modifier un media");
        System.out.println("5-Ajouter un media ");
        System.out.println("6-Supprimer  un media ");
        System.out.println("7-Consulter la liste des adherents");
        System.out.println("8-Modifier un adherent");
        System.out.println("9-Ajouter un adherent ");
        System.out.println("10-Supprimer  un adherent ");
        System.out.println("11-Consulter la liste des emprunts");
        System.out.println("12-Consulter la liste noire");
        System.out.println("13-EXIT");
        System.out.println("*******************************");
        
        
        
    }

}
