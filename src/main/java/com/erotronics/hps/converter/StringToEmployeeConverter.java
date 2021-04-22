package com.erotronics.hps.converter;

import com.erotronics.hps.domain.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToEmployeeConverter
        implements Converter<String, Employee> {

    @Override
    public Employee convert(String from) {
        String[] data = from.split(",");
        return new Employee(
                Long.parseLong(data[0]),
                Double.parseDouble(data[1]));
    }
}

