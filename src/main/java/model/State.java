package model;

import java.util.ArrayList;

public abstract class State {
    String name;
    String [] inputToSuccessors;

    public State(String name, int inputToSuccessors) {
        this.name = name;
        this.inputToSuccessors = new String[inputToSuccessors];
    }

    public String getName() {
        return name;
    }

    public String[] getInputToSuccessors() {
        return inputToSuccessors;
    }

    public void setInputToSuccessors(String[] inputToSuccessors) {
        this.inputToSuccessors = inputToSuccessors;
    }

    public abstract ArrayList<? extends State> getSuccessors();

    public abstract void setSuccessors(ArrayList<? extends State> successors);
}
