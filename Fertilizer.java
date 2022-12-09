public class Fertilizer extends Tool implements Addable {
    public Fertilizer(double cost, double experience) {
        super(cost, experience);
    }

    public boolean add(Crop crop) {
        if(crop != null) {
            crop.fertilize();
            return true;
        }
        return false;
    }
}
