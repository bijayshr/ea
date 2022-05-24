package edu.mum.cs544;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("edu.mum.cs544")
public class Config {

    @Bean
    public List<IBookSupplier> suppliers(){
        List<IBookSupplier> supplierList = new ArrayList<>();
        supplierList.add(new Amazon());
        supplierList.add(new BarnesAndNoble());
        supplierList.add(new EBooks());
        supplierList.add(new Borders());
        return supplierList;

    }
}
