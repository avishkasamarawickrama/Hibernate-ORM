package lk.ijse.orm.hibernate;

import lk.ijse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RemovedState {

    public static void main(String[] args) {

       Session session= SessionFactoryConfig
               .getInstance()
               .getSession();

        Transaction transaction = session.beginTransaction();
     Customer customer=  session
             .get(Customer.class,1);                      //persistance state


        System.out.println(
                isExistsInSession(session,customer));
        session.delete(customer);                                   //removed state



        System.out.println(
                isExistsInSession(session,customer));


        transaction.commit();
        session.close();

    }


    private static String isExistsInSession(Session session ,Customer customer){

        return session.contains(customer)
                ? "This object is in persistent state."
                : "This object is removed state ." ;

    }
}
