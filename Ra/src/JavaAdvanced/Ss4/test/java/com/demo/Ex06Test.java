//package JavaAdvanced.Ss4.test.java.com.demo;
//
//
////import Ss4.main.java.com.demo.Ex06.User;
////import Session04.main.java.com.demo.Ex06.UserProfile;
////import Session04.main.java.com.demo.Ex06.UserService;
//import JavaAdvanced.Ss4.main.java.com.demo.Ex06.User;
//import JavaAdvanced.Ss4.main.java.com.demo.Ex06.UserProfile;
//import JavaAdvanced.Ss4.main.java.com.demo.Ex06.UserService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//class UserServiceTest {
//
//    private UserService userService;
//    private User existingUser;
//
//    @BeforeEach
//    void setUp() {
//        userService = new UserService();
//        existingUser = new User("old@gmail.com", LocalDate.of(2000,1,1));
//    }
//
//    @Test
//    void updateProfileSuccessfully() {
//
//        UserProfile newProfile = new UserProfile(
//                "new@gmail.com",
//                LocalDate.of(1999,5,5)
//        );
//
//        List<User> users = new ArrayList<>();
//
//        User result = userService.updateProfile(existingUser,newProfile,users);
//
//        assertNotNull(result);
//    }
//
//    @Test
//    void rejectFutureBirthDate() {
//
//        UserProfile newProfile = new UserProfile(
//                "new@gmail.com",
//                LocalDate.now().plusDays(1)
//        );
//
//        List<User> users = new ArrayList<>();
//
//        User result = userService.updateProfile(existingUser,newProfile,users);
//
//        assertNull(result);
//    }
//
//    @Test
//    void rejectDuplicateEmail() {
//
//        UserProfile newProfile = new UserProfile(
//                "duplicate@gmail.com",
//                LocalDate.of(1999,5,5)
//        );
//
//        List<User> users = new ArrayList<>();
//        users.add(new User("duplicate@gmail.com", LocalDate.of(1990,1,1)));
//
//        User result = userService.updateProfile(existingUser,newProfile,users);
//
//        assertNull(result);
//    }
//
//    @Test
//    void allowSameEmailAsExistingUser() {
//
//        UserProfile newProfile = new UserProfile(
//                "old@gmail.com",
//                LocalDate.of(1998,1,1)
//        );
//
//        List<User> users = new ArrayList<>();
//        users.add(existingUser);
//
//        User result = userService.updateProfile(existingUser,newProfile,users);
//
//        assertNotNull(result);
//    }
//
//    @Test
//    void allowUpdateWhenUserListEmpty() {
//
//        UserProfile newProfile = new UserProfile(
//                "new@gmail.com",
//                LocalDate.of(1995,5,5)
//        );
//
//        List<User> users = new ArrayList<>();
//
//        User result = userService.updateProfile(existingUser,newProfile,users);
//
//        assertNotNull(result);
//    }
//
//    @Test
//    void rejectFutureBirthDateAndDuplicateEmail() {
//
//        UserProfile newProfile = new UserProfile(
//                "duplicate@gmail.com",
//                LocalDate.now().plusDays(5)
//        );
//
//        List<User> users = new ArrayList<>();
//        users.add(new User("duplicate@gmail.com", LocalDate.of(1990,1,1)));
//
//        User result = userService.updateProfile(existingUser,newProfile,users);
//
//        assertNull(result);
//    }
//}