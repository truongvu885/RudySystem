package com.example;

import com.example.managerConsole.BookTapeManager;
import com.example.managerConsole.FurnitureManager;
import com.example.managerConsole.RentVideoManager;
import com.example.managerConsole.VideosManager;

import java.util.Scanner;


public class RudySystemMain {

    public static final VideosManager videosManager = new VideosManager();
    public static final BookTapeManager bookTapeManager = new BookTapeManager();
    public static final FurnitureManager furnitureManager = new FurnitureManager();
    public static final RentVideoManager rentVideoManager = new RentVideoManager();

    public static void main(String[] args) {
        int choice;
        do{
            Scanner input = new Scanner(System.in);
            menu();
            System.out.print("Your choice: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice){
                case 0:
                    System.exit(0);
                case 1:
                    int c;
                    do {
                        systemMenu();
                        System.out.print("Your choice: ");
                        c = Integer.parseInt(input.nextLine());
                        switch (c){
                            case 0:
                                break;
                            case 1:
                                int cv;
                                do {
                                    videoManagerMenu();
                                    System.out.print("Your choice: ");
                                    cv = Integer.parseInt(input.nextLine());
                                    switch (cv){
                                        case 0:
                                            break;
                                        case 1:
                                            videosManager.inputData();
                                            break;
                                        case 2:
                                            videosManager.showAll();
                                            break;
                                        case 3:
                                            System.out.print("Input serial number: ");
                                            Long id = Long.parseLong(input.nextLine());
                                            videosManager.findById(id);
                                            break;
                                        case 4:
                                            videosManager.sortVideosAsc();
                                            break;
                                        case 5:
                                            videosManager.sortVideosDesc();
                                            break;
                                        default:
                                            System.err.println("Please choice again");
                                            break;
                                    }
                                }while (cv!=0);
                                break;
                            case 2:
                                int cb;
                                do {
                                    bookTapeManagerMenu();
                                    System.out.print("Your choice: ");
                                    cb = Integer.parseInt(input.nextLine());
                                    switch (cb){
                                        case 0:
                                            break;
                                        case 1:
                                            bookTapeManager.inputData();
                                            break;
                                        case 2:
                                            bookTapeManager.showAll();
                                            break;
                                        case 3:
                                            System.out.print("Input serial number: ");
                                            Long id = Long.parseLong(input.nextLine());
                                            bookTapeManager.findById(id);
                                            break;
                                        default:
                                            System.err.println("Please choice again");
                                            break;
                                    }
                                }while (cb!=0);
                                break;
                            case 3:
                                int cf;
                                do {
                                    furnitureManagerMenu();
                                    System.out.print("Your choice: ");
                                    cf = Integer.parseInt(input.nextLine());
                                    switch (cf){
                                        case 0:
                                            break;
                                        case 1:
                                            furnitureManager.inputData();
                                            break;
                                        case 2:
                                            furnitureManager.showAll();
                                            break;
                                        case 3:
                                            System.out.print("Input serial number: ");
                                            Long id = Long.parseLong(input.nextLine());
                                            furnitureManager.findById(id);
                                            break;
                                        default:
                                            System.err.println("Please choice again");
                                            break;
                                    }
                                }while (cf!=0);
                                break;
                            default:
                                System.err.println("Please choice again");
                                break;
                        }
                    }while (c!=0);
                        break;
                case 2:
                    int cr ;
                    do {
                        rentVideoManagerMenu();
                        System.out.print("Your choice: ");
                        cr = Integer.parseInt(input.nextLine());
                        switch (cr){
                            case 0:
                                break;
                            case 1:
                                rentVideoManager.inputData();
                                break;
                            case 2:
                                rentVideoManager.showAll();
                                break;
                            default:
                                System.err.println("Please choice again");
                                break;
                        }
                    }while (cr!=0);
                    break;
                default:
                    System.err.println("Please choice again");
                    break;
            }

        }while (choice!=0);
    }
    public static void menu(){
        System.out.println("------------------------------");
        System.out.println("----RUDY SYSTEM MANAGER-----");
        System.out.println("0. Exit");
        System.out.println("1. System manager");
        System.out.println("2. Rent");
    }
    public static void systemMenu(){
        System.out.println("---------------------");
        System.out.println("----SYSTEM MANAGER------");
        System.out.println("0. Exit");
        System.out.println("1. Video manager");
        System.out.println("2. Book on tape manager");
        System.out.println("3. Furniture manager");
    }
    public static void videoManagerMenu(){
        System.out.println("---------------------");
        System.out.println("-----VIDEO MANAGER------");
        System.out.println("0. Exit");
        System.out.println("1. Input video data");
        System.out.println("2. Show video data");
        System.out.println("3. Input serial number search");
        System.out.println("4. Sort video list ASC");
        System.out.println("5. Sort video list DESC");
    }
    public static void bookTapeManagerMenu(){
        System.out.println("---------------------");
        System.out.println("---BOOK ON TAPE MANAGER---");
        System.out.println("0. Exit");
        System.out.println("1. Input book on tape data");
        System.out.println("2. Show book on tape data");
        System.out.println("3. Input serial number search");
    }
    public static void furnitureManagerMenu(){
        System.out.println("---------------------");
        System.out.println("-----FURNITURE MANAGER------");
        System.out.println("0. Exit");
        System.out.println("1. Input furniture data");
        System.out.println("2. Show furniture data");
        System.out.println("3. Input serial number search");
    }
    public static void rentVideoManagerMenu(){
        System.out.println("-----------------------");
        System.out.println("------RENTAL VIDEO-------");
        System.out.println("0. Exit");
        System.out.println("1. Input rental video data");
        System.out.println("2. Show rental video data");
        System.out.println("3. Input serial number search");
    }
    public static void rentBookTapeManagerMenu(){
        System.out.println("-----------------------");
        System.out.println("------RENTAL BOOK ON TAPE-------");
        System.out.println("0. Exit");
        System.out.println("1. Input rental book on tape data");
        System.out.println("2. Show rental book on tape data");
        System.out.println("3. Input serial number search");
    }


}
