package com.example.fast.service;

import com.example.fast.Ifs.CrudInterface;
import com.example.fast.model.entity.User;
import com.example.fast.model.network.Header;
import com.example.fast.model.network.request.UserApiRequest;
import com.example.fast.model.network.response.UserApiResponse;
import com.example.fast.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    // 1. request data 가져오기
    // 2. user 생성
    // 3. 생성된 데이터를 기준으로 -> UserApiResponse return

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        // 1. request data
        UserApiRequest userApiRequest = request.getData();

        // 2. User 생성
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status("REGISTERED")
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();
        User newUser = userRepository.save(user);

        // 3. 생성된 데이터를 기준으로 -> userApiResponse return
        // 반복 사용이 예상됨으로 따로 메소드를 생성해줌

        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long Id) {

        /*

        // id로 repository에 있는 getOne, getById 데이터를 가지고 온다.
        Optional<User> optional = userRepository.findById(Id);

        // 데이터를 받은 다음 user 를 가지고 userApiReponse return 해준다.

        return optional.map(user -> response(user))
                .orElseGet(
                        () -> Header.ERROR("데이터 없음")
                );

         */

        // 위 코드를 람다식으로 간편하게 바꾼 것
        return userRepository.findById(Id)
            .map(user -> response(user))
            .orElseGet(
                    () -> Header.ERROR("데이터 없음")
            );

    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {

        // 1. Data 가져오기
        UserApiRequest userApiRequest = request.getData();

        // 2. id를 가지고 user 데이터를 찾기
        Optional<User> optional = userRepository.findById(userApiRequest.getId());

        return optional.map(user -> {

        // 3. data -> update
        // id
            user.setAccount(userApiRequest.getAccount())
                    .setPassword(userApiRequest.getPassword())
                    .setStatus(userApiRequest.getStatus())
                    .setPhoneNumber(userApiRequest.getPhoneNumber())
                    .setEmail(userApiRequest.getEmail())
                    .setRegisteredAt(userApiRequest.getRegisteredAt())
                    .setUnregisteredAt(userApiRequest.getUnregisteredAt()); // 아직 데이터베이스에 반영 전
            return user;
        })
                .map((user -> userRepository.save(user))) // update - newUser 새로운 유저 객체가 반영
                .map(updateUser -> response(updateUser))              // userApiResponse 생성
                .orElseGet(()->Header.ERROR("데이터 없음"));

    }

    @Override
    public Header delete(Long id) {

        // 1. id -> repository -> user

        Optional<User> optional = userRepository.findById(id);

        // 2. repository -> delete

        return optional.map(user -> {
                    userRepository.delete(user);
                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("데이터없음"));         // 3. response return

    }

    private Header<UserApiResponse> response(User user) {
        // user 객체로 userApiResponse를 만들어서 return 해주는 메소드

        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword()) // todo 암호화, 길이를 return 등 필요
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        // Header + data return
        return Header.OK(userApiResponse);

    }
}
