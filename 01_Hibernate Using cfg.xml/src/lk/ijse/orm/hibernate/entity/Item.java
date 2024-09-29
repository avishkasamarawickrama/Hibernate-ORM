package lk.ijse.orm.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;


    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_qnty")
    private int qty;

    @Column(name = "unit_price")
    private double unitPrice;

//    @ManyToMany(mappedBy = "items")
//    private List<Order> orders =new ArrayList<>();
//    //item Has MULTIPLE orders

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "item")
    private List<OrderDetail> orderDetails =new ArrayList<>();


}