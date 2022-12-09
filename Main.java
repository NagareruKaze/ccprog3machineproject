import java.io.File;

public class Main {
	public static void main(String[] args) {
		PlayerView playerView = new PlayerView();

        File input = new File("rocks.txt");
        Player player = new Player(input);

        PlayerController playerController = new PlayerController(playerView, player, input);
	}
}