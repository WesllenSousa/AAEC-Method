package util;

import entidades.activity_appliance.ActivityApplianceBean;
import entidades.activity_appliance.ActivityApplianceViewBean;
import entidades.activity_data.ActivitiesViewBean;
import entidades.activity_data.ActivityDataBean;
import entidades.activity_data.AverageActivitiesBean;
import entidades.activity_data.ReconhecerAtividadeBean;
import entidades.activity_location.ActivityLocationBean;
import entidades.appliances.AppliancesBean;
import entidades.classes.ClassesBean;
import entidades.locations.LocationsBean;
import entidades.sensor_data.AverageSensorBean;
import entidades.sensor_data.LocalSensorBean;
import entidades.sensor_data.SensorDataBean;
import entidades.sensor_data.SensorsBean;
import entidades.sensor_heading.SensorHeadingBean;
import entidades.type_appliance.TypeApplianceBean;
import entidades.types.TypesBean;
import entidades.week_day.WeekDayBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Wesllen Sousa Lima
 */

public class Conexao {

    private static final SessionFactory sessionFactory;
    public static final ThreadLocal thread = new ThreadLocal();

    static {
        try {
            AnnotationConfiguration configuration = new AnnotationConfiguration();  
            configuration.addAnnotatedClass(ActivityApplianceBean.class);  
            configuration.addAnnotatedClass(ActivityDataBean.class);    
            configuration.addAnnotatedClass(ActivityLocationBean.class);    
            configuration.addAnnotatedClass(AppliancesBean.class);   
            configuration.addAnnotatedClass(ClassesBean.class);
            configuration.addAnnotatedClass(LocationsBean.class);   
            configuration.addAnnotatedClass(SensorDataBean.class);
            configuration.addAnnotatedClass(SensorHeadingBean.class);
            configuration.addAnnotatedClass(TypeApplianceBean.class);
            configuration.addAnnotatedClass(TypesBean.class);
            configuration.addAnnotatedClass(WeekDayBean.class);   
            configuration.addAnnotatedClass(ActivitiesViewBean.class);  
            configuration.addAnnotatedClass(ActivityApplianceViewBean.class);  
            configuration.addAnnotatedClass(AverageActivitiesBean.class);
            configuration.addAnnotatedClass(AverageSensorBean.class);
            configuration.addAnnotatedClass(LocalSensorBean.class); 
            configuration.addAnnotatedClass(SensorsBean.class);  
            configuration.addAnnotatedClass(ReconhecerAtividadeBean.class);
            sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();         
            //sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        Session s = (Session) thread.get();
        if (s == null) {
            s = sessionFactory.openSession();
            thread.set(s);
        }
        return s;
    }

    public static void closeSession() {
        Session s = (Session) thread.get();
        if (s != null) {
            s.close();
        }
        s = null;
        thread.set(null);
    }
    
}