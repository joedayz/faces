/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.upc.deportivo.controller;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.upc.deportivo.model.ReporteResultadoBean;
import com.upc.deportivo.util.AppSqlConfig;
import com.upc.deportivo.util.Operaciones;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.log4j.Logger;

/**
 *
 * @author USUARIO
 */
public class ReporteResultadoPartidoBean {
    private Color  colorEmpate;
    private Color colorGanado;
    private Color colorPerdido;
    private double empate;
    private double ganados;
    private double perdidos;
    private ArrayList colors;
    private ReporteResultadoBean reporte;

    private static final Logger logger = Logger.getLogger(ReporteResultadoPartidoBean.class.getName());





    public  ReporteResultadoPartidoBean(){
     
   
       colors = new ArrayList(Arrays.asList(
                new Color[]{new Color(26, 86, 138),
                            new Color(76, 126, 167),
                            new Color(148, 179, 203)}));

           try {
            SqlMapClient sqlMap = AppSqlConfig.getSqlMapInstance();

         reporte= (ReporteResultadoBean) sqlMap.queryForObject(Operaciones.OBTENER_REPORTE_RESULTADO_PARTIDOS);

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }


     System.out.println("PINTA-------"+reporte.getEmpate());


     empate=reporte.getEmpate();
     ganados=reporte.getGanados();
     perdidos=reporte.getPerdidos();


     


    }

    public Color getColorEmpate() {
        return colorEmpate;
    }

    public void setColorEmpate(Color colorEmpate) {
        this.colorEmpate = colorEmpate;
    }

    public Color getColorGanado() {
        return colorGanado;
    }

    public void setColorGanado(Color colorGanado) {
        this.colorGanado = colorGanado;
    }

    public Color getColorPerdido() {
        return colorPerdido;
    }

    public void setColorPerdido(Color colorPerdido) {
        this.colorPerdido = colorPerdido;
    }

    public double getEmpate() {
        return empate;
    }

    public void setEmpate(double empate) {
        this.empate = empate;
    }

    public double getGanados() {
        return ganados;
    }

    public void setGanados(double ganados) {
        this.ganados = ganados;
    }

    public double getPerdidos() {
        return perdidos;
    }

    public void setPerdidos(double perdidos) {
        this.perdidos = perdidos;
    }

    public ArrayList getColors() {
        return colors;
    }

    public void setColors(ArrayList colors) {
        this.colors = colors;
    }

   public void cargaReporte(){
 

 
      

 }

    /**
     * @return the reporte
     */
    public ReporteResultadoBean getReporte() {
        return reporte;
    }

    /**
     * @param reporte the reporte to set
     */
    public void setReporte(ReporteResultadoBean reporte) {
        this.reporte = reporte;
    }

}
