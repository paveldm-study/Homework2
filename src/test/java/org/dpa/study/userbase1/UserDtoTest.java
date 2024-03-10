package org.dpa.study.userbase1;

import org.dpa.study.userbase1.dtos.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDtoTest {

    @Mock
    private UserDto userDtoMock;

    @Test
    public void testConstructor() {
        UserDto userDto = new UserDto(1, "Test Name");

        assertEquals(1, userDto.getId());
        assertEquals("Test Name", userDto.getName());
    }

    @Test
    public void testSetters() {
        UserDto userDto = new UserDto(1, "Test Name");

        userDto.setId(2);
        userDto.setName("New Name");

        assertEquals(2, userDto.getId());
        assertEquals("New Name", userDto.getName());
    }
}
