public class RootCrop extends Crop implements Randomizable {
    public RootCrop(Seed seed, int currentDay) {
        super(seed, currentDay);
    }

    public int generateProduce() {
        int min = super.getSeed().getProduceMin();
        return (int)(Math.random()*(super.getSeed().getProduceMax()-min+1)+min);
    }

    public double computeHarvestPrice(FarmerType farmerType, int productsProduced) {
        super.removeExcess(farmerType);
        double harvestTotal = productsProduced * (super.getSeed().getSellPrice() + farmerType.getBonusEarnings());
        double waterBonus = harvestTotal * 0.2 * (super.getWaterCount() - 1);
        double fertilizerBonus = harvestTotal * 0.5 * super.getFertilizerCount();
        double finalHarvestPrice = harvestTotal + waterBonus + fertilizerBonus;

        return finalHarvestPrice;
    }
}