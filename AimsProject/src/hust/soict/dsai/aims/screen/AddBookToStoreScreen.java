package hust.soict.dsai.aims.screen;

import java.io.IOException;
import javax.swing.JFrame;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.dsai.aims.media.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

	public AddBookToStoreScreen(Store store, Cart cart) {
		super(store, cart);

		JFrame frame = this;

		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Add book to store");
		this.setVisible(true);
		Platform.runLater(new Runnable() {

			@Override
			public void run() {

				try {
					FXMLLoader loader = new FXMLLoader(
							getClass().getResource("/hust/soict/dsai/aims/screen/addBookToStore.fxml"));
					AddBookToStoreScreenController controller = new AddBookToStoreScreenController(store, cart, frame);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		});
	}

	public static void main(String[] args) {
		new AddBookToStoreScreen(new Store(), new Cart());
	}

}