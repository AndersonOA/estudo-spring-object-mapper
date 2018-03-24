package br.com.makersweb.demo.repository.specifications;

import br.com.makersweb.demo.model.Cliente;
import br.com.makersweb.demo.model.meta.Cliente_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aaristides
 */
public class ClienteSpecification {

    public static Specification<Cliente> filtroCliente(Cliente clienteFilter) {
        return new Specification<Cliente>() {
            @Override
            public Predicate toPredicate(Root<Cliente> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                Predicate[] predicates = criarRestricoes(clienteFilter, builder, root);
                return builder.and(predicates);
            }
        };
    }

    private static Predicate[] criarRestricoes(Cliente cliente, CriteriaBuilder builder, Root<Cliente> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(cliente.getNome())) {
            predicates.add(builder.like(builder.lower(root.get(Cliente_.nome)), "%" + cliente.getNome() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
