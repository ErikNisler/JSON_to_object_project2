package projekt2.engeto.com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class StateList {

    private ArrayList<State> states = new ArrayList<>();

    static List<State> statesMax = new ArrayList<>();
    static List<State> statesMin = new ArrayList<>();

    public ArrayList<State> getStates() {
        return states;
    }

    public void setStates(ArrayList<State> states) {
        this.states = states;
    }

    public void addState(State state){
        states.add(state);
    }

    public void sort(){
        states.sort(Comparator.comparingDouble(State::getStandardRate));
    }

    public int size(){ return states.size();}

    public void firstThreeMins(){
        statesMin = states.subList(0,3);
        for (State s: statesMin){
            System.out.println(s.toString());
        }
    }

    public void firstThreeMaxes(){
        statesMax = states.subList(states.size()-3, states.size());
        for (State s: statesMax){
            System.out.println(s.toString());
        }
    }
    public static void saveIntoFile(String filename){
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            writer.println("MIN");
            for (State s: statesMin) {
                writer.println(s.toString());
            }
            writer.println("MAX");
            for (State s: statesMax){
                writer.println(s.toString());
            }
        }
        catch (IOException e) {
            System.err.println("Chyba při zápisu souboru: " + e.getLocalizedMessage());
        }

    }

}
