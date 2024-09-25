package com.hql_query.query_project;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "program execution started!" );
		/*
		 * Employee e1 = new Employee(); e1.setEid(110); e1.setEname("ramesh");
		 * e1.setDepartment("IT");
		 * 
		 * Employee e2 = new Employee(); e2.setEid(111); e2.setEname("kamesh");
		 * e2.setDepartment("cs");
		 * 
		 * Employee e3 = new Employee(); e3.setEid(112 ); e3.setEname("tamesh");
		 * e3.setDepartment("bs");
		 */
        
        Configuration con = new Configuration();
        con.configure();
        con.addAnnotatedClass(Employee.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction trans = session.beginTransaction();
		/*
		 * session.save(e1); session.save(e2); session.save(e3);
		 */
		
		 // Query q = session.createQuery("from Employee");//got all employee data present in database
		  //List<Employee>emp = q.list(); 
		  //for(Employee employee :  emp)
		      //{
			  //System.out.println(employee); 
			  //}
		 
        Query query = session.createQuery("from Employee e where e.eid=110 ");
        Employee emp =(Employee)query.uniqueResult();//typecast
        System.out.println(emp);//got all data of eid 110 only
        System.out.println(emp.getEid()+ " " +emp.getEname());//got only eid and ename
        
        Query q1 = session.createQuery("select eid,ename,department from Employee where eid=111");
        Object[]obj =(Object[])q1.uniqueResult();//here fetching diff-types of data so object[] type is used and typecast it 
        for(Object o :obj)
        {
        	System.out.println(o);
        }
      //System.out.println(obj[0]+ " " +obj[1]+ " " +obj[2]);//another way
        //without using where clouse 
        Query q2=session.createQuery("select eid,ename,department from Employee");
        List<Object[]>object = (List<Object[]>)q2.list();
        for(Object[] ob :object)
        {
        	System.out.println(ob[0] + " " + ob[1] + " " + ob[2]);
        }
        Query q3 = session.createQuery("select e.ename from Employee e where e.eid=112");
        String s =(String) q3.uniqueResult();
        System.out.println(s);
		/*
		 * Query q4 =
		 * session.createQuery("select e.eid from Employee e where e.ename=tamesh");
		 * Integer i = (Integer) q4.uniqueResult(); System.out.println(i);
		 */
         
        trans.commit();
        session.close();
        System.out.println("!program execution ended");
       
    }
}
