package LastLab;

import javafx.stage.Stage;

public class MultiPlayer extends GameObject {
	Animations multi = new Animations();
	Stage stage = new Stage();

	public void play(Stage stage) {
		multi.start(stage);
		
	}
	
}
