package org.hdu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhang on 2017/12/18.
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {


    @Bean
    public Docket apis(){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .produces(produces())
                .apiInfo(apiInfo())
                .enableUrlTemplating(true);
    }


    private Set<String> produces(){
        Set<String> produces = new HashSet<String>();
        produces.add("application/json");
        return produces;
    }
    private ApiInfo apiInfo()
    {
        return new ApiInfo("说明1","说明2","说明3","说明4",new Contact("shusf","/DcPcApi.htm","270838235@qq.com"),"说明5","说明6");
    }
}
