package hust.soict.dsai.aims.Aims;

import hust.soict.dsai.aims.media.*;

import java.util.List;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        Track track1 = new Track("Bruh1", 13);
        Track track2 = new Track("Bruh2", 21);
        CompactDisc cd1 = new CompactDisc("Allstars", "Smash Mouth", "Dunno", 69.420f);
        cd1.addTrack(track1);
        cd1.addTrack(track2);
        Book book1 = new Book("Sherlock Holmes", "Detective", 420, 5f);
        book1.addAuthor("Conan Doyle");
        book1.addAuthor("JK Rolling");
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(cd1);
        store.addMedia(book1);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    displayStore(scanner);
                    break;
                case 2:
                    updateStore(scanner);
                    break;
                case 3:
                    seeCurrentCart(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("The action is not valid. Try once again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void displayStore(Scanner scanner) {
        store.getItems();
        storeMenu(scanner);
    }

    public static void storeMenu(Scanner scanner) {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                displayMediaDetails(scanner);
                break;
            case 2:
                addMediaToCart(scanner);
                break;
            case 3:
                playMedia(scanner);
                break;
            case 4:
                seeCurrentCart(scanner);
                break;
            case 0:
                break;
            default:
                System.out.println("The action is not valid. Try once again.");
                storeMenu(scanner);
                break;
        }
    }

    public static void displayMediaDetails(Scanner scanner) {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        Media media = store.findByTitle(title);
        if (media != null) {
            System.out.println(media);
            displayMediaOptionsMenu(scanner, media);
        } else {
            System.out.println("Media not found.");
            storeMenu(scanner);
        }
    }

    public static void displayMediaOptionsMenu(Scanner scanner, Media media) {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");

        if (media instanceof DigitalVideoDisc || media instanceof CompactDisc) {
            System.out.println("2. Play");
        }

        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                cart.addMedia(media);
                System.out.println("Media added to cart.");
                storeMenu(scanner);
                break;
            case 2:
                if (media instanceof DigitalVideoDisc) {
                    DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                    dvd.play();
                } else if (media instanceof CompactDisc) {
                    CompactDisc cd = (CompactDisc) media;
                    cd.play();
                }
                displayMediaOptionsMenu(scanner, media);
                break;
            case 0:
                storeMenu(scanner);
                break;
            default:
                System.out.println("The action is not valid. Try once again.");
                displayMediaOptionsMenu(scanner, media);
                break;
        }
    }

    public static void addMediaToCart(Scanner scanner) {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        Media media = store.findByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to cart.");
            System.out.println("Number of Media in cart: " + cart.getVolume());
        } else {
            System.out.println("Media not found.");
        }
        storeMenu(scanner);
    }

    public static void playMedia(Scanner scanner) {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        Media media = store.findByTitle(title);
        if (media != null) {
            if (media instanceof DigitalVideoDisc) {
                DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                dvd.play();
            } else if (media instanceof CompactDisc) {
                CompactDisc cd = (CompactDisc) media;
                cd.play();
            }
        } else {
            System.out.println("Media not found.");
        }
        storeMenu(scanner);
    }

    public static void updateStore(Scanner scanner) {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to the store");
        System.out.println("2. Remove a media from the store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                addMediaToStore(scanner);
                break;
            case 2:
                removeMediaFromStore(scanner);
                break;
            case 0:
                break;
            default:
                System.out.println("The action is not valid. Try once again.");
                updateStore(scanner);
                break;
        }
    }

    public static void addMediaToStore(Scanner scanner) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a new CD to the store");
        System.out.println("2. Add a new DVD to the store");
        System.out.println("3. Add a new book to the store");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 0:
                break;

            case 1:
                System.out.println("Please enter the information of the new CD");
                System.out.println("Title: ");
                String title1 = scanner.nextLine();
                System.out.println("Category: ");
                String category1 = scanner.nextLine();
                System.out.println("Artist: ");
                String artist = scanner.nextLine();
                System.out.println("Director: ");
                String director1 = scanner.nextLine();
                System.out.println("Cost: ");
                float cost1 = Float.parseFloat(scanner.nextLine());
                store.addMedia(new CompactDisc(title1, category1, artist, director1, cost1));
                System.out.println("CD added. Enter any key to continue");
                scanner.nextLine();
                updateStore(scanner);

            case 2:
                System.out.println("Please enter the information of the new DVD");
                System.out.println("Title: ");
                String title2 = scanner.nextLine();
                System.out.println("Category: ");
                String category2 = scanner.nextLine();
                System.out.println("Director: ");
                String director2 = scanner.nextLine();
                System.out.println("Length: ");
                int length2 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Price: ");
                float cost2 = Float.parseFloat(scanner.nextLine());
                store.addMedia(new DigitalVideoDisc(title2, category2, director2, length2, cost2));
                System.out.println("DVD added. Enter any key to continue");
                scanner.nextLine();
                updateStore(scanner);

            case 3:
                System.out.println("Please enter the information of the new book");
                System.out.println("Title: ");
                String title3 = scanner.nextLine();
                System.out.println("Category: ");
                String category3 = scanner.nextLine();
                System.out.println("Number of pages: ");
                int length3 = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Price: ");
                float price = Float.parseFloat(scanner.nextLine());
                store.addMedia(new Book(title3, category3, length3, price));
                System.out.println("Book added. Enter any key to continue");
                scanner.nextLine();
                updateStore(scanner);

            default:
                System.out.println("The action is not valid. Try once again.");
                updateStore(scanner);
                break;
        }
    }

    public static void removeMediaFromStore(Scanner scanner) {
        System.out.println("Please enter the title of the media you want to remove: ");
        String title = scanner.nextLine();
        Media media = store.findByTitle(title);

        while (media == null) {
            System.out.println("Please enter a valid product name.");
            title = scanner.nextLine();
            media = store.findByTitle(title);
        }
        store.removeMedia(media);
        System.out.println("Enter any key to continue");
        scanner.nextLine();
        updateStore(scanner);
    }

    public static void seeCurrentCart(Scanner scanner) {
        System.out.println("Current Cart:");
        cart.print();
        cartMenu(scanner);
    }

    public static void cartMenu(Scanner scanner) {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                filterMediasInCart(scanner);
                break;
            case 2:
                sortMediasInCart(scanner);
                break;
            case 3:
                removeMediaFromCart(scanner);
                break;
            case 4:
                playMediaFromCart(scanner);
                break;
            case 5:
                placeOrder(scanner);
                break;
            case 0:
                storeMenu(scanner);
                break;
            default:
                System.out.println("The action is not valid. Try once again.");
                cartMenu(scanner);
                break;
        }
    }

    public static void filterMediasInCart(Scanner scanner) {
        System.out.println("Filter Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                System.out.println("Enter the ID to filter by:");
                int filterId = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                List<Media> filteredById = cart.filterMediaById(filterId);
                cart.printFilteredMedia(filteredById);
                break;
            case 2:
                System.out.println("Enter the title to filter by:");
                String filterTitle = scanner.nextLine();
                List<Media> filteredByTitle = cart.filterMediaByTitle(filterTitle);
                cart.printFilteredMedia(filteredByTitle);
                break;
            case 0:
                cartMenu(scanner);
                break;
            default:
                System.out.println("The action is not valid. Try once again.");
                filterMediasInCart(scanner);
                break;
        }
    }

    public static void sortMediasInCart(Scanner scanner) {
        System.out.println("Sort Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                cart.sortByTitle();
                break;
            case 2:
                cart.sortByCost();
                break;
            case 0:
                cartMenu(scanner);
                break;
            default:
                System.out.println("The action is not valid. Try once again.");
                sortMediasInCart(scanner);
                break;
        }
    }

    public static void removeMediaFromCart(Scanner scanner) {
        System.out.println("Enter the title of the media to remove:");
        String title = scanner.nextLine();

        Media media = cart.findByTitle(title);
        boolean removed = cart.removeMedia(media);
        if (removed) {
            System.out.println("Media removed from cart.");
        } else {
            System.out.println("Media not found in cart.");
        }
        cartMenu(scanner);
    }

    public static void playMediaFromCart(Scanner scanner) {
        System.out.println("Enter the title of the media to play:");
        String title = scanner.nextLine();

        Media media = cart.findByTitle(title);
        if (media != null) {
            if (media instanceof DigitalVideoDisc) {
                DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                dvd.play();
            } else if (media instanceof CompactDisc) {
                CompactDisc cd = (CompactDisc) media;
                cd.play();
            }
        } else {
            System.out.println("Media not found in cart.");
        }
        cartMenu(scanner);
    }

    public static void placeOrder(Scanner scanner) {
        if (cart.getVolume() == 0) {
            System.out.println("The cart is empty, you must add items to cart!");
            cartMenu(scanner);
        } else {
            cart = new Cart();
            System.out.println("Your order has been placed!");
            showMenu();
        }
    }

}
