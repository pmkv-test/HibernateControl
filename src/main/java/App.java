import app.hibernate.Dispatcher;
import org.hibernate.SessionFactory;


public class App {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();
        SessionFactory sessionFactory = dispatcher.getConfiguration();
        //создание фигур и справочника цветов
        dispatcher.createShape(sessionFactory);
        //выборка фигур с цветом Red
        dispatcher.chooseShapeByColor(sessionFactory,"Red");
        //изменение радиуса круга
        dispatcher.updateCircleRadius(sessionFactory, 50);
    }
}
