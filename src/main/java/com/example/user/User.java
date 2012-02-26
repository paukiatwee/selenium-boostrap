/**
 * 
 */
package com.example.user;

import java.io.Serializable;

/**
 * @author pau
 *
 */
public class User implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 5796225889452148505L;
    
    private String username;
    private String password;
    private String role;
    
    public User() {
        
    }
    public User(String username, String password) {
        
        this.username = username;
        this.password = password;
    }
    
    public User(String username, String password, String role) {
        this(username, password);
        this.role = role;
    }
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }
    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User) {
            User another = (User) obj;
            return safeEquals(username, another.getUsername()) && safeEquals(password, another.getPassword());
        }
        return false;
    }
    
    
    private boolean safeEquals(String s1, String s2) {
        return s1 != null && s1.equals(s2);
    }
    

}
