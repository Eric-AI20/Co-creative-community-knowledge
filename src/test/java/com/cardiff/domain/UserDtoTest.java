package com.cardiff.domain;
import com.cardiff.domain.UserDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
/**
 * simple unit test (dto test)
 */
@SpringBootTest
public class UserDtoTest {

    private UserDto userDto;
    @Before
    public void setUp() {
        userDto = provideUserDto();
    }

    @Test
    public void userDtoTest() {
        UserDto userDto = provideUserDto();
        Assert.assertEquals("Yihang", userDto.getLastName());
        //Assert.assertEquals("Susan", userDto.getLastName());
        //Assert.assertEquals("Wang", userDto.getFirstName());
        Assert.assertEquals("Ai", userDto.getFirstName());

        Assert.assertEquals("PW002",userDto.getPassword());
        //Assert.assertEquals("PW0001",userDto.getPassword());
        Assert.assertEquals("PW002", userDto.getMatchingPassword());
        //Assert.assertEquals("PW0001", userDto.getMatchingPassword());
        Assert.assertEquals("yihang@qq.com", userDto.getEmail());
        //Assert.assertEquals("wangsusan@126.com", userDto.getEmail());
    }

    private UserDto provideUserDto() {
        UserDto userDto = new UserDto();
        //userDto.setLastName("Susan");
        //userDto.setFirstName("Wang");
        //userDto.setPassword("PW0001");
        //userDto.setMatchingPassword("PW0001");
        //userDto.setEmail("wangsusan@126.com");

        userDto.setLastName("Yihang");
        userDto.setFirstName("Ai");
        userDto.setPassword("PW002");
        userDto.setMatchingPassword("PW002");
        userDto.setEmail("yihang@qq.com");

        return userDto;
    }
}