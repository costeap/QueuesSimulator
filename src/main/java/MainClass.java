import java.io.FileNotFoundException;

public class MainClass {
    public static void main(String[] args) throws FileNotFoundException {
        View db = new View();
        Controller controller = new Controller(db);
        db.setVisible(true);
        
    }

}
