//package JavaAdvanced.Ss4.main.java.com.demo.Ex05.Ss4.test.java.com.demo;
//
//
//import Session04.main.java.com.demo.Ex05.Action;
//import Session04.main.java.com.demo.Ex05.PermissionService;
//import Session04.main.java.com.demo.Ex05.Role;
//import Session04.main.java.com.demo.Ex05.User;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//class Ex05Test {
//    private PermissionService permissionService;
//
//    @BeforeEach
//    void setUp() {
//        permissionService = new PermissionService();
//    }
//
//    @AfterEach
//    void tearDown() {
//        permissionService = null;
//    }
//
//    // ADMIN TEST
//
//    @Test
//    void adminCanDeleteUser() {
//        User admin = new User(Role.ADMIN);
//
//        boolean result = permissionService.canPerformAction(admin, Action.DELETE_USER);
//
//        assertTrue(result);
//    }
//
//    @Test
//    void adminCanLockUser() {
//        User admin = new User(Role.ADMIN);
//
//        boolean result = permissionService.canPerformAction(admin, Action.LOCK_USER);
//
//        assertTrue(result);
//    }
//
//    @Test
//    void adminCanViewProfile() {
//        User admin = new User(Role.ADMIN);
//
//        boolean result = permissionService.canPerformAction(admin, Action.VIEW_PROFILE);
//
//        assertTrue(result);
//    }
//
//    // MODERATOR TEST
//
//    @Test
//    void moderatorCannotDeleteUser() {
//        User mod = new User(Role.MODERATOR);
//
//        boolean result = permissionService.canPerformAction(mod, Action.DELETE_USER);
//
//        assertFalse(result);
//    }
//
//    @Test
//    void moderatorCanLockUser() {
//        User mod = new User(Role.MODERATOR);
//
//        boolean result = permissionService.canPerformAction(mod, Action.LOCK_USER);
//
//        assertTrue(result);
//    }
//
//    @Test
//    void moderatorCanViewProfile() {
//        User mod = new User(Role.MODERATOR);
//
//        boolean result = permissionService.canPerformAction(mod, Action.VIEW_PROFILE);
//
//        assertTrue(result);
//    }
//
//    // USER TEST
//
//    @Test
//    void userCannotDeleteUser() {
//        User user = new User(Role.USER);
//
//        boolean result = permissionService.canPerformAction(user, Action.DELETE_USER);
//
//        assertFalse(result);
//    }
//
//    @Test
//    void userCannotLockUser() {
//        User user = new User(Role.USER);
//
//        boolean result = permissionService.canPerformAction(user, Action.LOCK_USER);
//
//        assertFalse(result);
//    }
//
//    @Test
//    void userCanViewProfile() {
//        User user = new User(Role.USER);
//
//        boolean result = permissionService.canPerformAction(user, Action.VIEW_PROFILE);
//
//        assertTrue(result);
//    }
//}