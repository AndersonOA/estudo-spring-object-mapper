package br.com.makersweb.demo.thymeleaf;

import br.com.makersweb.demo.thymeleaf.processor.*;
import org.springframework.stereotype.Component;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.HashSet;
import java.util.Set;

/**
 * @author aaristides
 */
@Component
public class DemoDialect extends AbstractProcessorDialect {

    protected DemoDialect() {
        super("MakersWeb Demo", "demo", StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        final Set<IProcessor> processadores = new HashSet<>();
        processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
        processadores.add(new MessageElementTagProcessor(dialectPrefix));
        processadores.add(new OrderElementTagProcessor(dialectPrefix));
        processadores.add(new PaginationElementTagProcessor(dialectPrefix));
        processadores.add(new MenuAttributeTagProcessor(dialectPrefix));
        return processadores;
    }
}
