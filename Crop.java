public abstract class Crop {
    private final Seed seed;
    private final int harvestDay;
    private int waterCount;
    private int fertilizerCount;
    private boolean isWithered;
    
    
    /**
     * This is the Crop class for the farming simulator game for MCO1.
     * <p>
     * Methods include crop actions in the game; removing excess water and fertilizer
     * from the crop, watering the crop, fertilizing the crop, withering the crop,
     * computing for its harvest price, checking if it is ready for harvest,
     * getting crop information, and getting the seed of the crop.
     */

    public Crop(Seed seed, int currentDay) {
        this.seed = seed;
        this.harvestDay = currentDay + seed.getHarvestTime();
        this.waterCount = 0;
        this.fertilizerCount = 0;
        this.isWithered = false;
    }

    /* 
     * Removes the excess water and fertilizer from the crop
     * based on the bonus limits.
     * 
     * @param farmerType    player's current farmer type
    */
    public void removeExcess(FarmerType farmerType) {
        // Get Limits (plus the farmer type bonuses)
        int waterLimit = this.seed.getWaterBonus() + farmerType.getWaterBonusIncrease();
        int fertilizerLimit = this.seed.getFertilizerBonus() + farmerType.getFertilizerBonusIncrease();

        // Bonus Limit capped
        if(this.waterCount > waterLimit) {
            this.waterCount = waterLimit;
        }

        // Bonus Limit capped
        if(this.fertilizerCount > fertilizerLimit) {
            this.fertilizerCount = fertilizerLimit;
        }
    }

    /* 
     * Increases the water count of the crop
    */
    public void water() {
        this.waterCount++;
    }

    /* 
     * Increases the fertilizer count of the crop
    */
    public void fertilize() {
        this.fertilizerCount++;
    }

    /* 
     * Withers the crop
    */
    public void wither() {
        this.isWithered = true;
    }

    /* 
     * Checks if the crop meets the conditions and is ready for harvest
     * 
     * @return true if crop is ready, otherwise false
    */
    public boolean isReady() {
        // Checks if the crop meets the conditions for harvest
        if(this.waterCount >= seed.getWaterNeeds() && this.fertilizerCount >= seed.getFertilizerNeeds() && this.isWithered == false) {
            return true;
        }
        return false;
    }

    public abstract double computeHarvestPrice(FarmerType farmerType, int productsProduced);

    public Seed getSeed() {
        return this.seed;
    }

    public int getHarvestDay() {
        return this.harvestDay;
    }

    public int getWaterCount() {
        return this.waterCount;
    }

    public int getFertilizerCount() {
        return this.fertilizerCount;
    }

    public boolean getIsWithered() {
        return this.isWithered;
    }
}