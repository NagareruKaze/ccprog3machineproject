public class Pickaxe extends Tool implements Removable {
    public Pickaxe(double cost, double experience) {
        super(cost, experience);
    }

    public boolean remove(Tile tile) {
        if(tile.removeRock() == true) {
            return true;
        }
        return false;
    }
}