public class WateringCan extends Tool implements Addable {
    public WateringCan(double cost, double experience) {
        super(cost, experience);
    }

    public boolean add(Crop crop) {
        if(crop != null) {
            crop.water();
            return true;
        }
        return false;
    }
}