package model;

import exceptions.NotExistentInputException;

import java.util.ArrayList;

public class FSMMoore extends FSM{

    public FSMMoore(ArrayList<State> states, int statesNumber, String [] outputAlphabet, String [] inputAlphabet, State sourceState) {
        super(states, statesNumber, outputAlphabet, inputAlphabet, sourceState);
    }

    @Override
    public FSM returnRelatedFSM(){
        ArrayList<State> relatedStates = doRelatedFSM();
        return new FSMMoore(relatedStates, relatedStates.size(), this.outputAlphabet, this.inputAlphabet, this.sourceState);
    }

    @Override
    public void minimize() {
        makeGraph();
        assignInputToOutputArray();
        assignTransitions();
        assessEquivalentsStates();
        assessSuccessors();
    }

    @Override
    public void assessEquivalentsStates() {
        int count = 0;
        ArrayList<MooreState> auxStates = (ArrayList<MooreState>) states.clone();

        while(auxStates.size()!=0){
            partitions.add(new ArrayList<>());
            if (auxStates.size() != 1) {
                for (int i = 1; i < auxStates.size(); i++) {
                    compareStates(0, i, count, auxStates);
                }
            }
            partitions.get(count).add(auxStates.get(0));
            auxStates.remove(0);
            count++;
        }
    }

    @Override
    void compareStates(int i, int j, int count, ArrayList<MooreState> auxStates) {
        boolean toggle = true;
        int positionState1 = this.graph.returnPosition(auxStates.get(i).getName());
        int positionState2 = this.graph.returnPosition(auxStates.get(j).getName());
        for (int k = 0; k < inputAlphabet.length; k++) {
            if(this.graph.getMatrixInputToOutput(positionState1, k) != null && this.graph.getMatrixInputToOutput(positionState2, k) != null){
                if(!this.graph.getMatrixInputToOutput(positionState1, k).equals(this.graph.getMatrixInputToOutput(positionState2, k))){
                    toggle = false;
                }
            } else if((this.graph.getMatrixInputToOutput(positionState1, k) == null && this.graph.getMatrixInputToOutput(positionState2, k) != null) || (this.graph.getMatrixInputToOutput(positionState1, k) != null && this.graph.getMatrixInputToOutput(positionState2, k) == null)){
                toggle = false;
            }
        }

        if (toggle) {
            partitions.get(count).add(auxStates.get(j));
            auxStates.remove(j);
        }
    }

    @Override
    void assessSuccessors() {
        int count = 0;
        ArrayList<ArrayList<State>> auxPartitions = clonePartition(partitions);
        for (int i = 0; i < auxPartitions.size(); i++) {
            int sizeToFor = auxPartitions.get(i).size();
            for (int j = 0; j < sizeToFor; j++) {
                this.second_partitions.add(new ArrayList<>());
                this.second_partitions.get(count).add(partitions.get(i).get(j));
                if(auxPartitions.get(i).size() != 1) {
                    for (int k = 1; k < auxPartitions.get(i).size(); k++) {
                        assessEachSuccessor(auxPartitions.get(i).get(j), auxPartitions.get(i).get(k), i, auxPartitions, j);
                    }
                    auxPartitions.get(i).remove(j);
                    count++;
                } else {
                    count++;
                    break;
                }
            }
        }
    }

    @Override
    void assessEachSuccessor(State first, State second, int a, ArrayList<ArrayList<State>> auxPartitions, int j) {
        boolean toggle = false;
        for (int k = 0; k < first.getSuccessors().size(); k++) {
            for (int i = 0; i < second.getSuccessors().size(); i++) {
                if(first.getSuccessors().get(k) == second.getSuccessors().get(i)){
                    toggle = true;
                }
            }
        }

        if(toggle){
            second_partitions.get(j).add(second);

        }
    }

    @Override
    void assignTransitions() {

    }

    @Override
    void assignInputToOutputArray(){
        for (int i = 0; i < statesNumber; i++) {
            for (int j = 0; j < states.get(i).getSuccessors().size(); j++) {
                try {
                    MooreState state = (MooreState) states.get(i).getSuccessors().get(j);
                    String output = state.getOutput();
                    int position = inputPosition(this.states.get(i).getInputToSuccessors()[j]);
                    this.graph.setMatrixInputToOutput(i, position, output);
                } catch (NotExistentInputException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    <T extends State> ArrayList<ArrayList<T>> clonePartition(ArrayList<ArrayList<T>> partition){
        ArrayList<ArrayList<T>> cloneStates = new ArrayList<>();

        for (int i = 0; i < partition.size(); i++) {
            cloneStates.add(new ArrayList<>());
            for (int j = 0; j < partition.get(i).size(); j++) {
                cloneStates.get(i).add(partition.get(i).get(j));
            }
        }

        return cloneStates;
    }
}
