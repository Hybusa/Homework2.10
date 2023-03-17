package org.example.storage;

import org.apache.commons.lang3.StringUtils;
import org.example.model.Employee;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class EmployeeBook {

    int Id = 0;

    private final Map<Integer, Employee> employeeHashMap = new HashMap<>();

    public Employee createEmployeeInTheBook() {
        Employee employee= inputCheckAndFormatNameAndReturnEmployee();
        employeeHashMap.put(Id++, employee);
        return employee;
    }

    private Employee inputCheckAndFormatNameAndReturnEmployee() {
        System.out.println("Input Employee name: ");
        Scanner userInput = new Scanner(System.in);
        if (!userInput.hasNextLine())
            throw new InputMismatchException("No input");

        String fullName = userInput.nextLine();
        if (!StringUtils.isAlphaSpace(fullName))
            throw new InputMismatchException("Name must contain only Letters and spaces");

        fullName = StringUtils.trim(fullName);
        String[] names = StringUtils.split(fullName);
        if (names.length > 2)
            throw new InputMismatchException("Name must consist only of Firstname and Lastname");
        return new Employee(StringUtils.capitalize(names[0]),StringUtils.capitalize(names[1]));
    }
}
