package model;

import java.util.ArrayList;

public abstract class State {
    String name;
    ArrayList<State> successors;
    String [] inputToSuccessors;
    State partitionState;

    public State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<State> getSuccessors() {
        return successors;
    }

    public void setSuccessors(ArrayList<State> successors) {
        this.successors = successors;
    }

    public String[] getInputToSuccessors() {
        return inputToSuccessors;
    }

    public void setInputToSuccessors(String[] inputToSuccessors) {
        this.inputToSuccessors = inputToSuccessors;
    }

    public State getPartitionState() {
        return partitionState;
    }

    public void setPartitionState(State partitionState) {
        this.partitionState = partitionState;
    }
}
