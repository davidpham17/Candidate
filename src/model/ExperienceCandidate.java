package model;

public class ExperienceCandidate extends Candidate{
    private int expInYear;
    private String proSkill;

    public ExperienceCandidate() {
        super();
    }
    
    public ExperienceCandidate(String id, String firstName, String lastName, int birthDate, 
            String address, String phone, String email, int typeCandidate, int expInYear, String proSkill) {
        super(id, firstName, lastName, birthDate, address, phone, email, typeCandidate);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
    
    
}
