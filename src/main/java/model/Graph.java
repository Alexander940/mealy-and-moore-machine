package model;

import java.util.Arrays;

public class Graph {

    // Sizes by default
    private String matrixInput[][];
    private String matrixOutput[][];
    private int matrixAdjacency[][];
    private int coordinatesX[];
    private int coordinatesY[];
    private Node nodesName[];
    private int numberNodes;

    public Graph() {}

    public Graph(final int numberNodes, int numberOfCharactersInputAlphabet, int numberOfCharactersOutputAlphabet) {
        this.matrixInput = new String[numberNodes][numberOfCharactersInputAlphabet];
        this.matrixOutput = new String[numberNodes][numberOfCharactersOutputAlphabet];
        this.matrixAdjacency = new int[numberNodes][numberNodes];
        this.coordinatesX = new int[numberNodes];
        this.coordinatesY = new int[numberNodes];
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

    public String getMatrixInput(int node1, int node2) {
        return matrixInput[node1][node2];
    }

    public void setMatrixInput(int node1, int node2, String input) {
        this.matrixInput[node1][node2] = input;
    }

    public String getMatrixOutput(int node1, int node2) {
        return matrixOutput[node1][node2];
    }

    public void setMatrixOutput(int node1, int node2, String output) {
        this.matrixOutput[node1][node2] = output;
    }

    public int getMatrixAdjacency(int node1, int node2) {
        return matrixAdjacency[node1][node2];
    }

    public void setMatrixAdjacency(int node1, int node2, int adjacency) {
        this.matrixAdjacency[node1][node2] = adjacency;
    }

    public int getCoordinatesX(int position) {
        return coordinatesX[position];
    }

    public void setCoordinatesX(int position, int coordinateX) {
        this.coordinatesX[position] = coordinateX;
    }

    public int getCoordinatesY(int position) {
        return coordinatesY[position];
    }

    public void setCoordinatesY(int position, int coordinateY) {
        this.coordinatesY[position] = coordinateY;
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
}
