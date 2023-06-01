<<<<<<< HEAD
package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
=======
package OOPlab.lab2.Code.AimsProject;

>>>>>>> a19acefd7cc56ebce38ab47c9582307ac94885b2
import java.util.ArrayList;

public class Store {
    private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();

    public void getItems() {
        System.out.println("All items available in store now are:");
        for (DigitalVideoDisc dvd : itemsInStore) {
            System.out.println(dvd.toString());
        }
    }

    public void addDVD(DigitalVideoDisc dvd) {
        this.itemsInStore.add(dvd);
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        int index = this.itemsInStore.indexOf(dvd);
        this.itemsInStore.remove(index);
    }
}
