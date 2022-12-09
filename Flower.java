public class Flower extends Crop {
    public Flower(Seed seed, int currentDay) {
        super(seed, currentDay);
    }

    public double computeHarvestPrice(FarmerType farmerType, int productsProduced) {
        super.removeExcess(farmerType);
        double harvestTotal = super.getSeed().getProduceMin() * (super.getSeed().getSellPrice() + farmerType.getBonusEarnings());
        double waterBonus = harvestTotal * 0.2 * (super.getWaterCount() - 1);
        double fertilizerBonus = harvestTotal * 0.5 * super.getFertilizerCount();
        double finalHarvestPrice = harvestTotal + waterBonus + fertilizerBonus;

        return finalHarvestPrice * 1.1;
    }

}