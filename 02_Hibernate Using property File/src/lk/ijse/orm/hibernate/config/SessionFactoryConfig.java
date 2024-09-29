package lk.ijse.orm.hibernate.config;

import lk.ijse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.IOException;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;

    private SessionFactoryConfig(){}

    public static SessionFactoryConfig getInstance() {
        return (factoryConfig == null) ? factoryConfig = new SessionFactoryConfig() : factoryConfig;
    }

    public Session getSession() {
        // Step 01 - Create StandardServiceRegistry Object
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .loadProperties("hibernate.properties").build();

        // Step 02 - Create Metadata Object
        Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(Customer.class)
                .getMetadataBuilder().build();

        // Step 03 - Create SessionFactory Object
        SessionFactory sessionFactory = metadata.buildSessionFactory();

        return sessionFactory.openSession();
    }

}