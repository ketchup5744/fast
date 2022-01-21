package com.example.fast.repository;

import com.example.fast.FastApplicationTests;
import com.example.fast.model.entity.Item;
import com.example.fast.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends FastApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {

        /*
        // String sql = insert into user (%s, %s , %d ) value (account, email, age);
        User user = new User();

        // user.setId(); // DB에서 Auto Increasment로 설정되어 있기 때문에 생략해야 한다.
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-1111-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser3");

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);
         */

    }

    @Test
    @Transactional
    public void read() {

        /*

        // select * from user where id = ?
//        Optional<User> user = userRepository.findById(4L);
        Optional<User> user = userRepository.findByAccount("TestUser03");

        user.ifPresent(selectUser -> {
//            System.out.println("user = " + selectUser);
//            System.out.println("email : " + selectUser.getEmail());
//
            selectUser.getOrderDetailList().stream().forEach(detail -> {
//                System.out.println(detail.getItemId());
                Item item = detail.getItem();
                System.out.println(item);
//                System.out.println(detail.getItem());
            });
        });

         */
    }

    /* 사용자가 id를 입력하면 정보를 조회해주는 메소드 / 후에 Controller 에서 적용될 코드
    @Test
    public User read(@RequestParam Long id) {
        Optional<User> user = userRepository.findById(id);

        user.ifPresent(selectUser -> {
            System.out.println("user = " + selectUser);
            System.out.println("email : " + selectUser.getEmail());
        });

        return user.get();
    }
    */



    @Test
    @Transactional // 실제 동작은 하되 DB 에서 삭제시키지는 않음
    public void update() {

        // update user set account=%?
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional // 실제 동작 후 다시 롤백 시킴 (지운 후 원상태로 복원)
//    @DeleteMapping("/api/user") // Controller 예시
    public void delete() {
        Optional<User> user = userRepository.findById(3L);

        Assertions.assertTrue(user.isPresent()); // true or false

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(3L);

        Assertions.assertFalse(deleteUser.isPresent()); // true or false

        // 확인용
//        if(deleteUser.isPresent()){
//            System.out.println("데이터 존재 : " + deleteUser.get());
//        } else {
//            System.out.println("데이터 삭제. 데이터 없음.");
//        }
    }


}
