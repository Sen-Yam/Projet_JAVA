import java.util.ArrayList;

public class Bibliothecaire {
    ArrayList <Media> M;
    ArrayList <Adherant> A;
    ArrayList <Emprunt> E;
    

    public Bibliothecaire() {
       this.A= new  ArrayList();
       this.M= new  ArrayList();
       this.E= new  ArrayList();

    }

    public void Afficher_Media() {
        System.out.println("La liste des Media-s : ");
        for(int i =0 ; i<this.M.size();i++) {
           if(this.M.get(i) instanceof Livre) {
               
               Livre L = (Livre) this.M.get(i);
               System.out.println("\nMedia "+i+" de type Livre : \n");
             System.out.println( " \nSpecialitee : "+L.Specialitee+" Titre "+L.Titre+" Cote : "+L.Cote+"  Nombre d'exemplaire "+L.Nbr_exp +" Edition : "+L.Edition+" Auteur : "+L.Author); 
           }
           else {
            System.out.println("\nMedia "+i+" de type CD : \n");
               if(this.M.get(i) instanceof CD) {
               CD L = (CD) this.M.get(i);
               System.out.println(" \nSpecialitee : "+L.Specialitee+" Titre "+L.Titre+" Cote : "+L.Cote+"  Nombre d'exemplaire "+L.Nbr_exp +" Createur : "+L.Creator); 
               }
               else {
                   Memoire L =(Memoire) this.M.get(i);
                System.out.println("\nMedia "+i+" de type Memoire : \n");
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
                        this.M.get(i).Exp_Emp++;
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
                        this.M.get(i).Exp_Emp++;
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
                        this.M.get(i).Exp_Emp++;
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
            this.M.remove(M);
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
        }
        else {
            System.out.println("Cet adherent n'existe pas !");
        }
        
    }

    public void Add_Emprunt(Emprunt E) {
         Media Z =  this.Existe_Media(E.Titre, E.Type); 
         if(this.Existe_Emprunt(E.Matricule, E.Titre, E.Type)==false) {  
        if(Z!=null && Z.Nbr_exp-Z.Exp_Emp>0) {
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
    public void Retour_Emprunt(Emprunt E) {
         boolean Z =  this.Existe_Emprunt(E.Matricule , E.Titre, E.Type); 
        if(Z==true) {
            this.E.remove(E);
            boolean A=false;
            int i=0;
           switch(E.Type) {
            case 1 : 
             i=0;
            while (i<this.M.size() && A==false) {
                if(this.M.get(i) instanceof Livre &&  this.M.get(i).Titre.compareTo(E.Titre)==0) {
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
                if(this.M.get(i) instanceof Memoire &&  this.M.get(i).Titre.compareTo(E.Titre)==0) {
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
                if(this.M.get(i) instanceof CD &&  this.M.get(i).Titre.compareTo(E.Titre)==0) {
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
    public Boolean Existe_Emprunt(int Mat , String Titre , int Type) {
        Boolean E=false;
        int i=0;
        
            while (i<this.E.size() && E==false) {
                if( this.E.get(i).Matricule==Mat && this.E.get(i).Titre==Titre && this.E.get(i).Type==Type ) {
                    E=true;
                }
                else {
                    i++;
                }
            }

            
           
        
        return E;
    }



}
