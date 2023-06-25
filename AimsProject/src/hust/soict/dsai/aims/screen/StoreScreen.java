package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.*;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart;

	public static void main(String[] args) throws Exception {
		// Test
		Store myStore = new Store();
		Cart myCart = new Cart();

		// Create DVDs
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		Track track1 = new Track("The Next Episode", 33);
		Track track2 = new Track("Brazzer", 21);
		Track track3 = new Track("I am Georgina");
		CompactDisc cd1 = new CompactDisc("Monkey", "Yes", "Smash Mouth", "Dunno", 120f);

		cd1.addTrack(track1);
		cd1.addTrack(track2);
		CompactDisc cd2 = new CompactDisc("Allstars", "Yes", "Smash Mouth", "Dunno", 230f);

		cd2.addTrack(track1);
		cd2.addTrack(track3);
		cd2.addTrack(track2);
		Book book1 = new Book("Sherlock Holmes", "Detective", 420, 5f);
		book1.addAuthor("Conan Doyle");
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Star Wars 2", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Star Wars 3", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Star Wars 4", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Star Wars 5", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Star Wars 6", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("Star Wars 7", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("Aladin2", "Animation", 18.99f);

		// Try adding DVDs
		// myStore.addMedia(dvd2, 5);
		myStore.addMedia(dvd2);
		myStore.addMedia(dvd1);
		myStore.addMedia(dvd3);
		myStore.addMedia(cd1);
		myStore.addMedia(cd2);
		myStore.addMedia(book1);
		myStore.addMedia(dvd4);
		myStore.addMedia(dvd5);
		myStore.addMedia(dvd6);
		myStore.addMedia(dvd7);
		myStore.addMedia(dvd8);
		myStore.addMedia(dvd9);
		myStore.addMedia(dvd10);
		new StoreScreen(myStore, myCart);
	}

	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);

		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}

	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");

		JMenu smUpdateStore = new JMenu("Update Store");
		smUpdateStore.add(new JMenuItem("Add Book"));
		smUpdateStore.add(new JMenuItem("Add CD"));
		smUpdateStore.add(new JMenuItem("Add DVD"));

		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View Store"));
		menu.add(new JMenuItem("View Cart"));

		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);

		return menuBar;
	}

	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);

		JButton cart = new JButton("View Cart");
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));

		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));

		return header;
	}

	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));

		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < 9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}

		return center;
	}
}
