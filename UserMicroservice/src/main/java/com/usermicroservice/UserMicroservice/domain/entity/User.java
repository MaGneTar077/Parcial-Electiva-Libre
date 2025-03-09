package com.usermicroservice.UserMicroservice.domain.entity;

public class User {

    private Long id; // Cambiamos UUID por Long
    private String name;
    private String lastname;
    private int age;
    private String email;
    private String phone;
    private String gender;
    private String password;
    private Integer version;

    // Constructor vacío
    public User() {}

    // Constructor con todos los campos
    public User(Long id, String name, String lastname, int age, String email, String phone, String gender, String password, Integer version) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.version = version;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Integer getVersion() { return version; }
    public void setVersion(Integer version) { this.version = version; }
}