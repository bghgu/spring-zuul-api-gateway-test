package tk.bghgu.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;

/**
 * Created by ds on 2018-05-06.
 */

public class UrlPreFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(UrlPreFilter.class);
    private static final String HEADER_AUTH = "Authorization";

    @Override
    public String filterType() {
        logger.info("pre");
        return "pre";
    }

    @Override
    public int filterOrder() {
        logger.info("filterOrder : " + String.valueOf(PRE_DECORATION_FILTER_ORDER - 1));
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        logger.info("shouldFilter");
        RequestContext ctx = getCurrentContext();
        ctx.getRequest().getContextPath();
        return ctx.getRequest().getHeader(HEADER_AUTH) != null;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
