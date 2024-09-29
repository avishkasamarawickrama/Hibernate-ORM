package lk.ijse.orm.hibernate;

import lk.ijse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

import java.util.ArrayList;

public class TransientState {

    public static void main(String[] args) {
       Session session= SessionFactoryConfig
               .getInstance()
               .getSession();

       //Transient state

        Customer customer=new Customer(
                1,
                "saman",
                "galle",
                new ArrayList<>());


        System.out.println(isExistsInSession(session,customer));
    }

    private static String isExistsInSession(Session session ,Customer customer){

        return session.contains(customer)
                ? "This object is not transient."
                : "This object is transient " ;

    }
}
