import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Assignment8 {
  //method to check eligibility
  public static String checkEligibility(String category, int age, int score, String post) throws InvalidAgeException, InvalidScoreException, NotQualifiedException {
    if(age <= 0 || age > 100) {
      throw new InvalidAgeException("age must be between 1 to 100");
    }
    if(score < 0 || score > 300) {
      throw new InvalidScoreException("Score must be between 0 and 300.");
    }
    category = category.toUpperCase();
    post = post.toUpperCase();

    if(post.equals("JRF")) {
      if(category.equals("GENERAL") && score >= 200 && age <= 30) {
        return "Eligible for JRF";
      } else if(!category.equals("GENERAL") && score >= 190 && age <= 35) {
        return "Eligible for JRF";
      }else {
        throw new NotQualifiedException("Not Eligible for JRF");
      }

    }else if(post.equals("ASSISTANT PROFESSOR")) {
      if(category.equals("GENERAL") && score >= 180) {
        return "Eligible for Assitant Professor";
      }else if(!category.equals("GENERAL") && score >= 170) {
        return "Eligible for Assistant Professor";
      } else {
        throw new NotQualifiedException("Not Eligible for Assistant professor");
      }
    }else if(post.equals("PHD ONLY")) {
      if(score >= 150) {
        return "Eligible for PhD only";
      } else {
        throw new NotQualifiedException("Not eligible for phd");
      }

    }else {
      throw new NotQualifiedException("Invalid post Entered");
    }
  }

  //method to save in file
  public static void saveToFile(String content) {
    try {
      FileWriter writer = new FileWriter("ugcnet_profiles.txt", true);
      writer.write(content+"\n\n");
      writer.close();
    } catch(IOException e) {
      System.out.println("Error in saving to file");
    }
  }

  //main method
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    try {
      System.out.print("Enter Name: ");
      String name = sc.nextLine();

      System.out.print("Enter age: ");
      int age = sc.nextInt();
      sc.nextLine();

      System.out.print("Enter category (General/Sc/ST/OBC/EWS): ");
      String category = sc.nextLine();

      System.out.print("Enter Score (out of 300): ");
      int score = sc.nextInt();
      sc.nextLine();

      System.out.print("Enter Applied post(JRF/Assistant Professor/PhD only): ");

      String post = sc.nextLine();

      String result = checkEligibility(category, age, score, post);

      //data to save in file

      String profile = "Name: "+name+
                       "\nAge: "+age+
                       "\nCategory: "+category+
                       "\nApplied post: "+post+
                       "\nEligibility Result: "+ result;

      System.out.println("\n"+result);
      saveToFile(profile);

    }catch(InvalidAgeException | InvalidScoreException | NotQualifiedException e) {
      System.out.println("Error: "+e.getMessage());
    }catch(Exception e) {
      System.out.println("unexpected error occured. please check your input.");
    }finally {
      sc.close();
    }
  }

}
class InvalidAgeException extends Exception {
  public InvalidAgeException(String message) {
    super(message);
  }
}
class InvalidScoreException extends Exception {
  public InvalidScoreException(String message) {
    super(message);
  }
}
class NotQualifiedException extends Exception {
  public NotQualifiedException(String message) {
    super(message);
  }
}