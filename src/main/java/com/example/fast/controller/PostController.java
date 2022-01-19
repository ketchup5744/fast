package com.example.fast.controller;

import com.example.fast.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    // HTML <Form> 사용 시
    // ajax 검색 사용 시 (비동기화)
    // http post body -> data
    // json, xml, multipart-form, text-plain 등등

    //    @RequestMapping(method = RequestMethod.POST, path = "/postMethod")
    @PostMapping(value = "/postMethod"/*, produces = {"application-json"} // 텍스트 형식 변경 시*/)
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {
        return searchParam;
    }

    @PutMapping("/putMethod")
    public void put() {

    }

    @PatchMapping("/patchMethod")
    public void patch() {

    }

    @DeleteMapping("/deleteMethod")
    public void delete() {

    }
}