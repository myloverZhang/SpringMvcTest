package ct.dc.mobile.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by B41-80 on 2017/1/5.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apis()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/api/")
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .produces(produes())
                .apiInfo(apiInfo())
                .enableUrlTemplating(true);
    }

    private Set<String> produes()
    {
        Set<String> produces = new HashSet<String>();
        produces.add("application/json");
        return produces;
    }
    private ApiInfo apiInfo()
    {
        return new ApiInfo("说明1","说明2","说明3","说明4",new Contact("shusf","/DcMobileApiDocument.htm","270838235@qq.com"),"说明5","说明6");
    }
}
