/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arj.jdbcexample.dao;

import com.arj.jdbcexample.entity.Document;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Zeppelin
 */
public interface DocumentDAO {
    List<Document> getAll() throws SQLException, ClassNotFoundException;
    Document getById(int id) throws SQLException, ClassNotFoundException;
    int insert(Document d) throws SQLException, ClassNotFoundException;
    int update(Document d) throws SQLException, ClassNotFoundException;
    int delete(int id) throws SQLException, ClassNotFoundException;
}
