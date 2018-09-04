import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "CounterFilter")
public class CounterFilter implements Filter {

    private FilterConfig filterConfig = null;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // сессия - ((HttpServletRequest) request).getSession()
        // приложение - filterConfig.getServletContext()
        // до передачи управления
        chain.doFilter(req, resp);
        // после возврата управления
    }

    public void init(FilterConfig config) throws ServletException {

        this.filterConfig = filterConfig;
    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

}
