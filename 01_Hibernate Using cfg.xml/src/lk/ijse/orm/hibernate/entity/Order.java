package lk.ijse.orm.hibernate.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "order_id")
    private int id;

    @Column(name="order_description")
    private String order_description;

    @CreationTimestamp
    @Column(name = "order_date_time")
    private Timestamp orderDateTime;

    @ManyToOne
    @JoinColumn(name= "customer_id")

    private Customer customer;
    //one order has one customer


//---------------------------------------------------------------------
//   @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Item> items = new ArrayList<>();
//    //order HAS items , --> many to many relationship.
//----------------------------------------------------------------------



    //define manually other entities in order_detail
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "order")
    private List<OrderDetail> orderDetails =new ArrayList<>();


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_description='" + order_description + '\'' +
                ", orderDateTime=" + orderDateTime +
                //", customer=" + customer +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_description() {
        return order_description;
    }

    public void setOrder_description(String order_description) {
        this.order_description = order_description;
    }

    public Timestamp getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(Timestamp orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order(int id, String order_description, Timestamp orderDateTime, Customer customer) {
        this.id = id;
        this.order_description = order_description;
        this.orderDateTime = orderDateTime;
        this.customer = customer;
    }

}
