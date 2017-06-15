/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.upc.deportivo.controller;

import com.upc.deportivo.dao.JugadorDao;
import com.upc.deportivo.dao.ibatis.JugadorDaoImplement;
import com.upc.deportivo.model.JugadorBean;

import com.upc.deportivo.dao.ExamenMedicoDao;
import com.upc.deportivo.dao.ibatis.ExamenMedicoDaoImplement;
import com.upc.deportivo.model.ExamenMedicoBean;


import com.upc.deportivo.util.Parametros;
import java.io.*;
import java.net.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author USUARIO
 */
public class WelcomeServlet extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {

       String accion = request.getParameter("accion");
       
      
     if (accion != null) {
             if (accion.equals("salir")) {
             request.setAttribute(accion, null);
             HttpSession session = request.getSession();
             session.invalidate();
         }
     } else {

}

            
      
      
      response.sendRedirect("./pages/login/loginDeportivoApp.iface");
   }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
