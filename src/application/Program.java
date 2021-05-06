package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		System.out.println("Enter file path: ");
		String sourceFileStr = sc.nextLine();

		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr = sourceFile.getParent();

		boolean success = new File(sourceFolderStr + "\\out").mkdir();

		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

		try (BufferedReader fileReader = new BufferedReader(new FileReader(sourceFileStr))) {

			String ItemCsv = fileReader.readLine();

			while (ItemCsv != null) {
				String[] item = ItemCsv.split(",");

				String name = item[0];
				double price = Double.parseDouble(item[1]);
				int quantity = Integer.parseInt(item[2]);

				Product prod = new Product(name, price, quantity);
				list.add(prod);
				
				ItemCsv = fileReader.readLine();
			}

			try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(targetFileStr))) {

				for (Product item : list) {
					fileWriter.write(item.getProductName() + "," + String.format("%.2f", item.total()));
					fileWriter.newLine();
				}
				System.out.println(targetFileStr + " CREATED!");
			} catch (IOException e) {
				System.out.println("Error writing  file: " + e.getMessage());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
