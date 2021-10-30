package com.example.E_commerce.Controller;

import com.example.E_commerce.BaseReponse.BaseResponse;
import com.example.E_commerce.DTO.UserDTO;
import com.example.E_commerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;


    @GetMapping("/summa")
    public String summa()
    {
        return "summa summa";
    }

    @PostMapping("/post")
    public BaseResponse create(@RequestBody UserDTO userDTO)
    {
        return userService.create(userDTO);
    }

    @GetMapping("/getbyid")
    public BaseResponse getbyid(@RequestParam Long id)
    {
        return userService.getbyid(id);
    }

    @PutMapping("/putupdate")
    public BaseResponse putupdate(@RequestParam Long id, @RequestBody UserDTO userDTO)
    {
        return userService.putupdate(id,userDTO);
    }

    @DeleteMapping("/deletebyid")
    public BaseResponse deletebyid(@RequestParam Long id)
    {
        return userService.deletebyid(id);
    }

    @GetMapping("/getall")
    public BaseResponse getall()
    {
        return userService.getall();
    }


}
