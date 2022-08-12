/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ymcassandri
 */

@Entity
@Table(name = "loja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loja.findAll", query = "SELECT u FROM Loja u"),
    @NamedQuery(name = "Loja.findByDescription", query = "SELECT u FROM Loja u WHERE u.description = :description"),
    @NamedQuery(name = "Loja.findById", query = "SELECT u FROM Loja u WHERE u.id = :id"),
    @NamedQuery(name = "Loja.findByName", query = "SELECT u FROM Loja u WHERE u.name = :name"),
    @NamedQuery(name = "Loja.findByAddress", query = "SELECT u FROM Loja u WHERE u.address = :address"),
    @NamedQuery(name = "Loja.findByCnpj", query = "SELECT u FROM Loja u WHERE u.cnpj = :cnpj"),
    @NamedQuery(name = "Loja.findByDono", query = "SELECT u FROM Loja u WHERE u.dono = :dono")})
public class Loja implements Serializable{
    
   
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 14, max = 14)
    @Column(name = "cnpj")
    private String cnpj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 3, max = 100)
    @Column(name = "dono")
    private String dono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loja")
    private List<Produto> produtos;
    

    public Loja() {
    }

    public Loja(Long id) {
        this.id = id;
    }

    public Loja(Long id, String description, String name, String address, String cnpj, String dono) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.address = address;
        this.cnpj = cnpj;
        this.dono = dono;
    }
    
   
    
  
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getCnpj(){
    return cnpj;
    }
    
    public void setCnpj(String cnpj){
    this.cnpj = cnpj;
    }
    
    public String getDono(){
    return dono;
    }
    
    public void setDono(String dono){
    this.dono = dono;
    }

    public List<Produto> getProdutos(){
    return produtos;
    }
    
    public void setProdutos(List<Produto> produtos){
    this.produtos = produtos;
    }

    
}
