package hust.soict.dsai.test;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Phim con heo", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Co dau tam tuoi", "Sciene Fiction", "George Lucas", 87, 24.95f);
        store.addMedia(dvd2);

        store.getItems();

        System.out.println("After remove dvd1");
        store.removeMedia(dvd1);
        store.getItems();
    }
}
