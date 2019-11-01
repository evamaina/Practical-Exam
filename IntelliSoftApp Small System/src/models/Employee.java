/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author gorenjaa
 */
public class Employee {
    
    String employeeName, dateOfBirth, address, contractExpirationDate, id;

    public Employee() {
        
    }

    public Employee(String employeeName, String dateOfBirth, String address, String contractExpirationDate, String id) {
        this.employeeName = employeeName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.contractExpirationDate = contractExpirationDate;
        this.id = id;
        
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContractExpirationDate() {
        return contractExpirationDate;
    }

    public void setContractExpirationDate(String contractExpirationDate) {
        this.contractExpirationDate = contractExpirationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
       
}
