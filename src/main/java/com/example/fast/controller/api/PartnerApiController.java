package com.example.fast.controller.api;

import com.example.fast.controller.CrudController;
import com.example.fast.model.entity.Partner;
import com.example.fast.model.network.request.PartnerApiRequest;
import com.example.fast.model.network.response.PartnerApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {
}
