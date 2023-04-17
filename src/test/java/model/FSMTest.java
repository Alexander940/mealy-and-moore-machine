package model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FSMTest {

    FSMMealy fsmMealy;
    FSMMoore fsmMoore;

    @Before
    public void setUp() throws Exception {
    }

    public void scene1(){
        ArrayList<State> states = new ArrayList<>();

        ArrayList<String> alphabet = new ArrayList<>();
        alphabet.add("0");
        alphabet.add("1");

        State stateA = new MealyState("A");
        State stateB = new MealyState("B");
        State stateC = new MealyState("C");

        ArrayList<State> successorsA = new ArrayList<>();
        successorsA.add(stateA);
        successorsA.add(stateC);

        ArrayList<State> successorsB = new ArrayList<>();
        successorsB.add(stateB);
        successorsB.add(stateC);

        ArrayList<State> successorsC = new ArrayList<>();
        successorsC.add(stateC);

        stateA.setSuccessors(successorsA);
        stateB.setSuccessors(successorsB);
        stateC.setSuccessors(successorsC);

        states.add(stateA);
        states.add(stateB);
        states.add(stateC);



        fsmMealy = new FSMMealy(states, states.size(), alphabet, alphabet, stateA);
    }

    @Test
    public void assign_the_edges_to_the_graph_preview_related_machine() {
        scene1();

        fsmMealy.setGraph(new Graph(3, 2, 2));

        fsmMealy.assignEachStateToNode();
        fsmMealy.assignEdgesToGraph();

        int [][] matrix = {{1,0,1},{0,1,1},{0,0,1}};

        assertEquals(matrix, fsmMealy.graph.getAllMatrixAdjacency());
    }

    @Test
    public void when_got_tree_states_and_remove_not_related_states() {
        scene1();

        fsmMealy.doRelatedFSM();

        assertEquals(2, fsmMealy.states.size());
    }
}