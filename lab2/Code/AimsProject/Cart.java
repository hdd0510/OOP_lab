package OOPlab.lab2.AimsProject;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;

    public DigitalVideoDisc[] getItemsOrdered() {
        return this.itemsOrdered;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            this.itemsOrdered[qtyOrdered] = disc;
            this.qtyOrdered++;
            System.out.printf("the %s is added \n", disc.getTitle());
        } else {
            System.out.println("The cart is full");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int index = -1;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < qtyOrdered - 1; i++) {
                itemsOrdered[i] = itemsOrdered[i + 1];
            }
            qtyOrdered--;
            itemsOrdered[qtyOrdered] = null;
            System.out.printf("the %s is removed \n", disc.getTitle());
        } else {
            System.out.println("The disc is not found in the cart.");
        }
    }

    public float totalCost() {
        float total = 0.0f;
        for (DigitalVideoDisc disc : itemsOrdered) {
            if (disc == null) {
                continue;
            } else {
                total += disc.getCost();
            }
        }
        System.out.printf("The total cost is: ");
        return total;

    }
}