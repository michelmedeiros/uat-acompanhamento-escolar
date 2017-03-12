package br.com.acompanhamento.mongo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.CustomConversions;

import com.netshoes.mp.commission.config.mongo.converters.BigDecimalToDoubleConverter;
import com.netshoes.mp.commission.config.mongo.converters.DoubleToBigDecimalConverter;

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
