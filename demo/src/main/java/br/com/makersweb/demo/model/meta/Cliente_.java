package br.com.makersweb.demo.model.meta;

import br.com.makersweb.demo.model.Cliente;
import br.com.makersweb.demo.model.Endereco;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * @author aaristides
 */
@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

    public static volatile SingularAttribute<Cliente, Long> codigo;
    public static volatile SingularAttribute<Cliente, Boolean> ativo;
    public static volatile SingularAttribute<Cliente, Endereco> endereco;
    public static volatile SingularAttribute<Cliente, String> nome;

}
