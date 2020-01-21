package com.it.app.config;

import com.it.app.component.DateConverter;
import com.it.app.dto.request.PrescriptionRequestDto;
import com.it.app.dto.response.PrescriptionResponseDto;
import com.it.app.model.Prescription;
import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Web configuration.
 */
@EnableWebMvc
public class WebConfiguration {

    /**
     * Mapper mapper.
     *
     * @return the mapper
     */
    @Bean
    public Mapper mapper() {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        List<CustomConverter> converters = new ArrayList<>();
        converters.add(new DateConverter());
        dozerBeanMapper.setCustomConverters(converters);
        dozerBeanMapper.addMapping(mappingBuilder());
        return dozerBeanMapper;
    }

    private BeanMappingBuilder mappingBuilder() {
        return new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(PrescriptionResponseDto.class, Prescription.class).fields("date", "date", FieldsMappingOptions.customConverter(DateConverter.class));
            }
        };
    }

    /**
     * Password encoder password encoder.
     *
     * @return the password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
