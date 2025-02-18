package oneToMany;

import common.utils.HibernateUtil;
import oneToMany.daos.CartDAO;
import oneToMany.daos.ItemDAO;
import oneToMany.entities.Cart;
import oneToMany.entities.Item;

import java.util.HashSet;
import java.util.Set;

public class OneToMany {
    public static void oneToMany() {
        CartDAO cartDAO = new CartDAO();
        ItemDAO itemDAO = new ItemDAO();

        // Create new students
        Cart cart1 = new Cart();
        cart1.setName("Regalo de cumpleaños");

        Item item = new Item();
        item.setName("Balón de baloncesto");

        Item item2 = new Item();
        item2.setName("Canasta");

        Set<Item> items = new HashSet<>();
        items.add(item); items.add(item2);

        cart1.addItems(items);

        cartDAO.saveCart(cart1);

        itemDAO.saveItem(item);
        itemDAO.saveItem(item2);

        // Shut down the SessionFactory
        HibernateUtil.shutdown();
    }
}
