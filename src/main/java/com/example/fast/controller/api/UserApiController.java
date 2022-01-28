package com.example.fast.controller.api;

import com.example.fast.Ifs.CrudInterface;
import com.example.fast.controller.CrudController;
import com.example.fast.model.entity.User;
import com.example.fast.model.network.Header;
import com.example.fast.model.network.request.UserApiRequest;
import com.example.fast.model.network.response.UserApiResponse;
import com.example.fast.model.network.response.UserOrderInfoApiResponse;
import com.example.fast.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController /*implements CrudInterface*/ extends CrudController<UserApiRequest, UserApiResponse, User> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    // 상세내역
    @GetMapping("/{id}/orderInfo")
    public Header<UserOrderInfoApiResponse> orderInfo(@PathVariable Long id) {
        return userApiLogicService.orderInfo(id);

    }

    // 페이징 처리
    // SELECT * FROM fast.user where 1=1 order by id limit 0, 15;
    @GetMapping("")
    public Header<List<UserApiResponse>> search(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 15) Pageable pageable) {
        log.info("{}", pageable);
        return userApiLogicService.search(pageable);
    }

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
        log.info("delete : {}", id);
        return userApiLogicService.delete(id);
    }

        /*

    @PostConstruct
    public void init() {
        this.baseService = userApiLogicService;
    }

     */

}
