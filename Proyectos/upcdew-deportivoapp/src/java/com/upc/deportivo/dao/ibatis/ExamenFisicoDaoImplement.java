/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.deportivo.dao.ibatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.upc.deportivo.dao.ExamenFisicoDao;
import com.upc.deportivo.model.ExamenFisicoBean;
import com.upc.deportivo.util.AppSqlConfig;
import com.upc.deportivo.util.Operaciones;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author USUARIO
 */
public class ExamenFisicoDaoImplement implements ExamenFisicoDao {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    private static final Logger logger = Logger.getLogger(ExamenFisicoDaoImplement.class.getName());

    public List<ExamenFisicoBean> obtenerListaExamenesFisicos(ExamenFisicoBean examenFisico) {

        List ExamenesFisicos = new ArrayList<ExamenFisicoBean>();
        try {
            SqlMapClient sqlMap = AppSqlConfig.getSqlMapInstance();
            Map<String, String> parameters = new HashMap<String, String>();
            
            
            parameters.put("codigo", examenFisico.getCodigo());
            
            
            List lst = sqlMap.queryForList(Operaciones.OBTENER_LISTADO_EXAMENFISICO,parameters);
            ExamenesFisicos = (ArrayList<ExamenFisicoBean>) lst;

           

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return ExamenesFisicos;



    }

    public void actualizarExamenFisico(ExamenFisicoBean examenFisico) {


        System.out.println("pinta porfa----"+examenFisico.getCo_ExamenFis());
         System.out.println("pinta porfa----"+examenFisico.getResultado());
       
        
        try {
            SqlMapClient sqlMap = AppSqlConfig.getSqlMapInstance();
            Map<String, String> parameters = new HashMap<String, String>();
            parameters.put("co_ExamenFis", examenFisico.getCo_ExamenFis());
            parameters.put("codigo", examenFisico.getCodigo());
            parameters.put("descripcion", examenFisico.getDescripcion());
            parameters.put("tipoExamenFisico", examenFisico.getTipoExamenFisico());
            parameters.put("resultado", examenFisico.getResultado().toString());
            parameters.put("temporada", examenFisico.getTemporada());




            examenFisico = (ExamenFisicoBean) sqlMap.insert(Operaciones.ACTUALIZAR_EXAMENFISICO, parameters);




        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        // se crea un arreglo de tama;o 0 para que la interfase no lance errores.

        }

    }

    public void eliminarExamenFisico(ExamenFisicoBean examenFisico) {
        
 

        int flag = 0;

        try {
            SqlMapClient sqlMap = AppSqlConfig.getSqlMapInstance();
            Map<String, String> parameters = new HashMap<String, String>();
            parameters.put("co_ExamenFis", examenFisico.getCo_ExamenFis());


            System.out.println("PINTA EN SER DAO ---"+examenFisico.getCo_ExamenFis());
   
            flag = sqlMap.delete(Operaciones.ELIMINAR_EXAMENFISICO, parameters);

 



        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        // se crea un arreglo de tama;o 0 para que la interfase no lance errores.

        }

    }
}
