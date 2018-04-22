package com.sovannarith.sproutingandfilter.gateway.filter.pre;

import javax.servlet.http.HttpServletRequest;

import com.netflix.client.http.HttpResponse;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.ZuulFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StreamUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;
import static org.springframework.util.ReflectionUtils.rethrowRuntimeException;

public class SimpleFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);
    private static final String REQUEST_ERROR = "Your request is not success.";

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        try {

            RequestContext ctx = RequestContext.getCurrentContext();
            HttpServletRequest request = ctx.getRequest();
            String url = request.getRequestURL().toString();

            RequestContext context = getCurrentContext();
            int error = context.getResponseStatusCode();
            InputStream stream = context.getResponseDataStream();
            // return content back to view.
            String body = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
            String _body = "";

            if (error == 200) _body = "Response Data: " + (body.contains("<head>") ? "HTML FORM" : body);
            else _body = url + REQUEST_ERROR + "(" + error + ")";

            context.setResponseDataStream(new ByteArrayInputStream(body.getBytes("UTF-8")));

            log.info(String.format("%s .", _body));
        }
        catch (IOException e) {
            rethrowRuntimeException(e);
            log.info("WTF");
        }
        return null;
    }

}
