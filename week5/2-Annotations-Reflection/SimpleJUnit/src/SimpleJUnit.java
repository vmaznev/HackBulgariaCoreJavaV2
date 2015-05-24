
public class SimpleJUnit {
    
    @Before
    public void init() {
        System.out.println("BEFORE EVERY METHOD...!");
    }

    @Execute
    public void firstRandomTest() {
        System.out.println("First Random Test...!");
    }

    @Execute
    public void secondRandomTest() {
        System.out.println("Second Random Test...!");
    }

    @After
    public void afterTest() {
        System.out.println("AFTER EVERY METHOD...!");
        System.out.println();
    }
}
