public class CD extends Media {
    String Creator;
    public CD(String Specialitee, String Titre, String Cote, int Nbr_exp , String Creator) {
        super(Specialitee, Titre, Cote, Nbr_exp);
        this.Creator=Creator;
        
    }
    
}
