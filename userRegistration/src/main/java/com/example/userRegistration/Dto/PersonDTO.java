package com.example.userRegistration.Dto;

public class PersonDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String nic;
    private String email;
    private String address;

    public PersonDTO() {
    }

    public PersonDTO(String id, String firstName, String lastName, String nic, String email, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nic = nic;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nic='" + nic + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
