package ct.dc.pc.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by CTWLPC on 2017/9/8.
 */
@Configuration
@ComponentScan(basePackages = {"ct.dc.pc.api"},excludeFilters =
        {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)})
public class RootConfig {
}
