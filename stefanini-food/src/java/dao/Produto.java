/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ymcassandri
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT u FROM Produto u"),
    @NamedQuery(name = "Produto.findByDescription", query = "SELECT u FROM Produto u WHERE u.descricao = :descricao"),
    @NamedQuery(name = "Produto.findById", query = "SELECT u FROM Produto u WHERE u.id = :id"),
    @NamedQuery(name = "Produto.findByName", query = "SELECT u FROM Produto u WHERE u.nome = :nome"),
    @NamedQuery(name = "Produto.findByLoja", query = "SELECT u FROM Produto u WHERE u.loja = :loja")})
public class Produto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Basic(optional = false)
    @Column(name = "id_produto", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name_produto")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preco_produto")
    private Double preco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao_produto")
    private String descricao;
    @ManyToOne
    private Loja loja;
    
    
        public Produto(){
    
    }
    
        public Produto(Long id, String nome, Double preco, String descricao, Loja loja){
    this.id = id;
    this.nome = nome;
    this.preco = preco;
    this.descricao = descricao;
    this.loja = loja;
    }
        
        
        public Long getId(){
        return id;
        }
        
        public void setId(Long id){
        this.id = id;
        }
        
        public String getNome(){
        return nome;
        }
        
        public void setNome(String nome){
        this.nome = nome;
        }
        
        public Double getPreco(){
        return preco;
        }
        
        public void setPreco(Double preco){
        this.preco = preco;
        }
        
        public String getDescricao(){
        return descricao;
        }
        
        public void setDescricao(String descricao){
        this.descricao = descricao;
        }
        
        public Loja getLoja(){
        return loja;
        }
        
        public void setLoja(Loja loja){
        this.loja = loja;
        }
        
     
}
