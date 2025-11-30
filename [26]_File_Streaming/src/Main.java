import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // readFile(); 
    		// try
	        // print only the first 100 line
	        // print only those that starts with letter A
        
         writeFile();
    		// try
    		// prompt user to enter name, age, gender, address and write to file
    		
        // addLine();
    		// try
    		// Each time the program runs, ask the user to enter a diary entry and append it to diary.txt.
    	
        // deleteFile();
    		
        // renameFile();
    	
        // createFolder();
         
        // createFolder2();
    	
    	// seeFileList();
    	
    	
		// ------------------------section challenge----------------------------
    	// try - READ THIS ------->>>> Write this code inside project File_Streaming_2
	
		// create a folder named MainFolder
		// inside MainFolder, create folder for each name inside passers.txt
			// folder name must be in this format LASTNAME_FIRST_NAME_MIDDLENAME
				// inside their folder, create a text file named info.txt
				// write this info inside info.txt
					// Name: their name
					// Age: Random number from 18 - 30
					// Gender: random between male/female
		// Additional note:
			// generating folder name must be in a separate method that accept and returns a string
			// as well as generating random number from 18 - 30, random gender must have separate methods
    		
    		
    	
    }
    
    public static void readFile() {
        try {
            File file = new File("passers.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);   
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }
    
    public static void writeFile() {
        try {
            FileWriter writer = new FileWriter("sample.txt");
            writer.write("Francisco kaleb");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }
    
    public static void addLine() {
        String filename = "sample.txt";
        String newLine = "This is the new line I want to add.";
        try {
            FileWriter fw = new FileWriter(filename, true); // true = append mode
            fw.write(newLine + System.lineSeparator());     // add newline after writing
            fw.close();
            System.out.println("Line added successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }



    public static void deleteFile() {
        File file = new File("sample.txt");
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
    

    public static void renameFile() {
        File oldFile = new File("sample.txt");
        File newFile = new File("renamed_sample.txt");
        if (oldFile.renameTo(newFile)) {
            System.out.println("File renamed successfully!");
        } else {
            System.out.println("Failed to rename the file.");
        }
    }
    

    public static void createFolder() {
        File folder = new File("MyFolder");
        if (folder.mkdir()) {
            System.out.println("Folder created: " + folder.getName());
        } else {
            System.out.println("Failed to create folder (it may already exist).");
        }
    }
    
    
    public static void createFolder2() {
        File folder = new File("MyFolder//new");
        if (folder.mkdir()) {
            System.out.println("Folder created: " + folder.getName());
        } else {
            System.out.println("Failed to create folder (it may already exist).");
        }
    }
    
    
    public static void seeFileList() {
    	File folder = new File("MyFolder"); // change to your folder name
        File[] files = folder.listFiles();

        if (files != null) {
            System.out.println("Files in folder: " + folder.getName());
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("[file] " + file.getName()); // print filename only
                }
                else {
                	System.out.println("[folder] " + file.getName()); // print folder
                }
            }
        } else {
            System.out.println("Folder not found or empty.");
        }
    }
}
