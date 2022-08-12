/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Usuario;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;
import bean.UsuarioFacade;

import controller.util.JsfUtil;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author ymcassandri
 */

@Named("usuarioController")
@SessionScoped
public class UsuarioController implements Serializable{
    
     @EJB
    private bean.UsuarioFacade ejbFacade;
    private List<Usuario> items = null;
    private Usuario selected;

    public UsuarioController() {
    }

    public Usuario getSelected() {
        return selected;
    }

    public void setSelected(Usuario selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private UsuarioFacade getFacade() {
        return ejbFacade;
    }
    
    
    


    public Usuario prepareCreate() {
        selected = new Usuario();
        initializeEmbeddableKey();
        return selected;
        
        
    }

    public void create() { 
        List<Usuario> existEmail = getFacade().findByEmail(selected.getEmail());
        List<Usuario> existUsuario = getFacade().findByNomeUsuario(selected.getNomeUsuario());
        
        if (existUsuario.size() == 1) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Este usuario já existe"));
        
        } else if (selected.getEmail().indexOf("@") < 3 || selected.getEmail().indexOf(".com") < 10) {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Email inválido"));
        }      
         else if (existEmail.size() == 1) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Este email já é cadastrado"));
        } else {
             if (selected.getSenha().equals(selected.getConfirmacaoSenha())) {
        persist(PersistAction.CREATE, "Criado com sucesso");
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        } 
             } else {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Senha e confirmação estão diferentes"));
             }
        }
     
    }

    public void update() {
        persist(PersistAction.UPDATE, "Atualizado com sucesso");
    }

    public void destroy() {
        persist(PersistAction.DELETE, "Deletado com sucesso");
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Usuario> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
            JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, "Erro de persistencia");
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, "Erro na persistencia");
            }
        }
    }
   
    

    public Usuario getUsuario(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Usuario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Usuario> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Usuario.class)
    public static class UsuarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuarioController controller = (UsuarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuarioController");
            return controller.getUsuario(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Usuario) {
                Usuario o = (Usuario) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Usuario.class.getName()});
                return null;
            }
        }
   
        
       
    }
    
}
