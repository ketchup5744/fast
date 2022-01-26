package com.example.fast.controller.api;

import com.example.fast.Ifs.CrudInterface;
import com.example.fast.controller.CrudController;
import com.example.fast.model.network.Header;
import com.example.fast.model.network.request.ItemApiRequest;
import com.example.fast.model.network.response.ItemApiResponse;
import com.example.fast.service.ItemApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    @PostConstruct
    public void init() {
        this.baseService = itemApiLogicService;
    }



}
