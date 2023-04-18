package model;

import java.util.ArrayList;

public class FSMMealy extends FSM{

    public FSMMealy() {
        super();
    }

    public FSMMealy(ArrayList<State> states, int statesNumber, String [] outputAlphabet, String [] inputAlphabet, State sourceState) {
        super(states, statesNumber, outputAlphabet, inputAlphabet, sourceState);
    }

    @Override
    <T extends State> ArrayList<ArrayList<T>> clonePartition(ArrayList<ArrayList<T>> partition) {
        return null;
    }

    @Override
    public FSM returnRelatedFSM() {
        ArrayList<State> relatedStates = doRelatedFSM();
        return new FSMMealy(relatedStates, relatedStates.size(), this.outputAlphabet, this.inputAlphabet, this.sourceState);
    }

    @Override
    public void minimize() {
        assessEquivalentsStates();
        assessSuccessors();
    }

    @Override
    public void assessEquivalentsStates() {
        /*int count = 0;
        while(auxStates.size()!=0){
            partitions.add(new ArrayList<>());
            if(auxStates.size() == 1){
                partitions.get(count).add(auxStates.get(0));
                auxStates.remove(0);
            } else {
                for (int i = 1; i < auxStates.size(); i++) {
                    compareStates(0, i, count);
                }
                partitions.get(count).add(auxStates.get(0));
                auxStates.remove(0);
            }
            count++;
        }*/
    }

    @Override
    void compareStates(int i, int j, int count, ArrayList<MooreState> auxStates) {
        /*boolean toggle = true;
        for (int k = 0; k < statesNumber; k++) {
            if(!auxStates.get(i).getInputToSuccessors()[k].equals(auxStates.get(j).getInputToSuccessors()[k])){
                toggle = false;
            }
        }

        if (toggle) {
            partitions.get(count).add(auxStates.get(j));
            auxStates.remove(j);
        }*/
    }

    @Override
    void assessSuccessors() {
        /*for (int i = 0; i < partitions.size(); i++) {
            auxPartitions.add(new ArrayList<>());
            for (int j = 0; j < partitions.get(i).size(); j++) {
                for (int k = 0; k < partitions.get(i).size(); k++) {
                    assessEachSuccessor(partitions.get(i).get(j), partitions.get(i).get(k), i);
                }
            }
        }*/
    }

    @Override
    void assessEachSuccessor(State first, State second, int a, ArrayList<ArrayList<State>> auxPartitions, int j) {

    }

    @Override
    void assignInputToOutputArray() {
        for (int i = 0; i < statesNumber; i++) {

            for (int j = 0; j < inputAlphabet.length; j++) {

            }
        }
    }

    @Override
    void assignTransitions() {

    }
}
