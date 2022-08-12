package bean;

import com.sun.corba.se.impl.ior.ObjectReferenceFactoryImpl;
import dao.Loja;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ymcassandri
 */
@Stateless
public class LojaFacade extends AbstractFacade<Loja> {
 
    @PersistenceContext(unitName = "stefaninifood")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LojaFacade() {
        super(Loja.class);
    }

  public List<Loja> findByCnpj(String cnpj) {
      return em.createQuery(
              "SELECT u FROM Loja u WHERE u.cnpj = :cnpjSearch")
              .setParameter("cnpjSearch", cnpj)
              .getResultList();
    }

    
   
    
}
