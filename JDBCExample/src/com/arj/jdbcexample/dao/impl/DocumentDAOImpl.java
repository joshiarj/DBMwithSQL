/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arj.jdbcexample.dao.impl;

import com.arj.jdbcexample.dao.DocumentDAO;
import com.arj.jdbcexample.dbutil.DbConnection;
import com.arj.jdbcexample.entity.Document;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zeppelin
 */
public class DocumentDAOImpl implements DocumentDAO {

    private DbConnection db = new DbConnection();

    @Override
    public List<Document> getAll() throws ClassNotFoundException, SQLException {
        List<Document> docList = new ArrayList<>();
        db.connect();
        String sql = "SELECT * FROM tbl_documents";
        PreparedStatement stmt = db.initStatement(sql);
        ResultSet rs = db.executeQuery();
        while (rs.next()) {
            docList.add(mapData(rs));
        }
        db.close();
        return docList;
    }

    private Document mapData(ResultSet rs) throws SQLException {
        Document doc = new Document();
        doc.setId(rs.getInt("doc_id"));
        doc.setTitle(rs.getString("doc_title"));
        doc.setDescription(rs.getString("doc_description"));
        doc.setImgFile(rs.getString("doc_image"));
        doc.setAddedDate(rs.getDate("doc_dateadded"));
        return doc;
    }

    @Override
    public Document getById(int id) throws SQLException, ClassNotFoundException {
        Document doc = null;
        db.connect();
        String sql = "SELECT * FROM tbl_documents WHERE doc_id=?";
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = db.executeQuery();
        if (rs.next()) {
            doc = mapData(rs);
        }
        db.close();
        return doc;
    }

    @Override
    public int insert(Document d) throws SQLException, ClassNotFoundException {
        db.connect();
        String sql = "INSERT into tbl_documents (doc_title,doc_description,doc_image) VALUES (?,?,?)";
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, d.getTitle());
        stmt.setString(2, d.getDescription());
        stmt.setString(3, d.getImgFile());
        int result = db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public int update(Document d) throws SQLException, ClassNotFoundException {
        db.connect();
        String sql = "UPDATE tbl_documents  SET doc_title=?, doc_description=?, doc_image=? WHERE doc_id=?";
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, d.getTitle());
        stmt.setString(2, d.getDescription());
        stmt.setString(3, d.getImgFile());
        stmt.setInt(4, d.getId());
        int result = db.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        db.connect();
        String sql = "DELETE FROM tbl_documents WHERE doc_id=?";
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setInt(1, id);
        int result = db.executeUpdate();
        db.close();
        return result;
    }

}
