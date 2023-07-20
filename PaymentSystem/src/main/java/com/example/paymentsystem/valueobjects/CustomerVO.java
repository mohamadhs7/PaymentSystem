package com.example.paymentsystem.valueobjects;

import com.example.paymentsystem.model.Customer;
import com.example.paymentsystem.model.enums.CustomerStateEnum;
import lombok.Data;
import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

@Data
public class CustomerVO implements Serializable {

    private String number;
    private String postalCode;
    private Integer state;
    private String nationalCode;
    private String firstName;
    private String lastName;
    private String address;
    private Long id;
    private Long version;
    private String fullName;
    private String stateString;


    public Customer cloneForDB() {
        Customer customer = new Customer();
        customer.setNumber(String.valueOf(new Random().nextInt(100000)));
        customer.setPostalCode(this.postalCode);
        customer.setState(this.state);
        customer.setNationalCode(this.nationalCode);
        customer.setFirstName(this.firstName);
        customer.setLastName(this.lastName);
        customer.setAddress(this.address);
        return customer;
    }

    public static CustomerVO cloneFromDB(Customer customer) {
        CustomerVO customerVO = new CustomerVO();
        customerVO.setNumber(customer.getNumber());
        customerVO.setPostalCode(customer.getPostalCode());
        customerVO.setState(customer.getState());
        customerVO.setStateString(Objects.equals(customer.getState(), CustomerStateEnum.Normal.type) ? "Normal" : "Block");
        customerVO.setNationalCode(customer.getNationalCode());
        customerVO.setFirstName(customer.getFirstName());
        customerVO.setLastName(customer.getLastName());
        customerVO.setAddress(customer.getAddress());
        customerVO.setId(customer.getId());
        customerVO.setVersion(customer.getVersion());
        customerVO.setFullName(customerVO.getFirstName() + "  " + customerVO.getLastName());
        return customerVO;
    }
}
