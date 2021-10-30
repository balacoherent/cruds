package com.example.E_commerce.DTO;

import com.example.E_commerce.Entity_or_Model.Role;
import lombok.Data;

import java.util.List;


@Data
public class UserDTO {

    private String userName;
    private String password;
    private String email;
    private  Long phoneNumber;
    private List<Role> role;

}
