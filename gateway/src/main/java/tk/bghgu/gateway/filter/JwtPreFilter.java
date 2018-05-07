package tk.bghgu.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tk.bghgu.gateway.service.JwtService;

import javax.servlet.http.HttpServletRequest;

import java.util.Enumeration;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.util.ReflectionUtils.isCglibRenamedMethod;
import static org.springframework.util.ReflectionUtils.rethrowRuntimeException;

/**
 * Created by ds on 2018-05-06.
 */
public class JwtPreFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtPreFilter.class);
    private static final String HEADER_AUTH = "Authorization";

    @Autowired
    private JwtService jwtService;

    @Override
    public String filterType() {
        logger.info("pre");
        return "pre";
    }

    @Override
    public int filterOrder() {
        logger.info("filterOrder : " + String.valueOf(PRE_DECORATION_FILTER_ORDER + 1));
        return PRE_DECORATION_FILTER_ORDER + 1;
    }

    /**
     * 발동 조건
     * @return
     */
    @Override
    public boolean shouldFilter() {
        logger.info("shouldFilter");
        RequestContext ctx = getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(request.getRequestURI());
        logger.info(request.getServletPath());
        Enumeration eParam = request.getParameterNames();
        while (eParam.hasMoreElements()) {
            String pName = (String) eParam.nextElement();
            String pValue = request.getParameter(pName);
            logger.info(pName + " : " + pValue);
        }
        return request.getHeader(HEADER_AUTH) != null;
    }

    /**
     * 토큰의 유효성 검사만 진행한다.
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        try {
            logger.info("run");
            RequestContext ctx = getCurrentContext();
            HttpServletRequest request = ctx.getRequest();
            logger.info(request.getRequestURI());
            logger.info(request.getServletPath());
            logger.info(request.getQueryString());
            logger.info(request.getParameterNames() + " ");
            String token = request.getHeader(HEADER_AUTH);
            logger.info(HEADER_AUTH + " : " + token);
            jwtService.isValuedToken(token);
        }catch (Exception e){
            rethrowRuntimeException(e);
        }
        return null;
    }
}
