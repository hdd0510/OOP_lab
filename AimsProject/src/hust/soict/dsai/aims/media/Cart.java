package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import hust.soict.dsai.aims.exception.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    private static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public boolean addMedia(Media medium) throws CartFullException {
        if (this.itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
            throw new CartFullException("The cart is full.");
        } else {
            boolean added = this.itemsOrdered.add(medium);
            if (added) {
                System.out.println(medium.getTitle() + " has been added to the cart.");
            }
            return added;
        }
    }

    public int getVolume() {
        return this.itemsOrdered.size();
    }

    public boolean removeMedia(Media media) throws NonExistingItemException {
        boolean removed = itemsOrdered.remove(media);
        if (removed) {
            System.out.println(media.getTitle() + " was removed from the cart.");
        } else {
            throw new NonExistingItemException(media.getTitle() + " is not in the cart.");
        }
        return removed;
    }

    public float totalCost() {
        float total = 0.0f;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public Media findById(int id) {
        for (Media item : itemsOrdered) {
            if (item != null) {
                if (item.getId() == id) {
                    return item;
                }
            }
        }
        System.out.println("No media id = " + id);
        return null;
    }

    public Media findByTitle(String title) {
        for (Media item : itemsOrdered) {
            if (item != null) {
                if (item.getTitle().toLowerCase().equals(title.toLowerCase())) {
                    return item;
                }
            }
        }
        System.out.println("No media names " + "\'" + title + "\'");
        return null;
    }

    // find is there any item that matches this word
    public void findByWord(String word) {
        int count = 0;
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(word.toLowerCase())) {
                System.out.println("Match an item: " + media.toString());
                count += 1;
            }
        }
        if (count == 0) {
            System.out.println("No item found.");
        }
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        String res = "";
        for (Media item : itemsOrdered) {
            if (item != null) {
                res += item.toString();
            }
        }
        res += String.format("Total cost: [%f] \n***************************************************",
                this.totalCost());
        System.out.println(res);
    }

    public void setToBeEmpty() {
        this.itemsOrdered.clear();
    }

    public void sortByTitle() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCost() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public List<Media> filterMediaById(int id) {
        List<Media> filteredMedia = new ArrayList<>();
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                filteredMedia.add(media);
            }
        }
        return filteredMedia;
    }

    public List<Media> filterMediaByTitle(String title) {
        List<Media> filteredMedia = new ArrayList<>();
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                filteredMedia.add(media);
            }
        }
        return filteredMedia;
    }

    public void printFilteredMedia(List<Media> filteredMedia) {
        if (filteredMedia.isEmpty()) {
            System.out.println("No media found.");
        } else {
            System.out.println("Filtered Media:");
            for (Media media : filteredMedia) {
                System.out.println(media);
            }
        }
    }

}
