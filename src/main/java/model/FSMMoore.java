package model;

import java.util.ArrayList;

public class FSMMoore extends FSM{

    public FSMMoore() {
        super();
    }


    @Override
    public void minimize() {

    }

    @Override
    public void assessEquivalentsStates() {
        for (int i = 0; i < statesNumber; i++) {
            for (int j = 0; j < statesNumber; j++) {
                for (int k = 0; k < statesNumber; k++) {

                }
            }
        }
    }

    @Override
    void assignEdgesToGraph(){
        for (int i = 0; i < super.statesNumber; i++) {
            ArrayList<State> nextStates = states.get(i).getSuccessors();
            for (int j = 0; j < nextStates.size(); j++) {
                int position = graph.returnPosition(nextStates.get(j).getName());
                graph.setMatrixInput(i,position,states.get(i).getInputToSuccessors()[j]);
                graph.setMatrixAdjacency(i,position,1);
            }
        }
    }
}
