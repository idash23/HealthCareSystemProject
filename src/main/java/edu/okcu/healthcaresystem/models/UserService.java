package edu.okcu.healthcaresystem.models;

package edu.okcu.healthcaresystem.service;

import java.util.List;

import edu.okcu.healthcaresystem.model.UserInfo;

public interface UserService {

    public List list();

    public UserInfo findUserByUsername(String username);

    public void update(String username, String password);

    public void add(String username, String password);

    public boolean userExists(String username);
}