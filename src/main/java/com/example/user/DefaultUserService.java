/**
 * 
 */
package com.example.user;

import java.util.ArrayList;
import java.util.List;


/**
 * @author pau
 *
 */
public class DefaultUserService {
    private List<User> users = new ArrayList<User>();
    
    public DefaultUserService() {
        if(users.size() == 0) {
            User user = new User();
            user.setUsername("sysadmin");
            user.setPassword("sysadmin");
            user.setRole("ADMIN");
            users.add(user);
        }
    }
    public void add(User user) {
        users.add(user);
    }
    
    public List<User> getAll() {
        return users;
    }
    
    public boolean login(User user) {
        return users.contains(user);
    }

}
