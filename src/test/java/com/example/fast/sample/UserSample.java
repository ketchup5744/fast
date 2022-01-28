package com.example.fast.sample;

import com.example.fast.FastApplicationTests;
import com.example.fast.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Random;

public class UserSample extends FastApplicationTests {

    private Random random;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void samleCreate(){

    }

//    private LocalDateTime getRandomDate() {
//
//    }

    private int getRandomNumber() {
        return random.nextInt(11)+1;
    }

}
