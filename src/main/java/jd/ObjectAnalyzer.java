package jd;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * Created by zhaogp on 2016/11/17.
 */
public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<Object>();

    public String toStriing(Object obj) {
        if (obj==null)
            return "null";
        if (visited.contains(obj))
            return "...";
        visited.add(obj);
        Class cl = obj.getClass();
        if (cl==String.class)
            return (String)obj;
        if (cl.isArray()){
            String s = cl.getComponentType() + "[]{";
            for (int i=0; i< Array.getLength(obj); i++){
                if (i>0)
                    s += ",";
                Object o = Array.get(obj, i);
                if(cl.getComponentType().isPrimitive())
                    s += o;
                else
                    s += o.toString();
            }
            return s += "}";
        }

        String ss = cl.getName();
        do{
            ss += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field f:fields){
                if (!Modifier.isStatic(f.getModifiers())){
                    if (!ss.endsWith("["))
                        ss += ",";
                    ss += f.getName() + "=";
                    try{
                        Class t = f.getType();
                        Object oo = f.get(obj);
                        if (t.isPrimitive())
                            ss += oo;
                        else
                            ss += oo.toString();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
            ss += "]";
            cl = cl.getSuperclass();
        }
        while (cl!=null);
        return ss;
    }
}
