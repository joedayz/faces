/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.upc.deportivo.util;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import java.io.Reader;
import org.apache.log4j.Logger;

/**
 *
 * @author USUARIO
 */
public final class AppSqlConfig {
   private static SqlMapClient sqlMap;

   private static void init() {
      try {
         Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
         sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
         reader.close();
      } catch (Exception e) {
         Logger.getLogger(AppSqlConfig.class.getName()).fatal(e.getMessage(), e);
      }
   }

   /**
    * Obtiene la referencia al SqlMapClient del Framework IBatis
    * @return referencia a SqlMapClient
    */
   public static SqlMapClient getSqlMapInstance() {
      if (sqlMap == null) {
         init();
      }
      return sqlMap;
   }
}
