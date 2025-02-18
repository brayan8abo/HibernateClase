import manyToMany.ManyToMany;
import oneToMany.OneToMany;
import oneToOne.OneToOne;
import singleEntity.SingleEntity;

public class HelloHibernateApp {
    public static void main(String[] args) {
        // Ejecutad estos métodos individualmente
        SingleEntity.singleEntity();
        OneToOne.oneToOne();
        OneToMany.oneToMany();
        ManyToMany.manyToMany();
    }
}
