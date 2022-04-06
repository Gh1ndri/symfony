/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author leith
 */
public class User {
    private int id;
    private String email;
    private String username;
    private String role;
    private String password;

    public User(int id, String email, String username, String role, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.role = role;
        this.password = password;
    }

    public User(String email, String username, String role, String password) {
        this.email = email;
        this.username = username;
        this.role = role;
        this.password = password;
    }

    public User() {
    }
    

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", username=" + username + ", role=" + role + ", password=" + password + '}';
    }
    
    
}
