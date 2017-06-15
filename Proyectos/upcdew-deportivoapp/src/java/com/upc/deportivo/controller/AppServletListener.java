/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.upc.deportivo.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import net.sf.ehcache.CacheManager;

/**
 * Web application lifecycle listener.
 * @author 
 * 
 */

public final class AppServletListener implements ServletContextListener {

   public void contextInitialized(ServletContextEvent sce) {
      CacheManager.create();
//      Logger logger = Logger.getLogger(AppServletListener.class.getName());
//      if(logger.isDebugEnabled()){
//         String[] cacheNames = CacheManager.getInstance().getCacheNames();
//         for(String s : cacheNames){
//            logger.debug("cacheName :" + s);
//         }
//      }
   }

   public void contextDestroyed(ServletContextEvent sce) {
      CacheManager.getInstance().shutdown();
   }
}