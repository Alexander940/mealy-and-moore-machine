package model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FSMMooreTest {

    FSMMoore fsmMoore;

    @Before
    public void setUp() throws Exception {

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
    public void when_got_five_states_and_remove_not_related_states_and_make_first_step() {
        scene2();

        FSMMoore relatedFSM = (FSMMoore) fsmMoore.returnRelatedFSM();

        relatedFSM.minimize();

        assertEquals(3, relatedFSM.getPartitions().size());
    }

    @Test
    public void realize_all_partitions() {
        scene2();

        FSMMoore relatedFSM = (FSMMoore) fsmMoore.returnRelatedFSM();

        relatedFSM.minimize();

        assertEquals(4, relatedFSM.getSecond_partitions().size());
    }
}