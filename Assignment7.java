import java.io.*;
import java.util.Scanner;

public class Assignment7 {
  //Method to create a new file
  public static void CreateNewFile(String filename) {
    try {
      File file = new File(filename);
      if(file.createNewFile()) {
        System.out.println("Your file created: "+file.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch(IOException e) {
      System.out.println("Error creating the file.");
    }
  }
  //Method to write(overwrite) content to the file
  public static void WriteFile(String filename, Scanner sc) {
    
    FileWriter writer = null;
    try {
      writer = new FileWriter(filename, false);
      System.out.println("Enter a paragraph: ");
      String para = sc.nextLine();
      writer.write(para);
      System.out.println("Content writing done");
    } catch(IOException e) {
      System.out.println("Error writing to file.");
    }finally {
      try {
        if(writer != null) {
          writer.close();
        }
      } catch(IOException e) {
        System.out.println("Error in closing the writer.");
      }
    }
  }
  //method to append content to the file
  public static void AppendFile(String filename, Scanner sc) {
    FileWriter writer = null;
    try {
      writer = new FileWriter(filename, true);
      System.out.println("Enter text to append: ");
      String content = sc.nextLine();
      writer.write("\n"+content);
      System.out.println("Content added");
    } catch(IOException e) {
      System.out.println("Error in adding content to file");
    }finally {
      try{
        if(writer != null) {
          writer.close();
        }
      } catch(IOException e) {
        System.out.println("Error in closing the writer.");
      }
    }
    
  }
  public static void ReadFile(String filename) {
    BufferedReader read = null;
    try {
      read = new BufferedReader(new FileReader(filename));
      String line;
      System.out.println("File Contents: ");
      while((line = read.readLine()) != null) {
        System.out.println(line);
      }
    }catch(FileNotFoundException e) {
      System.out.println("file not found");
    }catch(IOException e) {
      System.out.println("Error in reading the file.");
    }finally {
      try {
        if(read != null) {
          read.close();
        }
      }catch(IOException e) {
        System.out.println("error in closing reader.");
      }
    }
  }
  //method to delete the file
  public static void DeleteFile(String filename) {
    File file = new File(filename);
    if(file.exists()) {
      if(file.delete()) {
        System.out.println("File deleted");
      } else {
        System.out.println("Failed to delete the file");
      }
    } else {
      System.out.println("File does not exist.");
    }
  }

  //Main method which is menu driven
  public static void main(String[] args) {
    if(args.length == 0) {
      System.out.println("please provide the filename as a command-line argument");
      return;
    }
    //GetFilename from command-line argument
    String filename = args[0];
    Scanner sc = new Scanner(System.in);
    int choice;
    do {
      System.out.println("---------File Menu----------");
      System.out.println("0. Exit");
      System.out.println("1. Create New File");
      System.out.println("2. Write to file");
      System.out.println("3. Append to file");
      System.out.println("4. Read File");
      System.out.println("5. Delete file");
      System.out.print("Enter your choice: ");
      choice = sc.nextInt();
      switch(choice) {
        case 0:
              System.out.println("Exiting the program");
              break;
        case 1:
              CreateNewFile(filename);
              break;
        case 2:
              sc.nextLine();
              WriteFile(filename, sc);
              break;
        case 3: 
              sc.nextLine();
              AppendFile(filename, sc);
              break;
        case 4:
              ReadFile(filename);
              break;
        case 5:
              DeleteFile(filename);
              break;
        default:
              System.out.println("Invalid choice. Try again");
      }
      
    }while(choice != 0);
    sc.close();
  }
}