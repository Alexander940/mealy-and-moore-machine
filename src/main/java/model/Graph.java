package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Graph {

    private ArrayList<Map<String, String>> transitions[][];
    private String matrixInputToOutput[][];
    private int matrixAdjacency[][];
    private Node nodesName[];
    private int numberNodes;

    public Graph() {}

    public Graph(final int numberNodes, int numberOfCharactersInputAlphabet) {
        this.matrixInputToOutput = new String[numberNodes][numberOfCharactersInputAlphabet];
        this.matrixAdjacency = new int[numberNodes][numberNodes];
        this.nodesName = new Node[numberNodes];
        this.numberNodes = numberNodes;
    }

    public boolean checkIfNameAlreadyExist(String nameNode) {
        return Arrays.stream(this.nodesName).filter(name -> name != null && name.getName() != null && nameNode.equalsIgnoreCase(name.getName())).count() >= 1;
    }

    public int returnPosition(String nameNode) {
        for (int i = 0; i < this.nodesName.length; i++) {
            if (nodesName[i].getName().equalsIgnoreCase(nameNode)) {
                return i;
            }
        }
        return 0;
    }

    public String getMatrixInputToOutput(int node1, int node2) {
        return matrixInputToOutput[node1][node2];
    }

    public void setMatrixInputToOutput(int node1, int node2, String input) {
        this.matrixInputToOutput[node1][node2] = input;
    }

    public int getMatrixAdjacency(int node1, int node2) {
        return matrixAdjacency[node1][node2];
    }

    public void setMatrixAdjacency(int node1, int node2, int adjacency) {
        this.matrixAdjacency[node1][node2] = adjacency;
    }

    public String getNameNode(int position) {
        return nodesName[position].getName();
    }

    public void setNameNodes(int position, String nodeName) {
        Node node = new Node(nodeName);
        this.nodesName[position] = node;
    }

    public Node [] getNodes(){
        return nodesName;
    }

    public int getNumberNodes() {
        return numberNodes;
    }

    public int [][] getAllMatrixAdjacency(){
        return matrixAdjacency;
    }
}
