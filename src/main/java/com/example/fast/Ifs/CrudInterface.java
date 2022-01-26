package com.example.fast.Ifs;

import com.example.fast.model.network.Header;
import com.example.fast.model.network.request.UserApiRequest;
import com.example.fast.model.network.response.UserApiResponse;

import javax.persistence.Id;

public interface CrudInterface<Req, Res> {

    Header<Res/*UserApiResponse*/> create(Header<Req>/*UserApiRequest*/ request);  // todo request object 추가

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header delete(Long id);

}
