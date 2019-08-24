package demo.commons;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //使用视图需要配置模板引擎,模板引擎帮助转发至页面
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/welcome").setViewName("welcome");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置资源映射
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        //注意配置静态资源路径
        registry.addInterceptor(new LoginHeaderIntercepter())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "/css/**", "/js/**");
    }
}
