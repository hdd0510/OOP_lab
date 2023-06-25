package hust.soict.dsai.test;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Phim con heo", "Animation", "Roger Allers", 87, 19.95f);
        store.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Co dau tam tuoi", "Sciene Fiction", "George Lucas", 87, 24.95f);
        store.addDVD(dvd2);

        store.getItems();

        System.out.println("After remove dvd1");
        store.removeDVD(dvd1);
        store.getItems();
    }
}
