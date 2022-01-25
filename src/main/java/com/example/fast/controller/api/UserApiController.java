package com.example.fast.controller.api;

import com.example.fast.Ifs.CrudInterface;
import com.example.fast.model.network.Header;
import com.example.fast.model.network.request.UserApiRequest;
import com.example.fast.model.network.response.UserApiResponse;
import com.example.fast.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @Override
    @PostMapping("") // /api/user
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("{}", request); // 디버그를 위한 로그를 추가해야 함.
        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}") // /api/user/{id}
    public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) {
        log.info("read id : {}", id);
        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping("") // /api/user
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        return userApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}") // /api/user/{id}
    public Header delete(@PathVariable Long id) {
        return null;
    }
}
