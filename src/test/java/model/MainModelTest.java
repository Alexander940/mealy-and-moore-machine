package model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class MainModelTest {
    MainModel mainModel;

    @Before
    public void setUp() throws Exception {
        mainModel = MainModel.getInstance();
    }

    @Test
    public void mealy_machine() {
        /*State stateA = new State("A");
        State stateB = new State("B");
        State stateC = new State("C");

        ArrayList<String> alphabet = new ArrayList<>();
        alphabet.add("0");
        alphabet.add("1");

        stateA.setInputToSuccessors(new String[]{"0", "1"});
        stateA.setOutputToSuccessors(new String[]{"0", "1"});

        stateB.setInputToSuccessors(new String[]{"0", "1"});
        stateB.setOutputToSuccessors(new String[]{"1", "0"});

        stateC.setInputToSuccessors(new String[]{"0", "1"});
        stateC.setOutputToSuccessors(new String[]{"0", "0"});

        ArrayList<State> successorsA = new ArrayList<>();
        successorsA.add(stateA);
        successorsA.add(stateC);

        ArrayList<State> successorsB = new ArrayList<>();
        successorsA.add(stateB);
        successorsA.add(stateC);

        ArrayList<State> successorsC = new ArrayList<>();
        successorsA.add(stateC);
        successorsA.add(stateC);

        stateA.setSuccessors(successorsA);
        stateB.setSuccessors(successorsB);
        stateC.setSuccessors(successorsC);

        ArrayList<State> states = new ArrayList<>();

        states.add(stateA);
        states.add(stateB);
        states.add(stateC);

        mainModel.createMachine(states, 3, alphabet, alphabet, stateA);
        System.out.println(mainModel.minimize().size());*/
    }
}