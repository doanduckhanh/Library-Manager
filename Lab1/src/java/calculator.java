/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author khanh doan
 */
@WebServlet(urlPatterns = {"/calculator"})
public class calculator extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String first = request.getParameter("first");
            String second = request.getParameter("second");
            String operator = request.getParameter("operator");
            
            double n1 = Double.parseDouble(first);
            double n2 = Double.parseDouble(second);
            double rs = 0;
            switch(operator){
                case "+": rs = n1+n2;break;
                case "-": rs = n1-n2;break;
                case "*": rs = n1*n2;break;
                case "/": rs = n1/n2;break;
            }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");            
            out.println("<title>Caculate</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"calculator\" method=\"post\">");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>First: </td>");
            out.println("<td>");
            out.println("<input type=\"text\" name=\"first\" value=\""+first+"\">");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Second: </td>");
            out.println("<td>");
            out.println("<input type=\"text\" name=\"second\" value=\""+second+"\">");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Operator: </td>");
            out.println("<td>");
            out.println("<input type=\"radio\" name=\"operator\" value=\"+\">+");
            out.println("<input type=\"radio\" name=\"operator\" value=\"-\">-");
            out.println("<input type=\"radio\" name=\"operator\" value=\"*\">*");
            out.println("<input type=\"radio\" name=\"operator\" value=\"/\">/");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td></td>");
            out.println("<td>");
            out.println("<button type=\"submit\">Compute</button>");
            out.println("</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Result: </td>");
            out.println("<td>");
            out.println("<input type=\"text\" value=\""+rs+"\">");
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
          
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
