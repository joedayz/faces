package com.mycompany.utils;


import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

public class JSFUtils {

   public static List <SelectItem> createList (String [] data){
      ArrayList <SelectItem>list = new ArrayList <SelectItem>();
      for (String item : data){
    list.add (new SelectItem (item, item));
      }
      return list;
   }
}