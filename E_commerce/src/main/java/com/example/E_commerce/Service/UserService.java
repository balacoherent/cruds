package com.example.E_commerce.Service;

import com.example.E_commerce.BaseReponse.BaseResponse;
import com.example.E_commerce.DTO.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    BaseResponse create(UserDTO userDTO);

    BaseResponse getbyid(Long id);

    BaseResponse putupdate(Long id, UserDTO userDTO);

    BaseResponse deletebyid(Long id);

    BaseResponse getall();
}
