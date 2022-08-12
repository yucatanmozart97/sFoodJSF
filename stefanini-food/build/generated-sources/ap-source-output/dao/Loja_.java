package dao;

import dao.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-08-12T13:02:15")
@StaticMetamodel(Loja.class)
public class Loja_ { 

    public static volatile SingularAttribute<Loja, String> address;
    public static volatile SingularAttribute<Loja, String> dono;
    public static volatile ListAttribute<Loja, Produto> produtos;
    public static volatile SingularAttribute<Loja, String> name;
    public static volatile SingularAttribute<Loja, String> description;
    public static volatile SingularAttribute<Loja, Long> id;
    public static volatile SingularAttribute<Loja, String> cnpj;

}