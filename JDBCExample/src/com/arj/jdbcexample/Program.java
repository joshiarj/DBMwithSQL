/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arj.jdbcexample;

import com.arj.jdbcexample.dao.DocumentDAO;
import com.arj.jdbcexample.dao.impl.DocumentDAOImpl;
import com.arj.jdbcexample.dbutil.UserInterface;
import com.arj.jdbcexample.entity.Document;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Zeppelin
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UserInterface.dbUI();
        } catch (ClassNotFoundException | SQLException ce) {
            System.out.println(ce.getMessage());
        }
    }

}
