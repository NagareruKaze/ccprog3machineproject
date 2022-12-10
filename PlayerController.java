import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * This is the controller class for the MVC for the farming simulator game for MCO2.
 */

public class PlayerController {
	private Player playerModel;
	private int currentTileIndex;
	private PlayerView playerView;
	private File input;


	private Seed turnip;
    private Seed carrot;
    private Seed potato;
    private Seed rose;
    private Seed tulips;
    private Seed sunflower; 
    private Seed mango;
    private Seed apple;

    private Plow plow;
    private WateringCan wc;
    private Fertilizer f;
    private Pickaxe pickaxe;
    private Shovel shovel;

	public PlayerController(PlayerView view, Player player, File input) {
		playerView = view;
		this.playerModel = player;
		this.input = input;
		this.currentTileIndex = -1;

		turnip = new Seed("Turnip", 2,1,2,0,1,1,2,5,6,5);
        carrot = new Seed("Carrot",3,1,2,0,1,1,2,10,9,7.5);
        potato = new Seed("Potato",5,3,4,1,2,1,10,20,3,12.5);
        rose = new Seed("Rose",1,1,2,0,1,1,5,5,2.5);
        tulips = new Seed("Tulips",2,2,3,0,1,1,10,9,5);
        sunflower = new Seed("Sunflower",3,2,3,1,2,1,20,19,7.5);
        mango = new Seed("Mango",10,7,7,4,4,5,15,100,8,25);
        apple = new Seed("Apple", 10,7,7,5,5,10,15,100,8,25);

        // Tools
        plow = new Plow(0, 0.5);
        wc = new WateringCan(0, 0.5);
        f = new Fertilizer(10, 4);
        pickaxe = new Pickaxe(50, 15);
        shovel = new Shovel(7, 2);

		updateTextPrompt();
		updateActionButtons();
		updateButtonCosts();

		playerView.setTileButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//code here
				currentTileIndex = playerView.getTileButtonIndex(e.getSource());
				updateTextPrompt();
				updateActionButtons();
				checkGameState();
			}
		});

		playerView.setUsePickaxeButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//code here
				playerModel.useTool(pickaxe, playerModel.getTile(currentTileIndex));
				updateTextPrompt();
				updateTiles();
				updateActionButtons();
				checkGameState();
			}
		});

		playerView.setUsePlowButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//code here
				playerModel.useTool(plow, playerModel.getTile(currentTileIndex));
				updateTextPrompt();
				updateTiles();
				updateActionButtons();
				checkGameState();
			}
		});

		playerView.setUseWateringCanButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//code here
				playerModel.useTool(wc, playerModel.getTile(currentTileIndex));
				updateTextPrompt();
				updateTiles();
				updateActionButtons();
				checkGameState();
			}
		});

		playerView.setUseFertilizerButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//code here
				playerModel.useTool(f, playerModel.getTile(currentTileIndex));
				updateTextPrompt();
				updateTiles();
				updateActionButtons();
				checkGameState();
			}
		});

		playerView.setUseShovelButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//code here
				playerModel.useTool(shovel, playerModel.getTile(currentTileIndex));
				updateTextPrompt();
				updateTiles();
				updateActionButtons();
				checkGameState();
			}
		});

		playerView.setHarvestCropButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				playerModel.harvestCrop(playerModel.getTile(currentTileIndex));
				updateTiles();
				updateTextPrompt();
				updateActionButtons();
				checkGameState();
			}
		});

		playerView.setPlantTurnipButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//code here
				playerModel.plantSeed(playerModel.getTile(currentTileIndex), turnip);
				updateTiles();
				updateTextPrompt();
				updateActionButtons();
				checkGameState();
			}
		});

		playerView.setPlantCarrotButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//code here
				playerModel.plantSeed(playerModel.getTile(currentTileIndex), carrot);
				updateTiles();
				updateTextPrompt();
				updateActionButtons();
				checkGameState();
			}
		});

		playerView.setPlantPotatoButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//code here
				playerModel.plantSeed(playerModel.getTile(currentTileIndex), potato);
				updateTiles();
				updateTextPrompt();
				updateActionButtons();
				checkGameState();
			}
		});

		playerView.setPlantRoseButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//code here
				playerModel.plantSeed(playerModel.getTile(currentTileIndex), rose);
				updateTiles();
				updateTextPrompt();
				updateActionButtons();
				checkGameState();
			}
		});

		playerView.setPlantTulipsButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//code here
				playerModel.plantSeed(playerModel.getTile(currentTileIndex), tulips);
				updateTiles();
				updateTextPrompt();
				updateActionButtons();
				checkGameState();
			}
		});

		playerView.setPlantSunflowerButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//code here
				playerModel.plantSeed(playerModel.getTile(currentTileIndex), sunflower);
				updateTiles();
				updateTextPrompt();
				updateActionButtons();
				checkGameState();
			}
		});

		playerView.setPlantMangoButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//code here
				playerModel.plantSeed(playerModel.getTile(currentTileIndex), mango);
				updateTiles();
				updateTextPrompt();
				updateActionButtons();
				checkGameState();
			}
		});

		playerView.setPlantAppleButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//code here
				playerModel.plantSeed(playerModel.getTile(currentTileIndex), apple);
				updateTiles();
				updateTextPrompt();
				updateActionButtons();
				checkGameState();
			}
		});

		playerView.setRegisterButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//code here
				playerModel.register(playerModel);
				updateTiles();
				updateTextPrompt();
				updateActionButtons();
				updateButtonCosts();
				checkGameState();
			}
		});

		playerView.setAdvanceDayButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//code here
				playerModel.advanceDay();
				updateTiles();
				updateTextPrompt();
				updateActionButtons();
				checkGameState();
			}
		});

		playerView.setViewSeedToolInfoButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//code here
				String text = "";
				
				text += "SEEDS\n";
				text += "[1] Cost\n[2] Water Needs(Bonus Limit)\n[3] Fertilizer Needs(Bonus Limit)\n[4] Harvest Time\n[5] Products Produced\n[6] Base Selling Per Piece\n[7] Base Experience\n\n";
				
				text += "[Root Crops]\n";
				text += "Turnip   [1] 5   [2] 1(2)   [3] 0(1)   [4] 2 Days   [5] 1-2   [6] 6   [7] 5\n";
				text += "Carrot   [1] 10   [2] 1(2)   [3] 0(1)   [4] 3 Days   [5] 1-2   [6] 9   [7] 7.5\n";
				text += "Potato   [1] 20   [2] 3(4)   [3] 1(2)   [4] 5 Days   [5] 1-10   [6] 3   [7] 12.5\n\n";

				text += "[Flowers]\n";
				text += "Rose   [1] 5   [2] 1(2)   [3] 0(1)   [4] 1 Day   [5] 1   [6] 5   [7] 2.5\n";
				text += "Tulips   [1] 10   [2] 2(3)   [3] 0(1)   [4] 2 Days   [5] 1   [6] 9   [7] 5\n";
				text += "Sunflower   [1] 20   [2] 2(3)   [3] 1(2)   [4] 3 Days   [5] 1   [6] 19   [7] 7.5\n\n";

				text += "[Fruit Trees]\n";
				text += "Mango   [1] 100   [2] 7(7)  [3] 4(4)   [4] 10 Days   [5] 5-15   [6] 8   [7] 25\n";
				text += "Apple   [1] 100   [2] 7(7)   [3] 5(5)   [4] 10 Days   [5] 10-15   [6] 5   [7] 25\n\n";
			
				text += "TOOLS\n";
				text += "[1] Cost\n[2] Experience\n\n";
				text += "Pickaxe  [1] 50  [2] 15\n";
				text += "Plow  [1] 0  [2] 0.5\n";
				text += "Watering Can  [1] 0  [2] 0.5\n";
				text += "Fertilizer  [1] 10  [2] 4\n";
				text += "Shovel  [1] 7  [2] 2\n";
				
				playerView.popUpMessage("Seed Information", text);
			}
		});

		playerView.setViewRegisterInfoButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//code here
				String text = "";
				text += "[Registered Farmer]\n";
				text += "Level Requirement: 5\n";
				text += "Bonus Earnings per Produce: +1\n";
				text += "Seed Cost Reduction: -1\n";
				text += "Water Bonus Increase: 0\n";
				text += "Fertilizer Bonus Increase: 0\n";
				text += "Registration Fee: 200\n\n";

				text += "[Distinguished Farmer]\n";
				text += "Level Requirement: 10\n";
				text += "Bonus Earnings per Produce: +2\n";
				text += "Seed Cost Reduction: -2\n";
				text += "Water Bonus Increase: +1\n";
				text += "Fertilizer Bonus Increase: 0\n";
				text += "Registration Fee: 300\n\n";

				text += "[Legendary Farmer]\n";
				text += "Level Requirement: 15\n";
				text += "Bonus Earnings per Produce: +4\n";
				text += "Seed Cost Reduction: -3\n";
				text += "Water Bonus Increase: +2\n";
				text += "Fertilizer Bonus Increase: +1\n";
				text += "Registration Fee: 200\n\n";

				playerView.popUpMessage("Register Information", text);
			}
		});

		playerView.setStartNewGameButtonListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				//code here
				playerModel = new Player(input);
				playerView.enableAll();
				currentTileIndex = -1;
				updateTiles();
				updateTextPrompt();
				updateActionButtons();
			}
		});

		updateTiles();
	}



	public void updateTextPrompt() {

		String text = "";

		if(currentTileIndex != -1) {
			text += "[TILE " + (currentTileIndex + 1) + "]\n";

			if(this.playerModel.getTile(currentTileIndex).getCrop() != null) {
				text += this.playerModel.getTile(currentTileIndex).getCrop().getSeed().getName() + "\n";
				text += "Watered " + this.playerModel.getTile(currentTileIndex).getCrop().getWaterCount() + "/" + this.playerModel.getTile(currentTileIndex).getCrop().getSeed().getWaterNeeds() + " (" + (this.playerModel.getTile(currentTileIndex).getCrop().getSeed().getWaterBonus() + this.playerModel.getFarmerType().getWaterBonusIncrease()) + ") times\n";
				text += "Fertilized " + this.playerModel.getTile(currentTileIndex).getCrop().getFertilizerCount() + "/" + this.playerModel.getTile(currentTileIndex).getCrop().getSeed().getFertilizerNeeds() + " (" + (this.playerModel.getTile(currentTileIndex).getCrop().getSeed().getWaterBonus() + this.playerModel.getFarmerType().getWaterBonusIncrease()) + ") times\n";
			
				if(this.playerModel.getTile(currentTileIndex).getCrop().isReady() && this.playerModel.getCurrentDay() == this.playerModel.getTile(currentTileIndex).getCrop().getHarvestDay())
					text += "READY FOR HARVEST!!\n";
				else if(!this.playerModel.getTile(currentTileIndex).getCrop().getIsWithered() && this.playerModel.getCurrentDay() != this.playerModel.getTile(currentTileIndex).getCrop().getHarvestDay())
					text += (this.playerModel.getTile(currentTileIndex).getCrop().getHarvestDay() - this.playerModel.getCurrentDay())+ " days until harvest day...\n";
				else if(this.playerModel.getTile(currentTileIndex).getCrop().getIsWithered())
					text += "Crop has withered.\n";
			}

			text += "\n";
		}

		text += "DAY " + this.playerModel.getCurrentDay() + "\n[";

		text += "Level " + ((int) this.playerModel.getExperience() / 100) + " ";

		if(this.playerModel.getFarmerType() instanceof Farmer) {
			text += "Farmer";
		}
		else if(this.playerModel.getFarmerType() instanceof RegisteredFarmer) {
			text += "Registered Farmer";
		}
		else if(this.playerModel.getFarmerType() instanceof DistinguishedFarmer) {
			text += "Distinguished Farmer";
		}
		else if(this.playerModel.getFarmerType() instanceof LegendaryFarmer) {
			text += "Legendary Farmer";
		}

		text += "]\n" + "Objectcoins: " + String.format("%.2f",  this.playerModel.getObjectcoins()) + "\n" + "Experience: " + this.playerModel.getExperience() + "\n";

		boolean isHarvestDay = false;
		boolean cropsHaveWithered = false;

		for(int a = 0; a < 50; a++) {
			if(this.playerModel.getTile(a).getCrop() != null && this.playerModel.getTile(a).getCrop().isReady() && this.playerModel.getTile(a).getCrop().getHarvestDay() == this.playerModel.getCurrentDay())
				isHarvestDay = true;
			if(this.playerModel.getTile(a).getCrop() != null && this.playerModel.getTile(a).getCrop().getIsWithered())
				cropsHaveWithered = true;
		}

		if(isHarvestDay)
			text += "IT'S HARVEST DAY!!\n";

		if(cropsHaveWithered)
			text += "Oh no! Crops have withered...\n" ;


		playerView.setTextPrompt(text);
	}

	public void updateTiles() {

		String text;
		int color = 0;

		for(int a = 0; a < 50; a++){

			if(this.playerModel.getTile(a).getCrop() == null) {
				color = 0;
				if(this.playerModel.getTile(a).getHasRock()){
					text = "Rock";
					color = 1;
				}
				else {
					if(this.playerModel.getTile(a).getIsPlowed()){
						text = "Plowed";
						color = -1;
					}
					else {
						text = "Unplowed";
						color = 0;
					}
				}
			}
			else {
				text = this.playerModel.getTile(a).getCrop().getSeed().getName();

				if(this.playerModel.getTile(a).getCrop().getIsWithered()){
					text = "Withered";
					color = 4;
				}
				else {
					if(this.playerModel.getTile(a).getCrop().isReady() && this.playerModel.getTile(a).getCrop().getHarvestDay() == this.playerModel.getCurrentDay())
						color = 3; //ready to harvest - green
					else 
						color = 2;
				}
			}

			playerView.setTileButton(a, text, color);
		}
	}

	public void updateButtonCosts() {
		//update costs
		double pickaxe = this.pickaxe.getCost();
		double plow = this.plow.getCost();
		double wateringCan = this.wc.getCost();
		double fertilizer = this.f.getCost();
		double shovel = this.shovel.getCost();

		double turnip = this.turnip.getCost() - this.playerModel.getFarmerType().getSeedCostReduction();
		double carrot = this.carrot.getCost() - this.playerModel.getFarmerType().getSeedCostReduction();
		double potato = this.potato.getCost() - this.playerModel.getFarmerType().getSeedCostReduction();

		double rose = this.rose.getCost() - this.playerModel.getFarmerType().getSeedCostReduction();
		double tulips = this.tulips.getCost() - this.playerModel.getFarmerType().getSeedCostReduction();
		double sunflower = this.sunflower.getCost() - this.playerModel.getFarmerType().getSeedCostReduction();

		double mango = this.mango.getCost() - this.playerModel.getFarmerType().getSeedCostReduction();
		double apple = this.apple.getCost() - this.playerModel.getFarmerType().getSeedCostReduction();


		this.playerView.addButtonCosts(pickaxe, plow, wateringCan, fertilizer, shovel, turnip, carrot, potato, rose, tulips, sunflower, mango, apple);
	}

	//UPDATE
	public void updateActionButtons() {

		//tool buttons

		if(currentTileIndex != -1) {
			boolean pickaxe = this.playerModel.getTile(currentTileIndex).getHasRock() && !this.playerModel.getTile(currentTileIndex).getIsPlowed() && this.playerModel.getObjectcoins() >= 50;
			boolean plow = !this.playerModel.getTile(currentTileIndex).getHasRock() && !this.playerModel.getTile(currentTileIndex).getIsPlowed();
			boolean wateringCan = !this.playerModel.getTile(currentTileIndex).getHasRock() && !this.playerModel.getTile(currentTileIndex).getIsAvailable() && !this.playerModel.getTile(currentTileIndex).getCrop().getIsWithered();
			boolean fertilizer = wateringCan && this.playerModel.getObjectcoins() >= this.f.getCost();
			boolean shovel = this.playerModel.getObjectcoins() >= this.shovel.getCost();
			this.playerView.setToolButtons(pickaxe, plow, wateringCan, fertilizer, shovel);
		}
		else
			this.playerView.setToolButtons(false, false, false, false, false);


		//plant buttons
		if(currentTileIndex != -1) {
			boolean harvestCrop = this.playerModel.getTile(currentTileIndex).getCrop() != null && this.playerModel.getTile(currentTileIndex).getCrop().isReady() && this.playerModel.getCurrentDay() == this.playerModel.getTile(currentTileIndex).getCrop().getHarvestDay();

			boolean turnip = this.playerModel.getTile(currentTileIndex).canPlant(this.playerModel.getFarmLot(), this.turnip, currentTileIndex) && this.playerModel.getObjectcoins() >= (this.turnip.getCost() - this.playerModel.getFarmerType().getSeedCostReduction());
			boolean carrot = this.playerModel.getTile(currentTileIndex).getCrop() == null && this.playerModel.getTile(currentTileIndex).getIsPlowed() && this.playerModel.getObjectcoins() >= (this.carrot.getCost() - this.playerModel.getFarmerType().getSeedCostReduction());
			boolean potato = this.playerModel.getTile(currentTileIndex).getCrop() == null && this.playerModel.getTile(currentTileIndex).getIsPlowed() && this.playerModel.getObjectcoins() >= (this.potato.getCost() - this.playerModel.getFarmerType().getSeedCostReduction());

			boolean rose = this.playerModel.getTile(currentTileIndex).getCrop() == null && this.playerModel.getTile(currentTileIndex).getIsPlowed() && this.playerModel.getObjectcoins() >= (this.rose.getCost() - this.playerModel.getFarmerType().getSeedCostReduction());
			boolean tulips = this.playerModel.getTile(currentTileIndex).getCrop() == null && this.playerModel.getTile(currentTileIndex).getIsPlowed() && this.playerModel.getObjectcoins() >= (this.tulips.getCost() - this.playerModel.getFarmerType().getSeedCostReduction());
			boolean sunflower = this.playerModel.getTile(currentTileIndex).getCrop() == null && this.playerModel.getTile(currentTileIndex).getIsPlowed() && this.playerModel.getObjectcoins() >= (this.sunflower.getCost() - this.playerModel.getFarmerType().getSeedCostReduction());

			boolean mango = this.playerModel.getTile(currentTileIndex).canPlant(this.playerModel.getFarmLot(), this.mango, currentTileIndex) && this.playerModel.getObjectcoins() >= (this.mango.getCost() - this.playerModel.getFarmerType().getSeedCostReduction());
			boolean apple = this.playerModel.getTile(currentTileIndex).canPlant(this.playerModel.getFarmLot(), this.apple, currentTileIndex) && this.playerModel.getObjectcoins() >= (this.apple.getCost() - this.playerModel.getFarmerType().getSeedCostReduction());

			this.playerView.setPlantButtons(harvestCrop, turnip, carrot, potato, rose, tulips, sunflower, mango, apple);
		}
		else
			 this.playerView.setPlantButtons(false, false, false, false, false, false, false, false, false);


		//farm buttons

		boolean register = ((Registerable)this.playerModel.getFarmerType()).canRegister(this.playerModel);

		this.playerView.setFarmButtons(register);
	}

	public void checkGameState() {
		if(!this.playerModel.getIsRunning()) {
			this.playerView.disableAll();
			this.playerView.setTextPrompt("GAME OVER!");
			this.playerView.popUpMessage("Game Over", "Game Over! Please click on START NEW GAME if you wish to start a new game or exit the program. Thank you for playing!");
		}
	}

}