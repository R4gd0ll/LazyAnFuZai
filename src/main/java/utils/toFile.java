package utils;

import Base.Check1;
import System.*;

import java.util.HashMap;
import java.util.Map;

public class toFile {

    public static void toXlsxFile(HashMap resultHash, String xlsxPwd){
        writeToXlsx.createXlsx(xlsxPwd);
        int i = 0;
        for (Object key : resultHash.keySet()) {
            String a = key.toString();
            String b = Check1.checkt(a);
            String resultAll = (String) resultHash.get(a);
            String[] var = resultAll.split("!!!!");
            String c = var[0];
            String d = var[1];
            writeToXlsx.writeXlsx(xlsxPwd,i,0,"宋体",i+1+"");
            writeToXlsx.writeXlsx(xlsxPwd,i,1,"宋体",b);
            writeToXlsx.writeXlsx(xlsxPwd,i,2,"宋体",c);
            writeToXlsx.writeXlsx(xlsxPwd,i,3,"宋体",d);
            i += 1;
        }

    }

    public static void toPrint(HashMap resultHash){
//        writeToXlsx.createXlsx(xlsxPwd);
        int i = 0;
        for (Object key : resultHash.keySet()) {
            String a = key.toString();
            String b = Check1.checkt(a);
            String resultAll = (String) resultHash.get(a);
            String[] var = resultAll.split("!!!!");
            String c = var[0];
            String d = var[1];
            if(a.contains("系统补丁")){
                System.out.println(b+" "+c+" "+d);
            }

            i += 1;
        }

    }


}
