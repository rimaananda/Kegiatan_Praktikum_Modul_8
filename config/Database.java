/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author macbookair
 */
public class Database {
    private static Connection connection;

    public static Connection startConnection() {
        String url = "jdbc:mysql://localhost:8889/db_praktikum_7";
        String username = "root";
        String password = "root";

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Koneksi berhasil");

        } catch (SQLException exc) {
            System.out.println("Koneksi error : " + exc.getMessage());
        }
        return connection;
    }
    
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException exc) {
            System.out.println("FAILED TO CLOSE DATABASE CONNECTION : " + exc.getMessage());
        }
    }
    
    
    public static void main(String[] args) {
        Database k = new Database();
        k.startConnection();
    }
    
}
