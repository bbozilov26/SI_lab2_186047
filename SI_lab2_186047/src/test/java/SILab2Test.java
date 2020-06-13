import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    private SILab2 siLab2 = new SILab2();
    private User userNull = null;

    private User user1 = new User(null, null, null);
    private User user2 = new User("Bojan", null, null);
    private User user3 = new User("Bojan", null, "bobo@boz");
    private User user4 = new User("Bojan", null, "boboboz@b.oz");

    public List<String> allUsers = new ArrayList<>();

    @Test
    public void everyPathFunctionTest() {
        RuntimeException rex;

        // 1,2, 3, 18
        rex = assertThrows(RuntimeException.class, () -> siLab2.function(userNull, allUsers));
        assertTrue(rex.getMessage().contains("The user argument is not initialized!"));

        // 1,2, 4, 5, 18
        rex = assertThrows(RuntimeException.class, () -> siLab2.function(user1, allUsers));
        assertTrue(rex.getMessage().contains("User already exists!"));

        // 1,2, 4, 6, 7, 18
        assertFalse(siLab2.function(user2, allUsers));

        // 1,2, 4, 6, 8, 9.1, (9.2, 10, 11, 12, 13, 14, 9.3), 15, 16, 18
        assertFalse(siLab2.function(user3, allUsers));

        // 1,2, 4, 6, 8, 9.1, (9.2, 10, 11, 12, 13, 14, 9.3), 15, 17, 18
        assertTrue(siLab2.function(user4, allUsers));
    }

    @Test
    public void everyStatementTest(){
        RuntimeException rex;

        rex = assertThrows(RuntimeException.class, () -> siLab2.function(userNull, allUsers));
        assertTrue(rex.getMessage().contains("The user argument is not initialized!"));

        rex = assertThrows(RuntimeException.class, () -> siLab2.function(user1, allUsers));
        assertTrue(rex.getMessage().contains("User already exists!"));

        assertFalse(siLab2.function(user2, allUsers));
        assertFalse(siLab2.function(user3, allUsers));
        assertTrue(siLab2.function(user4, allUsers));
    }

    @Test
    public void multipleConditionTest(){
        RuntimeException re;
        allUsers.add("Filip");
        // true i ??
        re = assertThrows(RuntimeException.class, () -> siLab2.function(user1, allUsers));
        assertTrue(re.getMessage().contains("User already exists!"));

        // false i true
        re = assertThrows(RuntimeException.class, () -> siLab2.function(user2, allUsers));
        assertTrue(re.getMessage().contains("User already exists!"));
        allUsers.remove(0);

        // false i false
        assertTrue(siLab2.function(user4, allUsers));
    }
}
