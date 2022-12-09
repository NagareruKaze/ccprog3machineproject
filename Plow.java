public class Plow extends Tool {
    public Plow(double cost, double experience) {
        super(cost, experience);
    }

    public boolean convert(Tile tile) {
        if(tile.plowTile() == true) {
            return true;
        }
        return false;
    }
}