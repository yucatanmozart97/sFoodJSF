/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Loja;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;
import bean.LojaFacade;

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

@Named("lojaController")
@SessionScoped
public class LojaController implements Serializable{
    
     @EJB
    private bean.LojaFacade ejbFacade;
    private List<Loja> items = null;
    private Loja selected;

    public LojaController() {
    }

    public Loja getSelected() {
        return selected;
    }

    public void setSelected(Loja selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private LojaFacade getFacade() {
        return ejbFacade;
    }
    


    public Loja prepareCreate() {
        selected = new Loja();
        initializeEmbeddableKey();
        return selected;
        
        
    }

    public void create() {
          List<Loja> lista = getFacade().findByCnpj(selected.getCnpj());
          
          if (lista.size() < 1) {
        persist(PersistAction.CREATE, "Criado com sucesso");
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
          } else {
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cnpj já cadastrado"));
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

    public List<Loja> getItems() {
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
   
    

    public Loja getLoja(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<Loja> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Loja> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Loja.class)
    public static class LojaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            LojaController controller = (LojaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "lojaController");
            return controller.getLoja(getKey(value));
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
            if (object instanceof Loja) {
                Loja o = (Loja) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Loja.class.getName()});
                return null;
            }
        }
   
        
       
    }
    
}
