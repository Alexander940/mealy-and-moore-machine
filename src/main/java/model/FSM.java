package model;

import java.util.ArrayList;

public abstract class FSM {
    ArrayList<State> states;
    ArrayList<State> auxStates;
    int statesNumber;
    ArrayList<String> outputAlphabet;
    ArrayList<String> inputAlphabet;
    State sourceState;
    Graph graph;
    ArrayList<ArrayList<State>> partitions;
    ArrayList<ArrayList<State>> auxPartitions;

    public FSM(){}

    public FSM(ArrayList<State> states, int statesNumber, ArrayList<String> outputAlphabet, ArrayList<String> inputAlphabet, State sourceState) {
        this.states = states;
        this.statesNumber = statesNumber;
        this.outputAlphabet = outputAlphabet;
        this.inputAlphabet = inputAlphabet;
        this.sourceState = sourceState;
        this.auxStates = new ArrayList<>();
        this.partitions = new ArrayList<>();
        this.auxPartitions = new ArrayList<>();
    }

    public abstract void minimize();

    abstract void assessEquivalentsStates();

    abstract void compareStates(int i, int j, int count);

    abstract void assessSuccessors();

    abstract void assessEachSuccessor(State first, State second, int a);

    /**
     * This method calls the methods to do the graph and remove the don't related states
     */
    public void doRelatedFSM(){
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

        states = cloneStates(statesRelated);
        auxStates = cloneStates(statesRelated);
    }

    /**
     * This method initialize the graph and calls the methods to assign its edges and nodes
     */
    private void makeGraph(){
        this.graph = new Graph(statesNumber, inputAlphabet.size(), outputAlphabet.size());
        assignEachStateToNode();
        assignEdgesToGraph();
    }

    void assignEachStateToNode(){

        for (int i = 0; i < states.size(); i++) {
            this.graph.setNameNodes(i, states.get(i).getName());
        }

    }

    void assignEdgesToGraph(){
        for (int i = 0; i < statesNumber; i++) {
            for (int j = 0; j < states.get(i).getSuccessors().size(); j++) {
                int position = this.graph.returnPosition(states.get(i).getSuccessors().get(j).getName());
                this.graph.setMatrixAdjacency(i, position, 1);
            }
        }
    }

    abstract void assignInputAlphabet();

    abstract void assignOutputAlphabet();

    ArrayList<State> cloneStates(ArrayList<State> states){
        ArrayList<State> cloneStates = new ArrayList<>();

        for (int i = 0; i < states.size(); i++) {
            cloneStates.add(i, states.get(i));
        }

        return cloneStates;
    }

    public ArrayList<ArrayList<State>> getAuxPartitions() {
        return auxPartitions;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
}
