import java.util.ArrayList;

public class Bibliothecaire {
    ArrayList <Media> M;
    ArrayList <Adherant> A;
    private ArrayList<Adherant> arrayList;

    public Bibliothecaire() {
       this.A= new  ArrayList();
       this.M= new  ArrayList();

    }

    public void Afficher_Media() {
        System.out.println("La liste des Media-s : ");
        for(int i =0 ; i<this.M.size();i++) {
           if(this.M.get(i) instanceof Livre) {
               
               Livre L = (Livre) this.M.get(i);
               System.out.println("\nMedia : "+i+" de type Livre : \n");
             System.out.println( " \nSpecialitee : "+L.Specialitee+" Titre "+L.Titre+" Cote : "+L.Cote+"  Nombre d'exemplaire "+L.Nbr_exp +" Edition : "+L.Edition+" Auteur : "+L.Author); 
           }
           else {
            System.out.println("\nMedia : "+i+" de type CD : \n");
               if(this.M.get(i) instanceof CD) {
               CD L = (CD) this.M.get(i);
               System.out.println(" \nSpecialitee : "+L.Specialitee+" Titre "+L.Titre+" Cote : "+L.Cote+"  Nombre d'exemplaire "+L.Nbr_exp +" Createur : "+L.Creator); 
               }
               else {
                   Memoire L =(Memoire) this.M.get(i);
                System.out.println("\nMedia : "+i+" de type Memoire : \n");
                System.out.println( " \nSpecialitee : "+L.Specialitee+" Titre "+L.Titre+" Cote : "+L.Cote+"  Nombre d'exemplaire "+L.Nbr_exp +" Auteur : "+L.Author); 
               }
           }
       
        }
       
        

    }
    public void Afficher_Adherent() {
        System.out.println("La liste des Adherents : ");
        System.out.println(this.A.toString());

    }

    public void Add_Media(Media M) {
       this.M.add(M);
    }
    public void Remove_Media(Media M) {
        this.M.remove(M);
    }

    public void Add_Adherant(Adherant A) {
       this.A.add(A);
    }
    public void Remove_Adherant(Adherant A ) {
        this.A.remove(A);
    }

    public Boolean Existe_Media(String Titre , int N) {
        Boolean E=false;
        int i=0;
        switch(N)  {
            case 1 : 
             i=0;
            while (i<this.M.size() && E==false) {
                if(this.M.get(i) instanceof Livre &&  this.M.get(i).Titre.compareTo(Titre)==0) {
                    E=true;
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
                }
                else {
                    i++;
                }
            }

            break;
        }

        
        return E;
    }

    public Boolean Existe_Adherent(int Mat) {
        Boolean E=false;
        int i=0;
        
            while (i<this.A.size() && E==false) {
                if(this.M.get(i) instanceof Livre &&  this.A.get(i).Matricule==Mat) {
                    E=true;
                }
                else {
                    i++;
                }
            }

            
           
        
        return E;
    }



}
