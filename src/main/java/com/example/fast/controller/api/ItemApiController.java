package com.example.fast.controller.api;

import com.example.fast.Ifs.CrudInterface;
import com.example.fast.model.network.Header;
import com.example.fast.model.network.request.ItemApiRequest;
import com.example.fast.model.network.response.ItemApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item")
public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {
    @Override
    @PostMapping("") // /api/item
    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
        return null;
    }

    @Override
    @GetMapping("{id}") // /api/item/1 ... 100
    public Header<ItemApiResponse> read(@PathVariable Long Id) {
        return null;
    }

    @Override
    @PutMapping("") // /api/item
    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
        return null;
    }

    @Override
    @DeleteMapping("{id}") // /api/item/1 ... 100
    public Header delete(@PathVariable Long id) {
        return null;
    }
}
