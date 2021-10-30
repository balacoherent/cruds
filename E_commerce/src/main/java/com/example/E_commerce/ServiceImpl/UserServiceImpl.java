package com.example.E_commerce.ServiceImpl;
import com.example.E_commerce.BaseReponse.BaseResponse;
import com.example.E_commerce.DTO.UserDTO;
import com.example.E_commerce.Entity_or_Model.Role;
import com.example.E_commerce.Entity_or_Model.User;
import com.example.E_commerce.Repository.UserRepo;
import com.example.E_commerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public BaseResponse create(UserDTO userDTO)
    {
        User user= new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEmail(userDTO.getEmail());

        List<Role> sabari = new LinkedList<>();

        userDTO.getRole().stream().forEachOrdered(role -> {
            sabari.add(role);
        });

        user.setRole(sabari);

        userRepo.save(user);
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setData(user);

        return baseResponse;
    }

    @Override
    public BaseResponse getbyid(Long id)
    {
        Optional<User> user = userRepo.findById(id);

        BaseResponse baseResponse= new BaseResponse();
        if(user.isPresent())
        {
            if (user.get().getIsDelete() == 0)
            {
                baseResponse.setData(user);
            }
            else
            {
                baseResponse.setStatusCode(400);
                baseResponse.setStatusMessage("Data deleted");
                baseResponse.setError("This Data is Deleted");
            }
        }
        else
        {
            baseResponse.setStatusCode(402);
            baseResponse.setStatusMessage("enter a valid id to detect");
            baseResponse.setError("Please Enter a valid User Id");
        }
        return baseResponse;
    }

    @Override
    public BaseResponse putupdate(Long id, UserDTO userDTO)
    {
        Optional<User> user = userRepo.findById(id);

        user.get().setUserName(user.get().getUserName());

        user.get().setPassword(userDTO.getPassword());
        user.get().setPhoneNumber(userDTO.getPhoneNumber());
        user.get().setEmail(userDTO.getEmail());
        user.get().setIsActive(user.get().getIsActive());
        user.get().setIsDelete(user.get().getIsDelete());

        List<Role> sabari = new LinkedList<>();

        userDTO.getRole().stream().forEachOrdered(role -> {
            sabari.add(role);
        });

        user.get().setRole(sabari);

        userRepo.save(user.get());

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(user.get());

        return baseResponse;
    }

    @Override
    public BaseResponse deletebyid(Long id)
    {
        Optional<User> user = userRepo.findById(id);
        user.get().setIsDelete(1);

        userRepo.save(user.get());

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData("This ID " + id + "is Successfully Deleted");
        return  baseResponse;
    }


    @Override
    public BaseResponse getall()
    {
        Iterable<User> sabari = userRepo.findAll();

        BaseResponse baseResponse= new BaseResponse();
        baseResponse.setData(sabari);
        return baseResponse;
    }



}