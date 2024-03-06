package org.dpa.study.userbase1;

import org.dpa.study.userbase1.dtos.UserDto;
import org.dpa.study.userbase1.database.DatabaseConnection;
import org.junit.jupiter.api.BeforeAll;

import java.sql.Connection;


//@ExtendWith(MockitoExtension.class)
public class UserServletTest {

    Connection connection;
    private UserDto userDto = new UserDto(5, "Alice Jackson");

    @BeforeAll
    public static void setUp(){
        connection = DatabaseConnection.getConnection();
    }




}
