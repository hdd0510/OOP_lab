package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void getItems() {
        System.out.println("All items available in store now are:");
        for (Media item : itemsInStore) {
            System.out.println(item.toString());
        }
    }

    public boolean addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println(media.getTitle() + " was added" + " to the cart.");
        return true;
    }

    public boolean removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println(media.getTitle() + " was removed" + " from the cart.");
            return true;
        } else {
            System.out.println("Item is not found in the cart.");
            return false;
        }
    }

    public Media findByTitle(String title) {
        for (Media item : itemsInStore) {
            if (item != null) {
                if (item.getTitle().toLowerCase().equals(title.toLowerCase())) {
                    return item;
                }
            }
        }
        System.out.println("No media names " + "\'" + title + "\'");
        return null;
    }

    public Media findById(int id) {
        for (Media item : itemsInStore) {
            if (item != null) {
                if (item.getId() == id) {
                    return item;
                }
            }
        }
        System.out.println("No media has id = " + id);
        return null;
    }

}
