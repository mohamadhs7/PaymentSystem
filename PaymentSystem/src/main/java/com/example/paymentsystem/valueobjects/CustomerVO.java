package com.example.paymentsystem.valueobjects;

import com.example.paymentsystem.model.Customer;
import lombok.Data;
import java.io.Serializable;
@Data
public class CustomerVO implements Serializable {

    private String number;
    private String postalCode;
    private Integer state;
    private String nationalCode;
    private String firstName;
    private String lastName;
    private String address;


    public Customer cloneForDB() {
        Customer customer = new Customer();
        customer.setNumber(this.number);
        customer.setPostalCode(this.postalCode);
        customer.setState(this.state);
        customer.setNationalCode(this.nationalCode);
        customer.setFirstName(this.nationalCode);
        customer.setLastName(this.lastName);
        customer.setAddress(this.address);
        return customer;
    }
}
