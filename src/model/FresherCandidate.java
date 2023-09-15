package model;

public class FresherCandidate extends Candidate {
    private String graduationDate, graduationRank;

    public FresherCandidate() {
        super();
    }

    public FresherCandidate(String graduationDate, String graduationRank) {
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
    }

    public FresherCandidate(String id, String firstName, String lastName, int birthDate, 
            String address, String phone, String email, int typeCandidate, String graduationDate, String graduationRank) {
        super(id, firstName, lastName, birthDate, address, phone, email, typeCandidate);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }
    
    
    
}
