/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.deportivo.dao.ibatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.upc.deportivo.dao.PartidoDao;
import com.upc.deportivo.model.JugadorPartidoBean;
import com.upc.deportivo.model.PartidoBean;
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
public class PartidoDaoImplement implements PartidoDao {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    private static final Logger logger = Logger.getLogger(PartidoDaoImplement.class.getName());

    public List<PartidoBean> obtenerPartidos() {

        List partidos = new ArrayList<PartidoBean>();
        try {
            SqlMapClient sqlMap = AppSqlConfig.getSqlMapInstance();

            List lst = sqlMap.queryForList(Operaciones.OBTENER_LISTADO_PARTIDOS);


            partidos = (ArrayList<PartidoBean>) lst;



        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return partidos;
    }

    public PartidoBean obtenerPartido(String codigo) {
        PartidoBean partido = new PartidoBean();
        try {
            SqlMapClient sqlMap = AppSqlConfig.getSqlMapInstance();


            HashMap<String, String> parameters = new HashMap<String, String>();
            parameters.put("codigoPartido", codigo);

            partido = (PartidoBean) sqlMap.queryForObject(Operaciones.OBTENER_PARTIDO, parameters);

            System.out.println("partido OBTENER PartidoDaoImplement--" + partido.getCodigoPartido());


            List jugadorespartido = sqlMap.queryForList(Operaciones.OBTENER_JUGADORES_PARTIDO, parameters);

            System.out.println(" OBTENER jugadorespartido PartidoDaoImplement--" + jugadorespartido.size());


            partido.setObjJugadorPartido((ArrayList<JugadorPartidoBean>) jugadorespartido);


        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return partido;

    }

    public PartidoBean actualizarPartido(PartidoBean partido) {

        SqlMapClient sqlMap = AppSqlConfig.getSqlMapInstance();

        
        
        try {
            
            Map parameters = new HashMap();
            parameters.put("codigoPartido", partido.getCodigoPartido());
            parameters.put("codigoCampeonato", partido.getCodigoCampeonato());
            parameters.put("fechaPartido", sdf.format(partido.getFechaPartido()));
            parameters.put("ciudad", partido.getCiudad());
            parameters.put("tipoCancha", partido.getTipoCancha());
            parameters.put("equipoContrario", partido.getEquipoContrario());
            parameters.put("localidad", partido.getLocalidad());
            parameters.put("golFavor", String.valueOf(partido.getGolFavor()));
            parameters.put("golContra", String.valueOf(partido.getGolContra()));
         
         
            System.out.println("actualizarPartido 1" + parameters.toString());


            partido = (PartidoBean) sqlMap.queryForObject(Operaciones.ACTUALIZAR_PARTIDO, parameters);


            System.out.println("actualizarPartido 2" + partido.getCodigoPartido());

            
            
            System.out.println("codigo Partido" + partido.getCodigoPartido());


           
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        // se crea un arreglo de tama;o 0 para que la interfase no lance errores.



        } 
        

        return partido;

    }

    public String obtenerCodigoPartido() {

        PartidoBean partido = new PartidoBean();

        try {
            SqlMapClient sqlMap = AppSqlConfig.getSqlMapInstance();

            partido = (PartidoBean) sqlMap.queryForObject(Operaciones.OBTENER_CODIGO_PARTIDO);



        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        // se crea un arreglo de tama;o 0 para que la interfase no lance errores.

        }


        return partido.getCodigoPartido();
    }
}
