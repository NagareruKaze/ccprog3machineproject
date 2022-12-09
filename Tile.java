public class Tile {
    private boolean hasRock;
    private boolean isAvailable;
    private boolean isPlowed;
    private Crop crop;

    public Tile() {
        this.hasRock = false;
        this.isAvailable = true;
        this.isPlowed = false;
        this.crop = null;
    }

    public boolean canPlant(Tile[] farmLot, Seed seed, int index) {
        boolean result = true;
        
        // Check if tile is not occupied
        if(this.isAvailable == true && this.isPlowed == true) {
            String name = seed.getName();
            
            // Seed is a Fruit Tree
            if(name.equalsIgnoreCase("Mango") || name.equalsIgnoreCase("Apple")) {
                result = false;

                // Check if tile is on the sides or corners
                if(((index + 1) >= 10) && (((index + 1) % 10) > 1) && ((index + 1)<= 41)) {
                    // Check if the tiles on the left and right of the tile are not occupied
                    if(farmLot[index - 1].getIsAvailable() == true && farmLot[index + 1].getIsAvailable() == true) {
                        result = true;
                        
                        // Check if tiles around it (above and below) are occupied
                        for(int i = 9; i <= 11; i++) {
                            if(farmLot[index - i].getIsAvailable() == false || farmLot[index + i].getIsAvailable() == false) {
                                result = false;
                                break;
                            }
                        }
                    }
                }
            }
        } else {
            result = false;
        }
        return result;
    }

    public void addRock() {
        this.hasRock = true;
        this.isAvailable = false;
    }

    public boolean removeRock() {
        if(this.hasRock == true) {
            this.hasRock = false;
            this.isAvailable = true;
            return true;
        }
        return false;
    }

    public boolean plowTile() {
        if(this.isAvailable == true && this.isPlowed == false && this.hasRock == false) {
            this.isPlowed = true;
            return true;
        }
        return false;
    }
    
    public void addSeed(Crop crop) {
        this.crop = crop;
        this.isAvailable = false;
    }

    public void removeCrop() {
        this.crop = null;
        this.isAvailable = true;
        this.isPlowed = false;
    }

    public Crop retrieveCrop(Tile tile) {
        Crop crop = null;
        if(this.crop != null) {
            if(this.crop.isReady() == true) {
                crop = this.crop;
                tile.removeCrop();
            } else {
                this.crop.wither();
            }
        }
        return crop;
    }
    
    public boolean getHasRock() {
        return this.hasRock;
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public boolean getIsPlowed() {
        return this.isPlowed;
    }

    public Crop getCrop() {
        return this.crop;
    }
}