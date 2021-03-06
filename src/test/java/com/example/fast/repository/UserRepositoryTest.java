package com.example.fast.repository;

import com.example.fast.FastApplicationTests;
import com.example.fast.model.entity.Item;
import com.example.fast.model.entity.User;
import com.example.fast.model.enumclass.UserStatus;
import org.junit.Assert;
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

        String account = "Test03";
        String password = "Test03";
        UserStatus status = UserStatus.REGISTERED;
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-3333";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);

        /* 해당 생성자만 존재하는 객체가 만들어지는 것. = User Entity에 추가한 Lombok의 builder 어노테이션 효과

        User u = User.builder()
                .account(account)
                .password(password)
                .status(status)
                .email(email)
                .build();

         */

        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);

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

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        /* User Entity에 추가한 Lombok의 Accessors 어노테이션의 Chain 효과

        user
                .setEmail("")
                .setPhoneNumber("")
                .setStatus("");

        User u = new User().setAccount("").setEmail("").setPassword("");

         */


        if(user != null) {
            user.getOrderGroupList().stream().forEach(orderGroup -> {
                System.out.println("---------------주문묶음-------------");
                System.out.println("수령인 : " + orderGroup.getRevName());
                System.out.println("수령지 : " + orderGroup.getRevAddress());
                System.out.println("총금액 : " + orderGroup.getTotalPrice());
                System.out.println("총수량 : " + orderGroup.getTotalQuantity());

                System.out.println("---------------주문상세-------------");

                orderGroup.getOrderDetailList().forEach(orderDetail -> {
                    System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
                    System.out.println("파트너사 카테코리 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
                    System.out.println("주문 상품 : " + orderDetail.getItem().getName());
                    System.out.println("고객센터 번호 : " + orderDetail.getItem().getPartner().getCallCenter());
                    System.out.println("주문의 상태 : " + orderDetail.getStatus());
                    System.out.println("도착 예정 일자 : " + orderDetail.getArrivalDate());
                });
            });
        }
        Assert.assertNotNull(user);
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
