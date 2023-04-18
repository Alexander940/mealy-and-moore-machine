package model;

import java.util.ArrayList;

public class MainModel {

    private static MainModel instance;

    /**
     * This method is about singleton pattern
     * @return the instance of the class
     */
    public static MainModel getInstance() {
        if(instance == null){
            instance = new MainModel();
        }
        return instance;
    }

    private FSM machine;

    public void createMealyMachine(ArrayList<State> states, int statesNumber, String [] outputAlphabet, String [] inputAlphabet, State sourceState){
        machine = new FSMMealy(states, statesNumber, outputAlphabet, inputAlphabet, sourceState);
    }

    public ArrayList<ArrayList<State>> minimize(){
        machine.minimize();
        return null;
    }

}
