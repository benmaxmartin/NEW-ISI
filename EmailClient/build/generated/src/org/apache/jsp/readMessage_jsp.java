package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.client.readMessage;

public final class readMessage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

String str; 
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Reading-Message</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Reading-Message</h1>\n");
      out.write("        <h3>Cipher-Text:</h3>\n");
      out.write("        <p>\n");
      out.write("            ");
      out.print(readMessage.text);
      out.write("\n");
      out.write("        </p>\n");
      out.write("        <h3>Captcha:</h3>\n");
      out.write("        ");
 String path = readMessage.path ;
      out.write("\n");
      out.write("        <img src=\"path\">\n");
      out.write("        <h3>Enter The Above Captcha to Decrypt!!</h3>\n");
      out.write("        <form action=\"decryptServlet\">\n");
      out.write("            <input type=\"hidden\" name=\"body\" value=\"");
      out.print(readMessage.text);
      out.write("\">\n");
      out.write("            <input type=\"text\" name=\"captcha\">\n");
      out.write("            <input type=\"submit\" value=\"Continue\">    \n");
      out.write("        </form>\n");
      out.write("            <form action=\"EmailServlet\">\n");
      out.write("                <input type=\"submit\" value=\"go-back\">\n");
      out.write("            </form>   \n");
      out.write("            \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
