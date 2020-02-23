package springboot3.demo.component;

import org.springframework.http.HttpRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String lang = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();
        // 获取用户选择
        if (!StringUtils.isEmpty(lang)) {
            String[] split = lang.split("_");
            locale = new Locale(split[0] ,split[1]);
            return locale;
        }
        // 获取浏览器语言
        String header = httpServletRequest.getHeader("Accept-Language");
        if (header.indexOf("en") == 0) {
            locale = new Locale("en_US");
            return locale;
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
