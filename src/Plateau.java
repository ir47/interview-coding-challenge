public class Plateau {


    private final Position bottomLeft;



    private final Position topRight;
    private Position topLeft;
    private Position bottomRight;

    public Plateau(Position topRight){
        this.topRight = topRight;
        this.bottomLeft = new Position(0,0);
        setPlateauCorners();
    }


    public Position getBottomLeft() {
        return bottomLeft;
    }

    public Position getTopRight() {
        return topRight;
    }

    public Position getTopLeft() {
        return topLeft;
    }

    public Position getBottomRight() {
        return bottomRight;
    }


    private void setPlateauCorners(){
        this.topLeft = new Position(0, topRight.getYCoordinate());
        this.bottomRight = new Position(topRight.getXCoordinate(),0);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Plateau p = (Plateau) obj;
        return p.getTopRight().equals(getBottomRight()) && p.getBottomLeft().equals(getBottomLeft());
    }

}
