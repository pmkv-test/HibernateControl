package app.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {


    public void chooseShapeByColor(SessionFactory sf, String nameColor) {
        Session sessionRead = null;
        Transaction trRead = null;
        try {
            sessionRead = sf.openSession();
            trRead = sessionRead.beginTransaction();
            String hqlCircle = "select cr.id, cr.nameColor, 'circle' as name from Circle cl inner join ShapeColor cr ON cl.shapeColor.Id = cr.id where cr.nameColor = :paramColor";
            List<Object[]> circleResult = getQuery(nameColor, sessionRead, hqlCircle);
            String hqlRectangle = "select cr.id, cr.nameColor, 'rectangle' as name from Rectangle rtg inner join ShapeColor cr ON rtg.shapeColor.Id = cr.id where cr.nameColor = :paramColor";
            List<Object[]> rectangleResult = getQuery(nameColor, sessionRead, hqlRectangle);
            String hqlRhomb = "select cr.id, cr.nameColor, 'rhomb' as name from Rhomb rb inner join ShapeColor cr ON rb.shapeColor.Id = cr.id where cr.nameColor = :paramColor";
            List<Object[]> rhombResult = getQuery(nameColor, sessionRead, hqlRhomb);
            trRead.commit();
            sessionRead.close();
            List<Object[]> shapeAll = new ArrayList<>();
            shapeAll.addAll(circleResult);
            shapeAll.addAll(rectangleResult);
            shapeAll.addAll(rhombResult);

            for (Object[] obj : shapeAll) {
                String colorShape = (String) obj[1];
                String nameShape = (String) obj[2];
                System.out.println("color= " + colorShape + " > shape= " + nameShape);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            trRead.rollback();
        } finally {
            sessionRead.close();
        }
    }

    private List<Object[]> getQuery(Object nameColor, Session sessionRead, String hql) {
        Query queryShape = sessionRead.createQuery(hql);
        queryShape.setParameter("paramColor", nameColor);
        List<Object[]> queryShapeResult = queryShape.getResultList();
        return queryShapeResult;
    }

    public void createShape(SessionFactory sf) {
        Session sessionCreate = null;
        Transaction trCreate = null;
        try {
            sessionCreate = sf.openSession();
            trCreate = sessionCreate.beginTransaction();
            ShapeColor shapeColorRed = new ShapeColor("Red", "255, 0, 0"); //rgb(255, 0, 0) - red
            ShapeColor shapeColorGreen = new ShapeColor("Green", "0, 255, 0"); //rgb(0, 255, 0) - green
            ShapeColor shapeColorAqua = new ShapeColor("Aqua", "0, 255, 0"); //rgb(0, 255, 255) - aqua
            Circle circle = new Circle(25);
            circle.setShapeColor(shapeColorAqua);
            Rectangle rectangle = new Rectangle(30, 60);
            rectangle.setShapeColor(shapeColorRed);
            Rhomb rhomb = new Rhomb(40);
            rhomb.setShapeColor(shapeColorRed);
            sessionCreate.save(shapeColorRed);
            sessionCreate.save(shapeColorGreen);
            sessionCreate.save(shapeColorAqua);
            sessionCreate.save(circle);
            sessionCreate.save(rectangle);
            sessionCreate.save(rhomb);
            trCreate.commit();
            sessionCreate.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            trCreate.rollback();
        } finally {
            sessionCreate.close();
        }
    }

    public SessionFactory getConfiguration() {
        Configuration con = new Configuration().configure();
        con.addAnnotatedClass(ShapeColor.class);
        con.addAnnotatedClass(Circle.class);
        con.addAnnotatedClass(Rectangle.class);
        con.addAnnotatedClass(Rhomb.class);
        StandardServiceRegistryBuilder sBuilder = new StandardServiceRegistryBuilder()
                .applySettings(con.getProperties());
        SessionFactory sf = con.buildSessionFactory(sBuilder.build());
        return sf;
    }

    public void updateCircleRadius(SessionFactory sf, Integer circleRadius) {
        Session sessionUpdate = null;
        Transaction trUpdate = null;
        try {
            sessionUpdate = sf.openSession();
            trUpdate = sessionUpdate.beginTransaction();
            Query queryShape = sessionUpdate.createQuery("update Circle cl set cl.radius = :paramColor");
            queryShape.setParameter("paramColor", circleRadius);
            queryShape.executeUpdate();
            trUpdate.commit();
            sessionUpdate.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            trUpdate.rollback();
        } finally {
            sessionUpdate.close();
        }
    }
}
