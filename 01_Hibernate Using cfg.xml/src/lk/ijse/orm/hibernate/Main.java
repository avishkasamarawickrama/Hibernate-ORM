package lk.ijse.orm.hibernate;

import lk.ijse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.orm.hibernate.embedded.MobileNumber;
import lk.ijse.orm.hibernate.embedded.NameIdentifier;
import lk.ijse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName("kamal");
        customer.setAddress("Galle");

//        NameIdentifier name= new NameIdentifier();
//        customer.setId(1);
//        name.setFirst_name("kamal");
//        name.setMiddle_name("De");
//        name.setLast_name("silva");
//        customer.setNameIdenitfier(name);
//        customer.setAddress("Galle");
//        customer.setSalary(25000.00);

//        List<MobileNumber> mobileNumbers =new ArrayList<>(); // create mobile number array list
//        MobileNumber homeNo = new MobileNumber();    // create mobile numbers
//
//        homeNo.setType("HOME");//set type of  mobile number
//        homeNo.setMobileNo("09145533599"); //add mobile number in suitable type
//
//        MobileNumber mobileNumber = new MobileNumber();
//        mobileNumber.setType("MOBILE");
//        mobileNumber.setMobileNo("07145533599");
//
//        mobileNumbers.add(homeNo);    //pass home number and mobile no to created array list.
//        mobileNumbers.add(mobileNumber);
//
//        customer.setPhoneNos(mobileNumbers);

        Session session = SessionFactoryConfig
                .getInstance()
                .getSession();

        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
//
//        //update existing customer
//
//        Session updateCusSession=  SessionFactoryConfig
//                .getInstance()
//                .getSession();
//
//        Transaction updateCusTransaction = updateCusSession
//                .beginTransaction();
//
//        customer.setAddress("Matara");
//        customer.setSalary(34000.00);
//
//        updateCusSession.update(customer);
//        updateCusTransaction.commit();
//        updateCusSession.close();

        //get customer from  DB
//        Session getCusSession = SessionFactoryConfig
//                .getInstance()
//                .getSession();
//
//        Customer existingCustomer=  getCusSession
//                .get(Customer.class,1);
//
//        System.out.println(existingCustomer);


        //delete customer from DB

     /* Session deleteCusSession = SessionFactoryConfig
               .getInstance()
               .getSession();

       Transaction deleteCusTransaction= deleteCusSession
               .beginTransaction();

       deleteCusSession.delete(existingCustomer);
       deleteCusTransaction.commit();
       deleteCusSession.close();
*/
    }
}
