<<<<<<< HEAD
package hust.soict.dsai.test;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.cart.Cart;
=======
package OOPlab.lab2.Code.AimsProject;
>>>>>>> a19acefd7cc56ebce38ab47c9582307ac94885b2

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sciene Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        cart.print();

        // test find by id
        System.out.println("The dvd with id 1 is: ");
        System.out.println(cart.findById(1).getTitle());

        // test find by title
        System.out.println("The dvd named The Lion King is: ");
        System.out.println(cart.findByTitle("The Lion King").getTitle());

    }
}
