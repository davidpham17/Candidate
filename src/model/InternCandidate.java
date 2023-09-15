package model;

public class InternCandidate extends Candidate {
    private String majors, semester, universiryName;

    public InternCandidate() {
    }

    public InternCandidate(String id, String firstName, String lastName, int birthDate, String address, 
            String phone, String email, int typeCandidate, String majors, String semester, String universiryName) {
        super(id, firstName, lastName, birthDate, address, phone, email, typeCandidate);
        this.majors = majors;
        this.semester = semester;
        this.universiryName = universiryName;
    }

    public String getMajors() {
        return majors;
    }

    public String getSemester() {
        return semester;
    }

    public String getUniversiryName() {
        return universiryName;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setUniversiryName(String universiryName) {
        this.universiryName = universiryName;
    }
    
    
    
}
