package lk.ijse.orm.hibernate;

import lk.ijse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.temporal.ChronoUnit;

public class EagerVsLazy {
    public static void main(String[] args) {
        Customer customer=new Customer();
        customer.setName("kamal");
        customer.setAddress("galle");
      Session savesession= SessionFactoryConfig
              .getInstance()
              .getSession();

        Transaction transaction = savesession.beginTransaction();

        savesession.save(customer);
        transaction.commit();
      savesession.close();

      //1.Get Methood -

       Session getSession= SessionFactoryConfig
                .getInstance()
                .getSession();

        System.out.println("-------------------------------------Calling Get Method --------------------------------------------------");

       Customer get = getSession.get(Customer.class,1);
        System.out.println("Customer id of GET :" + get.getId());
        System.out.println("Customer name of GET :" + get.getName());

        getSession.close();

        //2.Load Method -

        Session loadSession=  SessionFactoryConfig
                .getInstance()
                .getSession();

        System.out.println("------------------------------------------------calling load method ----------------------------------------");

        Customer load =loadSession.load(Customer.class,10);
        System.out.println("Customer id of Load  :" + load.getId());
        System.out.println("Customer name of Load :" + load.getName());

        loadSession.close();
    }
}
