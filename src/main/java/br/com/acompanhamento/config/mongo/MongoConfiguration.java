package br.com.acompanhamento.config.mongo;

import java.util.ArrayList;
import java.util.List;

import br.com.acompanhamento.config.mongo.converters.BigDecimalToDoubleConverter;
import br.com.acompanhamento.config.mongo.converters.DoubleToBigDecimalConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.CustomConversions;


@Configuration
public class MongoConfiguration {

    @Bean
    public CustomConversions customConversions() {
        List<Converter<?, ?>> converterList = new ArrayList<Converter<?, ?>>();
        converterList.add(new DoubleToBigDecimalConverter());
        converterList.add(new BigDecimalToDoubleConverter());
        return new CustomConversions(converterList);
    }

}
