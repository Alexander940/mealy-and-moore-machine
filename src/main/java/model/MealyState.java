package model;

import java.util.ArrayList;

public class MealyState extends State{

    private String [] outputsToSuccessors;
    private ArrayList<MealyState> successors;

    public MealyState(String name, int numberOfTransitions) {
        super(name, numberOfTransitions);
        this.outputsToSuccessors = new String[numberOfTransitions];
    }

    public void setEachPositionOutputsToSuccessors(int position, String output){
        this.outputsToSuccessors[position] = output;
    }

    @Override
    public ArrayList<? extends State> getSuccessors() {
        return successors;
    }

    @Override
    public void setSuccessors(ArrayList<? extends State> successors) {
        this.successors = (ArrayList<MealyState>) successors;
    }
}
