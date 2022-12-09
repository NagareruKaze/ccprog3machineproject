import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Player {
    private FarmerType farmerType;
    private double Objectcoins;
    private double experience;

    private Tile[] farmLot;
    private boolean isRunning;
    private int currentDay;

    public Player(File input) {
        this.Objectcoins = 100;
        this.farmerType = new Farmer("Farmer", 0, 0, 0, 0, 0);
        this.experience = 0;

        this.farmLot = new Tile[50];

        for(int i = 0; i < 50; i++) {
            this.farmLot[i] = new Tile();
        }

        try {
            scatterRocks(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.isRunning = true;
        this.currentDay = 1;
    }

    public void scatterRocks(File input) throws FileNotFoundException {
        Scanner myReader = new Scanner(input);

        while(myReader.hasNextInt()) {
            this.farmLot[myReader.nextInt() - 1].addRock();
        }

        myReader.close();
    }

    public void addExperience(double experience) {
        this.experience += experience;
    }

    public void advanceDay() {
        int growingCrop = 0;
        int witheredCrop = 0;

        this.currentDay++; // Advance the day

        // Check status of each tile in the Farm
        for(Tile tile : this.farmLot) {
            if(tile.getCrop() != null) {
                growingCrop++;

                // Withers on Harvest Day if not met requirements and after Harvest Day if forgot to Harvest
                if((tile.getCrop().isReady() == false && tile.getCrop().getHarvestDay() == this.currentDay) || tile.getCrop().getHarvestDay() == this.currentDay - 1) {
                    tile.getCrop().wither();
                }

                // Get Total Number of Withered Crops
                if(tile.getCrop().getIsWithered() == true) {
                    witheredCrop++;
                }
            }
        }

        // No growing crops or All crops in farm are Withered
        if(growingCrop == 0 || witheredCrop == 50) {
            this.isRunning = false;
        }

        // Cannot buy any seeds
        if(this.Objectcoins < (5 - this.farmerType.getSeedCostReduction())) {
            // All growing crops are withered
            if(growingCrop == witheredCrop) {
                this.isRunning = false;
            }
        }
    }

    public void removeObjectcoins(double Objectcoins) {
        this.Objectcoins -= Objectcoins;
    }

    public void register(Player player) {
        if(this.farmerType instanceof Registerable) {
           if(((Registerable) this.farmerType).canRegister(player)) {
                ((Registerable) this.farmerType).upgrade(player);
           }
        }
    }

    public void useTool(Tool tool, Tile tile) {
        double price = tool.getCost();
        boolean result;

        if(this.Objectcoins >= price) {
            if(tool instanceof Addable) {
                result = ((Addable) tool).add(tile.getCrop());
            } else if (tool instanceof Removable) {
                result = ((Removable) tool).remove(tile);
            } else {
                result = ((Plow) tool).convert(tile);
            }
            
            // Tool was successfully used
            if(result == true) {
                this.Objectcoins -= price;
                addExperience(tool.getExperience());
            }
        }
    }

    public int findTileIndex(Tile tile) {
        for(int i = 0; i < 50; i++) {
            if(this.farmLot[i].equals(tile)) {
                return i;
            }
        }
        return -1;
    }

    public void plantSeed(Tile tile, Seed seed) {
        double price = seed.getCost() - this.farmerType.getSeedCostReduction();
        int index = findTileIndex(tile);

        // Check if seed can be planted on tile
        if(tile.canPlant(this.farmLot, seed, index) == true && this.Objectcoins >= price) {
            this.Objectcoins -= price; // Buys Seed
            String name = seed.getName();

            // Plants seed on tile
            if(name.equalsIgnoreCase("Mango") || name.equalsIgnoreCase("Apple")) {
                tile.addSeed(new FruitTree(seed, this.currentDay));
            } else if(name.equalsIgnoreCase("Turnip") || name.equalsIgnoreCase("Carrot") || name.equalsIgnoreCase("Potato")) {
                tile.addSeed(new RootCrop(seed, this.currentDay));
            } else {
                tile.addSeed(new Flower(seed, this.currentDay)); 
            }
        }
    }

    public void harvestCrop(Tile tile) {
        Crop crop = tile.retrieveCrop(tile);

        // Crop is successfully harvested and removed from tile
        if(crop != null) {
            int productsProduced = crop.getSeed().getProduceMin();
            if(crop instanceof Randomizable) {
                productsProduced = ((Randomizable) crop).generateProduce();
            }
            this.Objectcoins += crop.computeHarvestPrice(this.farmerType, productsProduced);
        }
    }
    
    public FarmerType getFarmerType() {
        return this.farmerType;
    }

    public void setFarmerType(FarmerType farmerType) {
        this.farmerType = farmerType;
    }
    
    public double getObjectcoins() {
        return this.Objectcoins;
    }

    public double getExperience() {
        return this.experience;
    }

    public Tile[] getFarmLot() {
        return this.farmLot;
    }

    public Tile getTile(int index) {
        return this.farmLot[index];
    }
    
    public boolean getIsRunning() {
        return this.isRunning;
    }

    public int getCurrentDay() {
        return this.currentDay;
    }
}
