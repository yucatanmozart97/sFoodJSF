/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author ymcassandri
 */

import com.sun.corba.se.spi.activation.Server;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByName", query = "SELECT u FROM Usuario u WHERE u.name = :name"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findByTelefone", query = "SELECT u FROM Usuario u WHERE u.telefone = :telefone"),
    @NamedQuery(name = "Usuario.findByDtNascimento", query = "SELECT u FROM Usuario u WHERE u.dtNascimento = :dtNascimento"),
    @NamedQuery(name = "Usuario.findByCep", query = "SELECT u FROM Usuario u WHERE u.cep = :cep"),
    @NamedQuery(name = "Usuario.findByComplemtno", query = "SELECT u FROM Usuario u WHERE u.complemento = :complemento"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")})

public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(min = 3, max = 100)
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Size(min = 10)
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @Column(name = "dtNascimento")
    private String dtNascimento;
    @Basic(optional = false)
    @Size(min = 9, max = 9)
    @Column(name = "cep")
    private String cep;
    @Basic(optional = false)
    @Size(min = 1)
    @Column(name = "complemento")
    private String complemento;
    @Basic(optional = false)
    @Size(min = 7)
    @Column(name = "nomeUsuario")
    private String nomeUsuario;
    @Basic(optional = false)
    @Size(min = 8)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @Size(min = 8)
    private String confirmacaoSenha;
    
    public Usuario(){
    }
    
    public Usuario (Long id) {
        this.id = id;
    }
    
    public Usuario (Long id, String name, String email, String telefone, String dtNascimento, String cep, String complemento, String nomeUsuario, String senha) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.telefone = telefone;
    this.dtNascimento = dtNascimento;
    this.cep = cep;
    this.complemento = complemento;
    this.nomeUsuario = nomeUsuario;
    this.senha = senha;
 
    }
    
    public Long getId() {
    return id;
    }
    
    public void setId(Long id){
    this.id = id;
    }
    
    public String getName(){
    return name;
    }
    
    public void setName(String name){
    this.name = name;
    }
    
    public String getEmail(){
    return email;
    }
    
    public void setEmail(String email){
    this.email = email;
    }
    
    public String getTelefone(){
    return telefone;
    }
    
    public String getDtNascimento(){
    return dtNascimento;
    }
    
    public void setDtNascimento(String dtNascimento){
    this.dtNascimento = dtNascimento;
    }
    
    public void setTelefone(String telefone){
    this.telefone = telefone;
    }
    
    public String getCep(){
    return cep;
    }
    
    public void setCep(String cep){
    this.cep = cep;
    }
    
    public String getComplemento(){
    return complemento;
    }
    
    public void setComplemento(String complemento){
    this.complemento = complemento;
    }
    
    public String getSenha(){
    return senha;
    }
    
    public void setSenha(String senha){
    this.senha = senha;
    }
    
    public String getConfirmacaoSenha(){
    return confirmacaoSenha;
    }
    
    public void setConfirmacaoSenha(String confirmacaoSenha){
    this.confirmacaoSenha = confirmacaoSenha;
    }
    
    public String getNomeUsuario(){
    return nomeUsuario;
    }
    
    public void setNomeUsuario(String nomeUsuario){
    this.nomeUsuario = nomeUsuario;
    }
}
