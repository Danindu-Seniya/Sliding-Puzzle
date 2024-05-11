//Name: N.M.P.J.D.S.B. Nawarathna
//Student ID: w1999511 / 20221681

public class Node {
    int x, y;
    Node parent;
    int cost;
    String type;
    boolean visited;


    Node(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.visited = false;
    }

//    Getter methods for x, y, cost, type, parent

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCost() {
        return cost;
    }

    public String getType(){
        return this.type;
    }

    public Node getParent(){
        return this.parent;
    }

    public boolean getVisited(){return this.visited;}

    //     set cost


    public void setParent (Node parent) {
        this.parent = parent;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVisited(){
        this.visited = true;
    }
}

