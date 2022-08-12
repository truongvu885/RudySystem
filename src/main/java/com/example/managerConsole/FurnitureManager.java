package com.example.managerConsole;

import com.example.dao.IFurnitureDAO;
import com.example.dao.impl.FurnitureDAO;
import com.example.model.BookOnTape;
import com.example.model.Furniture;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class FurnitureManager {

    private final IFurnitureDAO furnitureDAO = new FurnitureDAO();

    public void inputData(){
        System.out.println("Input furniture data");
        Scanner input = new Scanner(System.in);
        Furniture furniture = new Furniture();
        System.out.print("Name: ");
        furniture.setName(input.nextLine());
        System.out.print("Issue date: ");
        furniture.setIssueDate(Date.valueOf(input.nextLine()));
        System.out.print("Author: ");
        furniture.setAuthor(input.nextLine());
        System.out.print("Price of one day: ");
        furniture.setPrice(Float.parseFloat(input.nextLine()));
        System.out.print("Mass: ");
        furniture.setMass(Float.parseFloat(input.nextLine()));
        System.out.print("Material: ");
        furniture.setMaterial(input.nextLine());
        Long id = furnitureDAO.create(furniture);
        Furniture f = furnitureDAO.findById(id);
        if(f!=null){
            System.out.println("Insert successful");
            System.out.println(f.getDescription());
        }else {
            System.err.println("Insert fail");
        }
    }
    public void showAll(){
        List<Furniture> list = furnitureDAO.findAll();
        if(!list.isEmpty()){
            for (Furniture f: list) {
                System.out.println(f.getDescription());
            }
        }
        else {
            System.err.println("Can't load data");
        }
    }
    public void findById(Long id){
        Furniture f = furnitureDAO.findById(id);
        if(f!=null){
            System.out.println(f.getDescription());
        }
        else {
            System.err.println("Can't find your id "+ id);
        }
    }
}
