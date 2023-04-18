package model;

import java.util.ArrayList;
import java.util.RandomAccess;

public class MooreState extends State{

    private String output;
    private ArrayList<MooreState> successors;

    public MooreState(String name, int inputToSuccessors, String output) {
        super(name, inputToSuccessors);
        this.output = output;
    }

    public String getOutput() {
        return output;
    }

    @Override
    public ArrayList<? extends State> getSuccessors() {
        return this.successors;
    }

    @Override
    public void setSuccessors(ArrayList<? extends State> successors) {
        this.successors = (ArrayList<MooreState>) successors;
    }
}
