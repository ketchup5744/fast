package com.example.fast.controller;

import com.example.fast.model.SearchParam;
import com.example.fast.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
// Localhost:8080/api
@RequestMapping("/api")
public class GetController {

    // Localhost:8080/api/getMethod
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest() {

        return "Hi getMethod";
    }

    // Localhost:8080/api/getParameter?id=1234&password=abcd
    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd) {
        String password = "bbbb";
        System.out.println("id : " + id);
        System.out.println("pwd = " + pwd);

        return id+pwd;
    }

    // Localhost:8080/api/getMultiParameter?account=abcd&email=study@gmail.com&page=10
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        // { "account" : "", "email" : "", "page" : 0}
        return searchParam;
    }

    @GetMapping("/header")
    public Header getHeader() {

        // {"resultCode: "OK", "description" : "OK"}
        return Header.builder().resultCode("OK").description("OK").build();
    }

}
