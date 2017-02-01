/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arj.jdbcexample.dbutil;

import com.arj.jdbcexample.dao.DocumentDAO;
import com.arj.jdbcexample.dao.impl.DocumentDAOImpl;
import com.arj.jdbcexample.entity.Document;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Zeppelin
 */
public class UserInterface {

    private static Scanner input = new Scanner(System.in);
    private static DocumentDAO documentDAO = new DocumentDAOImpl();

    public static void dbUI() throws SQLException, ClassNotFoundException {
        while (true) {
            menu();
            switch (input.nextInt()) {
                case 1:
                    addToDb();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    searchById();
                    break;
                case 4:
                    updateDb();
                    break;
                case 5:
                    deleteFromDb();
                    break;
                case 6:
                    System.out.println("Do you really want to exit? [Y/N]");
                    if (input.next().equalsIgnoreCase("Y")) {
                        System.exit(0);
                    }
            }
        }
    }

    private static void menu() {
        System.out.println("\nChoose your option [1-6]:");
        System.out.println("1. Add/INSERT new data to database.");
        System.out.println("2. Show all data.");
        System.out.println("3. Search by ID.");
        System.out.println("4. Edit/UPDATE data.");
        System.out.println("5. DELETE from database");
        System.out.print("6. Exit.\n> ");
    }

    private static void addToDb() throws SQLException, ClassNotFoundException {
        Document doc = new Document();
        input.nextLine();
        System.out.println("Enter document name:");
        doc.setTitle(input.nextLine());
        System.out.println("Enter document description:");
        doc.setDescription(input.nextLine());
        System.out.println("Enter document image file:");
        doc.setImgFile(input.nextLine());
        documentDAO.insert(doc);
        System.out.println("Item: \"" + doc.getTitle() + "\" successfully added to database!");
    }

    private static void showAll() throws SQLException, ClassNotFoundException {
        for (Document d : documentDAO.getAll()) {
            System.out.println(d.getId() + ". " + d.getTitle());
        }
    }

    private static void searchById() throws SQLException, ClassNotFoundException {
        System.out.println("Enter ID to search:");
        Document resultDoc = documentDAO.getById(input.nextInt());
        if (resultDoc != null) {
            System.out.println(resultDoc.getId()+". "+resultDoc.getTitle()+" | "+resultDoc.getDescription()
            + " | " +resultDoc.getImgFile()+" | "+ resultDoc.getAddedDate());
        } else {
            System.out.println("Item not found.");
        }
    }

    private static void deleteFromDb() throws SQLException, ClassNotFoundException {
        System.out.println("Enter ID to delete:");
        int idToDelete = input.nextInt();
        Document d = documentDAO.getById(idToDelete);
        System.out.println("Are you sure you want to delete \"" + d.getTitle() + "\"?");
        if (input.next().equalsIgnoreCase("y")) {
            documentDAO.delete(idToDelete);
            System.out.println("Item Deleted!");
        } else {
            System.out.println("Item not deleted.");
        }
    }

    private static void updateDb() throws SQLException, ClassNotFoundException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
//        DateFormat format = date.;
        System.out.println("Enter ID to update:");
        int searchID = input.nextInt();

        Document resultDoc = documentDAO.getById(searchID);
        if (resultDoc != null) {
            System.out.println("Updating item: \"" + resultDoc.getTitle() + "\".");
//            System.out.print("What do you want to update in \"" + resultDoc.getTitle() + "\"?\n"
//                    + "1. doc_title\n2. doc_description\n3. doc_image\n> ");
//            switch(input.nextInt()){
//                case 1:
            input.nextLine();
            System.out.println("Enter new Document Title:");
            resultDoc.setTitle(input.nextLine());
//                    break;
//                case 2:
            System.out.println("Enter new Document Description:");
            resultDoc.setDescription(input.nextLine());
//                    break;
//                case 3:
            System.out.println("Enter new Document Image:");
            resultDoc.setImgFile(input.nextLine());
//                    break;
//            }
            resultDoc.setModifiedDate(date);
            documentDAO.update(resultDoc);
            System.out.println("Item updated on: " + dateFormat.format(date));
        } else {
            System.out.println("Item not found.");
        }
    }

}
