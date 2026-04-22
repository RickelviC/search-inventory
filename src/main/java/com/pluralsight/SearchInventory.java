package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SearchInventory {
    private static final String CVS_File = "inventory.csv";

    public static void main(String[] args) {
        List<Product> inventory = getInventory();

        for (Product product : inventory) {
            System.out.println(product);
        }

    }

    public static List<Product> getInventory() {
        List<Product> inventory = new ArrayList<>();

        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(CVS_File));

            while ((line = reader.readLine()) != null) {

                String[] divider = line.split("\\|");
                int id = Integer.parseInt(divider[0]);
                String name = divider[1];
                double price = Double.parseDouble(divider[2]);

                inventory.add(new Product(id,name,price));

            }

        } catch (Exception ex) {
            System.err.println("Something went wrong");
        }

        inventory.sort(Comparator.comparing(Product::getName));
        // Write your code here
        return inventory;
    }
}
