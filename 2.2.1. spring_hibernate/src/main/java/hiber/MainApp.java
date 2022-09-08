package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("User1", "Name11","Name11@gmail.com");
      User user2 = new User("User2", "Name22","Name22@gmail.com");
      User user3 = new User("User3", "Name33","Name33@gmail.com");
      User user4 = new User("User4", "Name44","Name44@gmail.com");

      user1.setCar(new Car("Audi", 1111));
      user2.setCar(new Car("BMW", 2222));
      user3.setCar(new Car("Merseders", 3333));
      user4.setCar(new Car("Ford", 4444));

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();

      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("User's car = "+ user.getCar());
         System.out.println();
      }
      System.out.println(userService.getUserByCar("Ford", 4444));

      context.close();
   }
}
