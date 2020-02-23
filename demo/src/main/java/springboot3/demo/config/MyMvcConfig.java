package springboot3.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springboot3.demo.component.MyLocaleResolver;

//配置类
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {





    //增加视图解析器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //过时
    // 注册组件
//    @Bean
//    public WebMvcConfigurationSupport webMvcConfigurationSupport() {
//        WebMvcConfigurationSupport webMvcConfigurationSupport = new WebMvcConfigurationSupport() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("index");
//
//            }
//        };
//
//        return webMvcConfigurationSupport;
//    }


    //管理静态资源路径 实际路径带上classpath:/META-INF/resources/才能找到
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/META-INF/resources/static/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

    // 一定要叫localeResolver
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    // 拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // SpringBoot 已经处理好静态资源映射
//       registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//               .excludePathPatterns("/index.html","/","/webjars/**","/static/**","/dashboard");
//
////        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/main.html")
////                .excludePathPatterns("/weblars/**","/static/**");
//    }
}
