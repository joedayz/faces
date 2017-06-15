/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.deportivo.dao.ibatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.upc.deportivo.dao.ExamenMedicoDao;
import com.upc.deportivo.model.ExamenMedicoBean;
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
public class ExamenMedicoDaoImplement implements ExamenMedicoDao {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    private static final Logger logger = Logger.getLogger(ExamenMedicoDaoImplement.class.getName());

    public List<ExamenMedicoBean> obtenerListadoExamenMedico(ExamenMedicoBean examenMedico) {

        List examenesMedicos = new ArrayList<ExamenMedicoBean>();
        try {
            SqlMapClient sqlMap = AppSqlConfig.getSqlMapInstance();

              Map<String, String> parameters = new HashMap<String, String>();

            parameters.put("codigo", examenMedico.getCodigo());
            List lst = sqlMap.queryForList(Operaciones.OBTENER_LISTADO_EXAMENES_MEDICOS,parameters);

            examenesMedicos = (ArrayList<ExamenMedicoBean>) lst;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return examenesMedicos;

    }

    public void actualizarExamenMedico(ExamenMedicoBean examenMedico) {


        try {
            SqlMapClient sqlMap = AppSqlConfig.getSqlMapInstance();
            Map<String, String> parameters = new HashMap<String, String>();

        
            parameters.put("co_ExamenMed", examenMedico.getCo_ExamenMed());
            parameters.put("codigo", examenMedico.getCodigo());
            parameters.put("talla", examenMedico.getTalla().toString());
            parameters.put("examenSangre", examenMedico.getExamenSangre());
            parameters.put("examenOrina", examenMedico.getExamenOrina());
            parameters.put("alturaPromedioSalto", examenMedico.getAlturaPromedioSalto().toString());
            parameters.put("temporada", examenMedico.getTemporada());
            parameters.put("resistencia", examenMedico.getResistencia().toString());
            parameters.put("longitudMuslo", examenMedico.getLongitudMuslo().toString());
            parameters.put("longitudCintura", examenMedico.getLongitudCintura().toString());
            parameters.put("longitudPecho", examenMedico.getLongitudPecho().toString());
            parameters.put("longitudAntebrazo", examenMedico.getLongitudAntebrazo().toString());
            parameters.put("longitudBrazo", examenMedico.getLongitudBrazo().toString());
            parameters.put("longitudCuello", examenMedico.getLongitudCuello().toString());
            parameters.put("peso", examenMedico.getPeso().toString());

             examenMedico = (ExamenMedicoBean) sqlMap.insert(Operaciones.ACTUALIZAR_EXAMEN_MEDICO, parameters);


        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        // se crea un arreglo de tama;o 0 para que la interfase no lance errores.

        }

    }

    public void eliminarExamenMedico(ExamenMedicoBean examenMedico) {
        

        int flag = 0;

        try {
            SqlMapClient sqlMap = AppSqlConfig.getSqlMapInstance();
            Map<String, String> parameters = new HashMap<String, String>();
            parameters.put("co_ExamenMed", examenMedico.getCo_ExamenMed());



            flag = sqlMap.delete(Operaciones.ELIMINAR_EXAMEN_MEDICO, parameters);

   



        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        // se crea un arreglo de tama;o 0 para que la interfase no lance errores.

        }

    }


}
