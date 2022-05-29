public class Livre extends Media {
    String Author,Edition;
    public Livre(String Specialitee, String Titre, String Cote, int Nbr_exp,String Edition , String Author) {
        super(Specialitee, Titre, Cote, Nbr_exp);
        this.Author=Author;
        this.Edition=Edition;
       
        
 
    }
   
   
    
}
