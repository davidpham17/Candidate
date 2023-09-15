package controller;

import common.Library;
import java.util.ArrayList;
import java.util.Calendar;
import model.Candidate;
import model.ExperienceCandidate;
import model.FresherCandidate;
import model.InternCandidate;
import view.Menu;

public class CandidatesManager extends Menu<String>{
    static String[] mc = {"Experience", "Fresher", "Intern", "Searching" ,"Exit"};
    ArrayList<Candidate> candidates = new ArrayList<>();
    
    protected Library library;
    
    public CandidatesManager(Candidate candidate) {
        super("CANDIDATE MANAGERMENT SYSTEM", mc);
        library = new Library();
    }

    public void createCandidate(ArrayList<Candidate> candidates, int type) {
        while (true) {
            System.out.println("Enter ID:");
            String id = library.inputString("ID").trim();
            System.out.println("Enter first name:");
            String firstName = library.inputString("first name").trim();
            System.out.println("Enter last name:");
            String lastName = library.inputString("last name").trim();
            System.out.println("Enter birth date: ");
            int birthDate = library.inputIntLimit(1900,
                    Calendar.getInstance().get(Calendar.YEAR));
            System.out.println("Enter address:");
            String address = library.inputString("address").trim();
            System.out.println("Enter phone:");
            String phone = library.inputPhone("phone").trim();
            System.out.println("Enter email:");
            String email = library.inputEmail("email").trim();
            Candidate candidate = new Candidate(id, firstName, lastName, birthDate, address, phone, email, type);
            
            if (library.checkIdExist(candidates, id)) {
                switch (type) {
                    case 0:
                        createExperience(candidates, candidate);
                        break;
                    case 1:
                        createFresher(candidates, candidate);
                        break;
                    case 2:
                        createInternship(candidates, candidate);
                        break;
                }
            } else {
                return;
            }
            System.out.print("Do you want to create more candidate (Y/N): ");
            if (!library.inputYesNo("y/Y or n/N")) {
                return;
            }
        }
    }

    //allow user create experience
    public void createExperience(ArrayList<Candidate> candidates, Candidate candidate) {
        int yearExperience = library.inputExprience(candidate.getBirthDate());
        System.out.println("Enter professional skill: ");
        String professionalSkill = library.inputString("professional skill").trim();
        candidates.add(new ExperienceCandidate(candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate(), yearExperience, professionalSkill));
        System.err.println("Create success!");
    }

    //allow user create fresher
    public void createFresher(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.println("Enter graduation date:");
        String graduationDate = library.inputString("graduation date");
        System.out.println("Enter graduation rank (Excellence, Good, Fair, Poor):");
        String graduationRank = library.inputGraduationRank("graduation rank").trim();
        candidates.add(new FresherCandidate(candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate(), graduationDate, graduationRank));
        System.err.println("Create success.");
    }

    //allow user create internship
    public void createInternship(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.println("Enter major:");
        String major = library.inputString("majors");
        System.out.println("Enter semester:");
        String semester = library.inputString("semester");
        System.out.println("Enter university:");
        String university = library.inputString("university");
        candidates.add(new InternCandidate(candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate(), major, semester, university));
        System.err.println("Create success.");
    }

    //allow user search candidate by name
    public void searchCandidate(ArrayList<Candidate> candidates) {
        printListNameCandidate(candidates);
        System.out.println("Enter candidate name (First name or Last name)");
        String nameSearch = library.inputString("candidate name (First name or Last name)");
        System.out.print("Enter type of candidate: ");
        int typeCandidate = library.inputIntLimit(1, 3);
        int count = 0;
        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == typeCandidate
                    && candidate.getFirstName().contains(nameSearch)
                    || candidate.getLastName().contains(nameSearch)) {
                System.out.println(candidate.toString());
                count++;
            }
        }
        if (count == 0) System.out.println("Not Found!");
    }

    //display list name candidate
    public void printListNameCandidate(ArrayList<Candidate> candidates) {
        System.err.println("1. Experience Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof ExperienceCandidate) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.err.println("2. Fresher Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof FresherCandidate) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
        System.err.println("3. Intern Candidate");
        for (Candidate candidate : candidates) {
            if (candidate instanceof InternCandidate) {
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createCandidate(candidates, 0);
                break;
            case 2:
                createCandidate(candidates, 1);
                break;
            case 3:
                createCandidate(candidates, 2);
                break;
            case 4:
                searchCandidate(candidates);
                break;
            case 5:
                System.out.println("Exit the program successfully!");
                System.exit(0);
                break;
            default:
                System.out.println("Please re-enter!");
                break;
        }
    }
    
    

}