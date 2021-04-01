package chapter13.bankapp.formatter;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.util.HashSet;
import java.util.Set;

public class AmountFormatAnnotationFormatterFactory implements AnnotationFormatterFactory<AmountFormat> {
    @Override
    public Set<Class<?>> getFieldTypes() {
        Set<Class<?>> fieldTypes = new HashSet<>(1, 1);
        fieldTypes.add(Long.class);
        return fieldTypes;
    }

    @Override
    public Parser<?> getParser(AmountFormat annotation, Class<?> fieldType) {
        return new AmountFormatter();
    }

    @Override
    public Printer<?> getPrinter(AmountFormat annotation, Class<?> fieldType) {
        return new AmountFormatter();
    }
}
