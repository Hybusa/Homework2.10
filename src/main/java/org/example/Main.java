package org.example;

import org.example.storage.EmployeeBook;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        System.out.println(employeeBook.createEmployeeInTheBook());
    }
}