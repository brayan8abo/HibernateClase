package  oneToOne;

import oneToOne.daos.UserDAO;
import oneToOne.entities.Address;
import oneToOne.entities.User;
import common.utils.*;

public class OneToOne {
    public static void oneToOne() {

        UserDAO userDAO = new UserDAO();

        Address calleDecepcion = new Address();
        calleDecepcion.setFullDescription("Calle de la decepción, 13");

        User user = new User(
                "NombreUsuario",
                (byte) 18,
                calleDecepcion
        );

        userDAO.saveUser(user);

        // Más operaciones ...

        // Cerramos la sesión que se abrió en el DAO
        HibernateUtil.shutdown();
    }

}
