package org.dpa.study.userbase1.repositories;

import org.dpa.study.userbase1.database.DatabaseConnection;
import org.dpa.study.userbase1.dtos.UserDto;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;

public class UsersRepository {

    public static JSONArray getUser(int id) {
        try(Connection connection = DatabaseConnection.getConnection()) {
            ResultSet resultSet;

            if (id == 0) {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM shopdb.shopschema.users");
                resultSet = preparedStatement.executeQuery();
            } else {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM shopdb.shopschema.users WHERE id = ?");
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
            }

            JSONArray resultSetJsonArray = new JSONArray();

            while (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                JSONObject row = new JSONObject();

                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    String columnLabel = metaData.getColumnLabel(i);
                    Object value = resultSet.getObject(columnLabel);
                    row.put(columnLabel, value);
                }

                resultSetJsonArray.put(row);
            }

            return resultSetJsonArray;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addUser(UserDto user) {

        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO shopdb.shopschema.users (id, name) VALUES (?, ?)")) {

            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

      public static String deleteUserById(UserDto user) {
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM shopdb.shopschema.users WHERE (id = ?)")) {

            preparedStatement.setInt(1, user.getId());
            preparedStatement.executeUpdate();

            return "success";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
