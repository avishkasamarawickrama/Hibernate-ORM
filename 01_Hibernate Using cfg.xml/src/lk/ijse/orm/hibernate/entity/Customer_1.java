//package lk.ijse.orm.hibernate.entity;
//
//import lk.ijse.orm.hibernate.embedded.MobileNumber;
//import lk.ijse.orm.hibernate.embedded.NameIdentifier;
//import org.hibernate.annotations.CreationTimestamp;
//
//import javax.persistence.*;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table (name = "customer")
//    /* We can define the @Entity and @Table(name = "customer") OR @Entity(name = "customer") without @Table */
//public class Customer {
//
//    @Id
//    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    //@GeneratedValue(strategy = GenerationType.AUTO)
//
//    @Column (name = "customer_id")
//    private int id;
//
//    //    @Column (name = "customer_name")
//    //    private String name;
//    @Column (name = "customer_address")
//    private String address;
//
//    @Column (name = "customer_salary")
//    private double salary;
//
//    @CreationTimestamp
//    private Timestamp CreationTimestamp;
//
//    @Transient
//    @Column(name="customer_dob")
//    private String dob;
//
//    @ElementCollection
//    //one to many relationships and embedded type --> ElementCollection
//
//    @CollectionTable(name ="customer_mobile_no",joinColumns = @JoinColumn(name = "customer_id"))
//    //there are many mobile numbers and how to mapping it with id -->JoinColumn(name=" add table column name")
//
//    private List<MobileNumber> phoneNos = new ArrayList<>();
////customer HAS A list of mobile numbers
//
//    public List<MobileNumber> getPhoneNos() {
//        return phoneNos;
//    }
//
//
//    public void setPhoneNos(List<MobileNumber> phoneNos) {
//        this.phoneNos = phoneNos;
//    }
//    public void getPhoneNos(List<MobileNumber> phoneNos) {
//        this.phoneNos = phoneNos;
//    }
//
//    private NameIdentifier nameIdenitfier;
//
//    public Customer(int id, NameIdentifier nameIdenitfier, String address, double salary, Timestamp creationTimestamp, String dob) {
//        this.id = id;
//        this.nameIdenitfier = nameIdenitfier;
//        this.address = address;
//        this.salary = salary;
//        CreationTimestamp = creationTimestamp;
//        this.dob = dob;
//    }
//
//
//
//
//    public Customer() {
//    }
//
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "id=" + id +
//                ", nameIdenitfier=" + nameIdenitfier +
//                ", address='" + address + '\'' +
//                ", salary=" + salary +
//                '}';
//    }
//
//    public NameIdentifier getNameIdenitfier() {
//        return nameIdenitfier;
//    }
//
//    public void setNameIdenitfier(NameIdentifier nameIdenitfier) {
//        this.nameIdenitfier = nameIdenitfier;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//
//}
