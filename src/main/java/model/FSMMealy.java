package model;

import java.util.ArrayList;

public class FSMMealy extends FSM{

    public FSMMealy() {
        super();
    }

    @Override
    public void minimize() {

    }

    @Override
    public void assessEquivalentsStates() {

    }

    @Override
    void assignEdgesToGraph() {
        for (int i = 0; i < super.statesNumber; i++) {
            ArrayList<State> nextStates = states.get(i).getSuccessors();
            for (int j = 0; j < nextStates.size(); j++) {
                int position = graph.returnPosition(nextStates.get(j).getName());
                graph.setMatrixInput(i,position,states.get(i).getInputToSuccessors()[j]);
                graph.setMatrixOutput(i, position, states.get(i).getOutputToSuccessor()[j]);
                graph.setMatrixAdjacency(i,position,1);
            }
        }
    }

}
