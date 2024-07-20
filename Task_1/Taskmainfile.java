package Task_1;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Taskmainfile {
    public static void main(String[] args) {
        Country country = new Country();
        country.setName("India");

        Region region = new Region();
        region.setName("Tamilnadu");
        region.setCountry(country);

        County county = new County();
        county.setName("Erode District");
        county.setRegion(region);

        Ward ward1 = new Ward();
        ward1.setCode("W001");
        ward1.setName("Kaasipalayam");
        ward1.setCounty(county);

        Ward ward2 = new Ward();
        ward2.setCode("W002");
        ward2.setName("Moolapalayam");
        ward2.setCounty(county);

        Configuration con = new Configuration();
        con.configure("Task_1/cse.cfg.xml");

        SessionFactory sf = con.buildSessionFactory();
        Session ses = sf.openSession();
        Transaction t = ses.beginTransaction();

        ses.persist(country);
        ses.persist(region);
        ses.persist(county);
        ses.persist(ward1);
        ses.persist(ward2);

        t.commit();
        ses.close();
        sf.close();
    }
}
