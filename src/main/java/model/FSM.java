package model;

import exceptions.NotExistentInputException;

import java.util.ArrayList;

public abstract class FSM {
    ArrayList<? extends State> states;
    int statesNumber;
    String [] outputAlphabet;
    String [] inputAlphabet;
    State sourceState;
    Graph graph;
    ArrayList<ArrayList<State>> partitions;
    ArrayList<ArrayList<State>> second_partitions;

    public FSM(){}

    public FSM(ArrayList<State> states, int statesNumber, String [] outputAlphabet, String [] inputAlphabet, State sourceState) {
        this.states = states;
        this.statesNumber = statesNumber;
        this.outputAlphabet = outputAlphabet;
        this.inputAlphabet = inputAlphabet;
        this.sourceState = sourceState;
        this.partitions = new ArrayList<>();
        this.second_partitions = new ArrayList<>();
    }

    /**
     * This method calls the methods to do the graph and remove the don't related states
     */
    public ArrayList<State> doRelatedFSM(){
        makeGraph();
        ArrayList<State> statesRelated = new ArrayList<>();
        statesRelated.add(sourceState);

        for (int i = 0; i < statesNumber; i++) {
            if(states.get(i) != sourceState){
                DFS dfs = new DFS(graph, sourceState.getName(), states.get(i).getName());

                if(dfs.dfsNodeToNode()){
                    statesRelated.add(states.get(i));
                }
            }
        }

        return statesRelated;
    }


    /**
     * This method initialize the graph and calls the methods to assign its edges and nodes
     */
    void makeGraph(){
        this.graph = new Graph(statesNumber, inputAlphabet.length);
        assignEachStateToNode();
        assignEdgesToGraph();
    }

    /**
     * This method assign the names to the graph's array
     */
    void assignEachStateToNode(){

        for (int i = 0; i < states.size(); i++) {
            this.graph.setNameNodes(i, states.get(i).getName());
        }

    }

    /**
     * This method fills the matrix adjacency graph
     */
    void assignEdgesToGraph(){
        for (int i = 0; i < statesNumber; i++) {
            for (int j = 0; j < states.get(i).getSuccessors().size(); j++) {
                int position = this.graph.returnPosition(states.get(i).getSuccessors().get(j).getName());
                this.graph.setMatrixAdjacency(i, position, 1);
            }
        }
    }

    /*ArrayList<State> cloneStates(ArrayList<State> states){
        ArrayList<State> cloneStates = new ArrayList<>();

        for (int i = 0; i < states.size(); i++) {
            cloneStates.add(i, states.get(i));
        }

        return cloneStates;
    }*/

    abstract <T extends State> ArrayList<ArrayList<T>> clonePartition(ArrayList<ArrayList<T>> partition);

    int inputPosition(String input) throws NotExistentInputException {
        for (int i = 0; i < inputAlphabet.length; i++) {
            if(inputAlphabet[i].equals(input)){
                return i;
            }
        }

        throw new NotExistentInputException();
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public abstract FSM returnRelatedFSM();

    public abstract void minimize();

    abstract void assessEquivalentsStates();

    abstract void compareStates(int i, int j, int count, ArrayList<MooreState> auxStates);

    abstract void assessSuccessors();

    abstract void assessEachSuccessor(State first, State second, int a, ArrayList<ArrayList<State>> auxPartitions, int j);

    abstract void assignInputToOutputArray();

    abstract void assignTransitions();

    public ArrayList<ArrayList<State>> getPartitions() {
        return partitions;
    }

    public ArrayList<ArrayList<State>> getSecond_partitions() {
        return second_partitions;
    }
}
