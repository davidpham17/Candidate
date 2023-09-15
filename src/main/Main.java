package main;

import controller.CandidatesManager;
import model.Candidate;

public class Main {

    public static void main(String[] args) {
        Candidate candidate = new Candidate();

        new CandidatesManager(candidate).run();
    }
    
}
