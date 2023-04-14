package model;

import java.util.ArrayList;

public abstract class FSM {
    ArrayList<State> states;
    int statesNumber;
    ArrayList<String> outputAlphabet;
    ArrayList<String> inputAlphabet;
    State sourceState;
    Graph graph;
    ArrayList<ArrayList<State>> partitions;

    public abstract void minimize();

    public abstract void assessEquivalentsStates();

    public void doRelatedFSM(){
        makeGraph();
        ArrayList<State> statesRelated = new ArrayList<>();

        for (int i = 0; i < statesNumber; i++) {
            if(states.get(i) != sourceState){
                DFS dfs = new DFS(graph, sourceState.getName(), states.get(i).getName());

                if(dfs.dfsNodeToNode()){
                    statesRelated.add(states.get(i));
                }
            }
        }

        states = statesRelated;
    }

    private Graph makeGraph(){
        this.graph = new Graph(statesNumber, inputAlphabet.size(), outputAlphabet.size());
        assignEachStateToNode();
        assignEdgesToGraph();

        return null;
    }

    private void assignEachStateToNode(){

        for (int i = 0; i < states.size(); i++) {
            this.graph.setNameNodes(i, states.get(i).getName());
        }

    }

    abstract void assignEdgesToGraph();
}
