public class Shovel extends Tool implements Removable {
    public Shovel(double cost, double experience) {
        super(cost, experience);
    }
    
    public boolean remove(Tile tile) {
        if(tile.getIsAvailable() == false && tile.getHasRock() == false) {
            tile.removeCrop();
        }
        return true;
    }
}
