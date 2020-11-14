public class Plateau {

    private Position bottomLeft;
    private Position topRight;
    private Position topLeft;
    private Position bottomRight;

    public Plateau(Position topRight){
        this.topRight = topRight;
        this.bottomLeft = new Position(0,0);
        setPlateauCorners();
    }

    private void setPlateauCorners(){
        this.topLeft = new Position(0, topRight.getYCoordinate());
        this.bottomRight = new Position(topRight.getXCoordinate(),0);
    }

}
