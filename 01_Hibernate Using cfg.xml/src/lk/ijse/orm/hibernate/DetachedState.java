package lk.ijse.orm.hibernate;

import lk.ijse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DetachedState {

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

        int CusId= (int) session.save(customer);                // persistence state
        System.out.println("customer id :" + CusId);


        System.out.println(isExistsInSession(session,customer));   //persistence state
        session.close();

       Session detachedSession = SessionFactoryConfig
               .getInstance()
               .getSession();

        Transaction transaction=detachedSession
                .beginTransaction();

       detachedSession.detach(customer);                        //detached state

        System.out.println(isExistsInSession(detachedSession,customer));   //detached state

        customer.setAddress("matara");
        //detachedSession.save(customer); //save--> create a new record .
        detachedSession.merge(customer); //merge --> don't create duplication one and update .

        System.out.println(isExistsInSession(detachedSession,customer));

        transaction.commit();
        detachedSession.close();


    }
    private static String isExistsInSession(Session session ,Customer customer){

        return session.contains(customer)
                ? "This object is in persistent state."
                : "This object is detached state ." ;

    }
}
