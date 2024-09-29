package lk.ijse.orm.hibernate;

import lk.ijse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.orm.hibernate.entity.Customer;
import lk.ijse.orm.hibernate.entity.Order;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SQLQueryEvaluator {

    public static void main(String[] args) {


        Session session = SessionFactoryConfig
                .getInstance().getSession();

        String sql = "SELECT C FROM Customer AS C ";
        Query query = session.createQuery(sql);
        List<Customer> list = query.list();

        for (Customer customer : list) {
            System.out.println(customer);
        }
        session.close();

        System.out.println("-------------------------------------------JPL Where  clause ---------------------");


        Session jpqlWhereSession = SessionFactoryConfig
                .getInstance().getSession();

        String sql1 = "SELECT C FROM Customer AS C where  C.id = :cus_id";
        Query namedQuery = jpqlWhereSession.createQuery(sql1);
        namedQuery.setParameter("cus_id", 2);
        Customer customer = (Customer) namedQuery.getSingleResult();

        System.out.println(customer);
        jpqlWhereSession.close();


        System.out.println("-------------------------------------------JPL join  clause ---------------------");

        Session jpqlJoinSession = SessionFactoryConfig
                .getInstance().getSession();

        String sql3 ="SELECT O FROM Order AS O \n " +
                "INNER JOIN Customer AS C \n" +
                "ON  O.customer.id =C.id \n" +
                "WHERE C.id = :cus_id";

        Query jpqlJoinQuery = jpqlJoinSession.createQuery(sql3);
        jpqlJoinQuery.setParameter("cus_id",2);
        List<Order> list1 = jpqlJoinQuery.list();

        for (Order order:list1){
            System.out.println(order);
        }
        jpqlJoinSession.close();

        System.out.println("----------------------------------------------------- HQL -------------------------------");

        Session hqlGetAllSession = SessionFactoryConfig.getInstance().getSession();

        String sql4 = "FROM Customer";

        Query hqlGetAllQuery = hqlGetAllSession.createQuery(sql4);

        List<Customer> list2 = hqlGetAllQuery.list();
        for (Customer customer1 :list2){
            System.out.println(customer1);

        }
        hqlGetAllSession.close();
    }


}
