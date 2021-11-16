package com.gcu.topic22.controller;

import com.gcu.topic22.model.LoginModel;
import com.gcu.topic22.model.OrderModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/")
    public ModelAndView display(Model model){
        ModelAndView mv = new ModelAndView();
        LoginModel loginModel = new LoginModel();
        mv.addObject("title", "Login Form");
        mv.addObject("loginModel", loginModel);
        mv.setViewName("login");
        return mv;
    }

    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Login Form");
            return "login";
        }

        ModelAndView mv = new ModelAndView();
        List<OrderModel> orders = new ArrayList<OrderModel>();
        orders.add(new OrderModel(0L, "00000001", "Product 1", 1.00f, 1));
        orders.add(new OrderModel(1L, "00000002", "Product 2", 2.00f, 2));
        orders.add(new OrderModel(2L, "00000003", "Product 3", 3.00f, 3));
        orders.add(new OrderModel(3L, "00000004", "Product 4", 4.00f, 4));
        orders.add(new OrderModel(4L, "00000005", "Product 5", 5.00f, 5));

        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", orders);
        return "orders";
    }
}
