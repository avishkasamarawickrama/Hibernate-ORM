package lk.ijse.orm.hibernate.config;

import lk.ijse.orm.hibernate.entity.Customer;
import lk.ijse.orm.hibernate.entity.Item;
import lk.ijse.orm.hibernate.entity.Order;
import lk.ijse.orm.hibernate.entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;

    private SessionFactoryConfig(){}

        /* Singleton the class to avoid object recreation. */
    public static SessionFactoryConfig getInstance() {
        return (factoryConfig == null) ? factoryConfig = new SessionFactoryConfig() : factoryConfig;
    }

        /*  Get Session Object */
    public Session getSession() {
        /* 3 Steps of native Bootstrapping. */

        // Step 01 - Create StandardServiceRegistry Object
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        // Step 02 - Create Metadata Object
        Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(OrderDetail.class)
                .getMetadataBuilder().build();

        // Step 03 - Create SessionFactory Object
        SessionFactory sessionFactory = metadata.buildSessionFactory();

        return sessionFactory.openSession();
    }

}
