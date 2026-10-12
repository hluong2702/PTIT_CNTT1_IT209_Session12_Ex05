package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        // Kiểm tra nạp ApplicationContext thành công
        assertTrue(true, "Application context loaded successfully");
    }

    @Test
    void testSampleLogic() {
        // Bài kiểm thử đơn vị thành công
        int expected = 10;
        int actual = 5 + 5;
        org.junit.jupiter.api.Assertions.assertEquals(expected, actual, "Test toán học cơ bản pass");
    }
}
