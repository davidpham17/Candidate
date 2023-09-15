
package common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import model.Candidate;

public class Library {
   
    private final Scanner sc = new Scanner(System.in);
    private final String PHONE_VALID = "^\\d{10}\\d*$";
    private final String EMAIL_VALID = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";
    
    public int inputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public String inputString(String name) {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    
    public boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Id exist!");
                return false;
            }
        }
        return true;
    }

    public String inputPhone(String name) {
        while (true) {
            String result = inputString(name).trim();
            if (result.matches(PHONE_VALID)) {
                return result;
            } else {
                System.err.println("Phone is number with minimum 10 characters");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public String inputEmail(String name) {
        while (true) {
            String result = inputString(name).trim();
            if (result.matches(EMAIL_VALID)) {
                return result;
            } else {
                System.err.println("Email with format <account name>@<domain>");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public int inputYear(String name, int min) {
        int number = 0;
        while (number <= min) {
            System.out.println("Enter " + name);
            number = sc.nextInt();
        }
        return number;
    }
    
    public String inputGraduationRank(String name) {
        while (true) {
            String result = inputString(name).trim();
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                System.err.println("Please input string: Excellence, Good, Fair, Poor");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public int inputExprience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        int yearExperience;
        while (true) {
            yearExperience = inputYear("year of experience:", 0);
            if (yearExperience > age) {
                System.err.println("Experience must be smaller than age");
            } else {
                break;
            }
        }
        return yearExperience;
    }
    
    public boolean inputYesNo(String name) {
        while (true) {
            String result = inputString(name).trim();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    
}
