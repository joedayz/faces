/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.upc.deportivo.dao.ibatis;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.upc.deportivo.dao.JugadorPartidoDao;
import com.upc.deportivo.model.JugadorPartidoBean;
import com.upc.deportivo.model.PartidoBean;
import com.upc.deportivo.util.AppSqlConfig;
import com.upc.deportivo.util.Operaciones;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author USUARIO
 */
public class JugadorPartidoDaoImplement implements JugadorPartidoDao{

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    private static final Logger logger = Logger.getLogger(JugadorDaoImplement.class.getName());

     
    public void actualizarJugadorPartido(JugadorPartidoBean jp) {
       
        JugadorPartidoBean jugadorPartido=new  JugadorPartidoBean();
              
         SqlMapClient sqlMap = AppSqlConfig.getSqlMapInstance();
            
          
         try {
            
            Map<String, String> parameters = new HashMap<String, String>();
       
            parameters = new HashMap<String, String>();
            parameters.put("codigoJugadorPartido", jp.getCodigoJugadorPartido());
            parameters.put("numPasesBuenos", String.valueOf(jp.getNumPasesbuenos()));
            parameters.put("posicionAdelantada",String.valueOf(jp.getPosicionAdelanta()));
            parameters.put("escalaRendimiento",String.valueOf(jp.getScalaRendimiento()));
            parameters.put("codigoJugador", jp.getCodigo());
            parameters.put("goles",String.valueOf(jp.getGoles()));
            parameters.put("tarjetaAmarilla",String.valueOf(jp.getTarjetaAmarillas()));
            parameters.put("tarjetaRoja",String.valueOf(jp.getTarjetaRojas()));
            parameters.put("indiciplina",jp.getIndiciplina());
            parameters.put("lesiones",jp.getLesiones());
            parameters.put("codigoPartido", jp.getCodigoPartido());
         
            
        
            jugadorPartido=     (JugadorPartidoBean) sqlMap.insert(Operaciones.ACTUALIZAR_JUGADOR_PARTIDO, parameters);

        
           
         } catch (Exception e) {
            logger.error(e.getMessage(), e);
           
        
        }
    
      
       
    }
    
    
    


}
