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

        String [] alphabet = {"0", "1"};

        State stateA = new MealyState("A", 2);
        State stateB = new MealyState("B", 2);
        State stateC = new MealyState("C", 1);

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

    public void scene2(){
        ArrayList<State> states = new ArrayList<>();

        String [] alphabet = {"0", "1", "2"};

        State stateA = new MooreState("A", 2, "0");
        State stateB = new MooreState("B", 2, "1");
        State stateC = new MooreState("C", 1, "0");
        State stateD = new MooreState("D", 1, "1");
        State stateE = new MooreState("E", 1, "0");

        String [] inputToSuccessorsA = {"0", "1"};
        String [] inputToSuccessorsB = {"1", "0"};
        String [] inputToSuccessorsC = {"0"};
        String [] inputToSuccessorsD = {"1"};
        String [] inputToSuccessorsE = {"0"};

        stateA.setInputToSuccessors(inputToSuccessorsA);
        stateB.setInputToSuccessors(inputToSuccessorsB);
        stateC.setInputToSuccessors(inputToSuccessorsC);
        stateD.setInputToSuccessors(inputToSuccessorsD);
        stateE.setInputToSuccessors(inputToSuccessorsE);

        ArrayList<State> successorsA = new ArrayList<>();
        successorsA.add(stateB);
        successorsA.add(stateC);

        ArrayList<State> successorsB = new ArrayList<>();
        successorsB.add(stateA);
        successorsB.add(stateD);

        ArrayList<State> successorsC = new ArrayList<>();
        successorsC.add(stateB);

        ArrayList<State> successorsD = new ArrayList<>();
        successorsD.add(stateC);

        ArrayList<State> successorsE = new ArrayList<>();
        successorsE.add(stateD);

        stateA.setSuccessors(successorsA);
        stateB.setSuccessors(successorsB);
        stateC.setSuccessors(successorsC);
        stateD.setSuccessors(successorsD);
        stateE.setSuccessors(successorsE);

        states.add(stateA);
        states.add(stateB);
        states.add(stateC);
        states.add(stateD);
        states.add(stateE);

        fsmMoore = new FSMMoore(states, states.size(), alphabet, alphabet, stateA);

    }

    @Test
    public void assign_the_edges_to_the_graph_preview_related_machine() {
        scene1();

        fsmMealy.setGraph(new Graph(3, 2));

        fsmMealy.assignEachStateToNode();
        fsmMealy.assignEdgesToGraph();

        int [][] matrix = {{1,0,1},{0,1,1},{0,0,1}};

        assertEquals(matrix, fsmMealy.graph.getAllMatrixAdjacency());
    }

    @Test
    public void when_got_three_states_and_remove_not_related_states() {
        scene1();

        FSM relatedFSM = fsmMealy.returnRelatedFSM();

        assertEquals(2, relatedFSM.states.size());
    }

    @Test
    public void assign_the_edges_to_the_graph_preview_related_machine2() {
        scene2();

        fsmMealy.setGraph(new Graph(5, 3));

        fsmMealy.assignEachStateToNode();
        fsmMealy.assignEdgesToGraph();

        int[][] matrix = {{0,1,1,0,0},{1,0,0,1,0},{0,1,0,0,0},{0,0,1,0,0},{0,0,0,1,0}};

        assertEquals(matrix, fsmMealy.graph.getAllMatrixAdjacency());
    }

    @Test
    public void when_got_five_states_and_remove_not_related_states() {
        scene2();

        FSMMoore relatedFSM = (FSMMoore) fsmMoore.returnRelatedFSM();

        assertEquals(4, relatedFSM.states.size());
    }
}