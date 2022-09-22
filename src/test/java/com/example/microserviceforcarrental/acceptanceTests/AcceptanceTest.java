package com.example.microserviceforcarrental.acceptanceTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@AutoConfigureMockMvc
public class AcceptanceTest {

    @Test
    void methodFirst() {
        fail();
    }

    @Test
    void methodSecond() {
        fail();
    }

}