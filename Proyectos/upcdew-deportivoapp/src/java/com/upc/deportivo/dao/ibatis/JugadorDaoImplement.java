/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upc.deportivo.dao.ibatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.upc.deportivo.dao.JugadorDao;
import com.upc.deportivo.model.JugadorBean;
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
public class JugadorDaoImplement implements JugadorDao {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    private static final Logger logger = Logger.getLogger(JugadorDaoImplement.class.getName());

    public List<JugadorBean> obtenerListaJugadores() {

        List jugadores = new ArrayList<JugadorBean>();
        try {
            SqlMapClient sqlMap = AppSqlConfig.getSqlMapInstance();

            List lst = sqlMap.queryForList(Operaciones.OBTENER_LISTADO_JUGADORES);


            jugadores = (ArrayList<JugadorBean>) lst;



        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return jugadores;



    }

    public void actualizarJugador(JugadorBean jugador) {


        try {
            SqlMapClient sqlMap = AppSqlConfig.getSqlMapInstance();
            Map<String, String> parameters = new HashMap<String, String>();
            parameters.put("codigo", jugador.getCodigo());
            parameters.put("telefono", jugador.getTelefono());
            parameters.put("nombre", jugador.getNombre());
            parameters.put("apellidoPaterno", jugador.getApellidoPaterno());
            parameters.put("apellidoMaterno", jugador.getApellidoMaterno());
            parameters.put("direccion", jugador.getDireccion());
            parameters.put("contrato", jugador.getContrato());
            parameters.put("fecha", sdf.format(jugador.getFecha()));
            parameters.put("posicion", jugador.getPosicion());


          
            jugador = (JugadorBean) sqlMap.insert(Operaciones.ACTUALIZAR_JUGADOR, parameters);




        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        // se crea un arreglo de tama;o 0 para que la interfase no lance errores.

        }

    }

    public void eliminarJugador(JugadorBean jugador) {
        
        System.out.println("ELIMINAR JUGADOR--"+jugador.getCodigo());

        int flag = 0;

        try {
            SqlMapClient sqlMap = AppSqlConfig.getSqlMapInstance();
            Map<String, String> parameters = new HashMap<String, String>();
            parameters.put("codigo", jugador.getCodigo());



            flag = sqlMap.delete(Operaciones.ELIMINAR_JUGADOR, parameters);

         System.out.println("FLAG JUGADOR--"+flag);



        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        // se crea un arreglo de tama;o 0 para que la interfase no lance errores.

        }

    }
}
