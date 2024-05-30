package com.pluralsight.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptService {

    public static void saveReceipt(Order order) {

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String directoryName = "receipts";
        String filename = directoryName + "/" + timestamp + ".txt";

        try {
            // Ensure the directory exists
            Path directoryPath = Paths.get(directoryName);

            if (Files.notExists(directoryPath)) {

                Files.createDirectories(directoryPath);

            }

            // Save the receipt to the file using BufferedWriter
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(order.generateReceipt());
            System.out.println("Receipt saved successfully in " + filename);

        } catch (IOException e) {

            System.out.println("Error saving receipt: " + e.getMessage());

        }
    }

}
