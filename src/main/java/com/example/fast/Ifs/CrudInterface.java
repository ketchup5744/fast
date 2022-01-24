package com.example.fast.Ifs;

import com.example.fast.model.network.Header;

import javax.persistence.Id;

public interface CrudInterface {

    Header create();  // todo request object 추가

    Header read(Long Id);

    Header update();

    Header delete(Long id);

}
