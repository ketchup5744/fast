package com.example.fast.controller.api;

import com.example.fast.Ifs.CrudInterface;
import com.example.fast.controller.CrudController;
import com.example.fast.model.entity.OrderGroup;
import com.example.fast.model.network.Header;
import com.example.fast.model.network.request.OrderGroupApiRequest;
import com.example.fast.model.network.response.OrderGroupApiResponse;
import com.example.fast.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

    /*

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @PostConstruct
    public void init() {
        this.baseService = orderGroupApiLogicService;
    }

     */

}
