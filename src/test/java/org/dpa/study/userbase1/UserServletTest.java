package org.dpa.study.userbase1;

import jakarta.servlet.ServletConfig;
import org.dpa.study.userbase1.dtos.UserDto;
import org.dpa.study.userbase1.database.DatabaseConnection;
import org.dpa.study.userbase1.servlets.UserServlet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Connection;


//@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class UserServletTest {

    @Mock
    private UserServlet servlet;
//    UserServlet servlet = new UserServlet();


//    Connection connection;
//    private UserDto userDto = new UserDto(5, "Alice Jackson");

    @BeforeAll
    public static void setUp(){
        Connection connection = DatabaseConnection.getConnection();
    }

    @Test
    public void testDoGet() throws Exception {

        UserServlet servlet = new UserServlet();

        MockServletContext context = new MockServletContext();

        servlet.init((ServletConfig) context);

        servlet.doGet(request, response);

//        UserServlet servlet = new UserServlet(); // создаем экземпляр тестируемого сервлета
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        // request.setParameter("paramName", "paramValue");

        servlet.init();
//        method.invoke(servlet.doGet(request, response)); // вызываем метод doGet нашего сервлета

        servlet.doGet


        // assertEquals("Expected result", response.getContentAsString());
    }




}
