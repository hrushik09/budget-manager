package budget;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class SaveData {
    static String pathToFile = "purchases.txt";

    static void writeData() throws IOException {
        File file = new File(pathToFile);
        try (FileWriter writer = new FileWriter(file)) {

            // Balance
            writer.write("Balance\r\n");
            writer.write(String.format("%.2f\r\n", Main.balance));
            writer.write("\r\n");

            // Food
            for (Map.Entry<Double, String> entry : Food.map.entrySet()) {
                writer.write("Food\r\n");
                writer.write(String.format("%s\r\n", entry.getValue()));
                writer.write(String.format("%.2f\r\n", entry.getKey()));
            }

            // Clothes
            for (Map.Entry<Double, String> entry : Clothes.map.entrySet()) {
                writer.write("Clothes\r\n");
                writer.write(String.format("%s\r\n", entry.getValue()));
                writer.write(String.format("%.2f\r\n", entry.getKey()));
            }

            // Entertainment
            for (Map.Entry<Double, String> entry : Entertainment.map.entrySet()) {
                writer.write("Entertainment\r\n");
                writer.write(String.format("%s\r\n", entry.getValue()));
                writer.write(String.format("%.2f\r\n", entry.getKey()));
            }

            // Other
            for (Map.Entry<Double, String> entry : Other.map.entrySet()) {
                writer.write("Other\r\n");
                writer.write(String.format("%s\r\n", entry.getValue()));
                writer.write(String.format("%.2f\r\n", entry.getKey()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + pathToFile);
        }

        System.out.println("Purchases were loaded!");
        System.out.println();
        Main.mainMenu();
    }
}
