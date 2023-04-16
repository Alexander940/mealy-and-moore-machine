package model;

import java.util.ArrayList;

public class State {
    String name;
    ArrayList<State> successors;
    String [] inputToSuccessors;
    String[] outputToSuccessor;
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

    public String[] getOutputToSuccessor() {
        return outputToSuccessor;
    }

    public void setOutputToSuccessor(String[] outputToSuccessor) {
        this.outputToSuccessor = outputToSuccessor;
    }

    public State getPartitionState() {
        return partitionState;
    }

    public void setPartitionState(State partitionState) {
        this.partitionState = partitionState;
    }
}
