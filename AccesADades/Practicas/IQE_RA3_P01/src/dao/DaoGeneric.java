/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.clan;
import model.jugador;
import model.partides;
import org.hibernate.*;
import util.HibernateUtil;

/**
 *
 * @author Usuari
 */
public class DaoGeneric {
    
    public static DaoGeneric daoGeneric = null;
    
    private SessionFactory factory;
    private Transaction transaction;

    public DaoGeneric() {
        factory = HibernateUtil.getSessionFactory();
    }
    
    public static DaoGeneric getInstance(){
        if(daoGeneric==null){
            daoGeneric=new DaoGeneric();
        }
        return daoGeneric;
    }
    
    public boolean create(Object o){
        boolean retorn = false;
        Session sessio = factory.openSession();
        try{
            transaction = sessio.beginTransaction();
            sessio.save(o);
            transaction.commit();
            retorn=true;
            
        }
        catch (Exception e){
            transaction.rollback();
            retorn = false;
            e.printStackTrace();
        } finally{
            sessio.close();
        }
        return retorn;
    }
    
    public boolean delete(int id) {
       boolean retorn = false;
        Session sessio = factory.openSession();
        try{
            transaction = sessio.beginTransaction();
            
            jugador o = (jugador) sessio.load(jugador.class, id);
       
      //first load() method example
     
            sessio.delete(o);
            transaction.commit();
            retorn=true;
            
        }
        catch (Exception e){
            transaction.rollback();
            retorn = false;
            e.printStackTrace();
        } finally{
            sessio.close();
        }
        return retorn;
    }
    
    public List readJugador(){
        List result=null;
        try {
        Session sessio = factory.openSession();
        sessio.beginTransaction();
        Query q = sessio.createQuery("from jugador");
        result = (List) q.list();
        
        //sessio.getTransaction().commit();
    } catch (HibernateException he) {
        he.printStackTrace();
    }
        return result;
    }
    
    public boolean deletePart(int id) {
       boolean retorn = false;
        Session sessio = factory.openSession();
        try{
            transaction = sessio.beginTransaction();
            
            partides o = (partides) sessio.load(partides.class, id);
       
      //first load() method example
     
            sessio.delete(o);
            transaction.commit();
            retorn=true;
            
        }
        catch (Exception e){
            transaction.rollback();
            retorn = false;
            e.printStackTrace();
        } finally{
            sessio.close();
        }
        return retorn;
    }
    
    public List readPartida(){
        List result=null;
        try {
        Session sessio = factory.openSession();
        sessio.beginTransaction();
        Query q = sessio.createQuery("from partides");
        result = (List) q.list();
        
        //sessio.getTransaction().commit();
    } catch (HibernateException he) {
        he.printStackTrace();
    }
        return result;
    }
    
    public boolean deleteClan(int id) {
       boolean retorn = false;
        Session sessio = factory.openSession();
        try{
            transaction = sessio.beginTransaction();
            
            clan o = (clan) sessio.load(clan.class, id);
       
      //first load() method example
     
            sessio.delete(o);
            transaction.commit();
            retorn=true;
            
        }
        catch (Exception e){
            transaction.rollback();
            retorn = false;
            e.printStackTrace();
        } finally{
            sessio.close();
        }
        return retorn;
    }
    
    public List readClan(){
        List result = null;
        try {
        Session sessio = factory.openSession();
        sessio.beginTransaction();
        Query q = sessio.createQuery("from clan");
        result = (List) q.list();
        
        //sessio.getTransaction().commit();
    } catch (HibernateException he) {
        he.printStackTrace();
    }
        return result;
    }
}
