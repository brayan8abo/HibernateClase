package oneToMany.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    // Resto de propiedades

    @OneToMany(mappedBy="cart")
    private Set<Item> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void addItems(Set<Item> items) {
        this.items = items;
        items.forEach(item -> item.setCart(this));
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }

}
