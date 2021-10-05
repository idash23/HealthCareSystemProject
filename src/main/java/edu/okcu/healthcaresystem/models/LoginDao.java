package edu.okcu.healthcaresystem.models;

package edu.okcu.healthcaresystem.dao;

import java.util.List;

import com.jackrutorial.model.UserInfo;

public interface LoginDao {

    UserInfo findUserInfo(String username);

    List getUserRoles(String username);
}