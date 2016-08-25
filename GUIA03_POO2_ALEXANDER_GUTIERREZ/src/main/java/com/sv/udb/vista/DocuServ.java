/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.TipoDocuCtrl;
import com.sv.udb.modelo.TipoDocu;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexander José
 */
@WebServlet(name = "DocuServ", urlPatterns = {"/DocuServ"})
public class DocuServ extends HttpServlet {

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
        boolean esValido = request.getMethod().equals("POST");
        if (esValido) {
            String mens = "";
            String CRUD = request.getParameter("cursBton");
            switch (CRUD) {
                case "Guardar": {
                    TipoDocu obje = new TipoDocu();
                    obje.setNombTipoDocu(request.getParameter("Nombre"));
                    Calendar Calendario = new GregorianCalendar().getInstance();
                    Date Fecha = Calendario.getTime();
                    SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy H:m:s");
                    String FechaAlta = formatoDeFecha.format(Fecha);
                    try {
                        obje.setFechAlta(formatoDeFecha.parse(FechaAlta));
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    mens = new TipoDocuCtrl().guar(obje) ? "Datos guardados." : "Datos NO guardados.";
                    request.setAttribute("mensAlert", mens);
                    request.getRequestDispatcher("/Documentos.jsp").forward(request, response);
                    break;
                }
                case "Consultar": {
                    int codiDocu = Integer.parseInt(request.getParameter("codiDocuRadi") == null ? "0" : request.getParameter("codiDocuRadi"));
                    TipoDocu obje = new TipoDocuCtrl().cons(codiDocu);
                    if (obje != null) {
                        request.setAttribute("codiDocu", obje.getCodiTipoDocu());
                        request.setAttribute("Nombre", obje.getNombTipoDocu());
                        request.setAttribute("opConsulta", 1);
                    }
                    request.setAttribute("mensAlert", mens);
                    request.getRequestDispatcher("/Documentos.jsp").forward(request, response);
                    break;
                }
                case "Modificar": {
                    String valor = request.getParameter("codiDocu");
                    if (!valor.equals("")) {
                        TipoDocu obje = new TipoDocu();
                        obje.setCodiTipoDocu(Long.parseLong(request.getParameter("codiDocu")));
                        obje.setNombTipoDocu(request.getParameter("Nombre"));
                        mens = new TipoDocuCtrl().actu(obje) ? "Datos modificados." : "Datos NO modificados.";
                    } else {
                        mens = "Seleccione un dato.";
                    }
                    request.setAttribute("mensAlert", mens);
                    request.getRequestDispatcher("/Documentos.jsp").forward(request, response);
                    break;
                }
                case "Eliminar": {
                    String valor = request.getParameter("codiDocu");
                    if (!valor.equals("")) {
                        TipoDocu obje = new TipoDocu();
                        obje.setCodiTipoDocu(Long.parseLong(request.getParameter("codiDocu")));                        
                        mens = new TipoDocuCtrl().elim(obje) ? "Datos eliminados." : "Datos NO eliminados.";
                    } else {
                        mens = "Seleccione un dato.";
                    }
                    request.setAttribute("mensAlert", mens);
                    request.getRequestDispatcher("/Documentos.jsp").forward(request, response);
                    break;
                }                  
                case "Cancelar": {
                    request.getRequestDispatcher("/Documentos.jsp").forward(request, response);
                    break;
                }
                default:
                    break;
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/Documentos.jsp");
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
