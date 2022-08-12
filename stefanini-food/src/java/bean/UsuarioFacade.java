package bean;

import com.sun.corba.se.impl.ior.ObjectReferenceFactoryImpl;
import dao.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> {
 
    @PersistenceContext(unitName = "stefaninifood")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
 
    
    public List<Usuario> findByEmail(String email) {
      return em.createQuery(
              "SELECT u FROM Usuario u WHERE u.email = :emailSearch")
              .setParameter("emailSearch", email)
              .getResultList();
    }
    
     public List<Usuario> findByNomeUsuario(String usuario) {
      return em.createQuery(
              "SELECT u FROM Usuario u WHERE u.nomeUsuario = :usuarioSearch")
              .setParameter("usuarioSearch", usuario)
              .getResultList();
    }
     
       public List<Usuario> findByPassword(String senha) {
      return em.createQuery(
              "SELECT u FROM Usuario u WHERE u.senha = :senhaSearch")
              .setParameter("senhaSearch", senha)
              .getResultList();
    }
    

    
   
    
}
