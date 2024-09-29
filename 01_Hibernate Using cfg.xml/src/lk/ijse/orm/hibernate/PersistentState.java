package lk.ijse.orm.hibernate;

import lk.ijse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.ArrayList;

public class PersistentState {

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

      int CusId= (int) session.save(customer);    // persistence state
        System.out.println("customer id :" + CusId);

        System.out.println(isExistsInSession(session,customer));
        session.close();
    }


    private static String isExistsInSession(Session session ,Customer customer){

        return session.contains(customer)
                ? "This object is in persistent state."
                : "This object is transient ." ;

    }
}
