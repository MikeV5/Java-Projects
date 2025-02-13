package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import database.DbHelper;


public class Main {
    public static void main(String[] args) throws SQLException {
        Statement statement = DbHelper.getStatement();
        ResultSet rs = statement.executeQuery(
                "SELECT * "
                        + "FROM public.\"Utenti\"");

        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");
            System.out.println(username+";"+password);
        }

/*
        while (rs.next()) {
            String matricola = rs.getString("trackname");
            String artistname = rs.getString("artistname");
            String album = rs.getString("album");
            int trackduration = rs.getInt("trackduration");
            int data = rs.getInt("data");
            System.out.println(matricola+";"+artistname+";"+data+";"+album+";"+trackduration);
        }
*/
    }
}