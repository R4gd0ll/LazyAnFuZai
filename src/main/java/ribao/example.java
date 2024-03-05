package ribao;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class example {
    public static void setPNG(XWPFRun imgRun,String pwd) {
        try {
            String imgFile = pwd;
            imgRun.addPicture(new FileInputStream(imgFile), XWPFDocument.PICTURE_TYPE_JPEG, imgFile, Units.toEMU(400), Units.toEMU(200)); // 200x200 pixels
            imgRun.addBreak(BreakType.TEXT_WRAPPING);
        } catch (Exception e) {
        }
    }

    public static void jiance(XWPFRun run,String title,String ip,String Stime,String Etime,String att){
        run.setText(title);
        run.addBreak(BreakType.TEXT_WRAPPING);
        run.setText("攻击ip："+ip);
        run.addBreak(BreakType.TEXT_WRAPPING);
        run.setText("发现时间："+Stime);
        run.addBreak(BreakType.TEXT_WRAPPING);
        run.setText("攻击时间："+Etime);
        run.addBreak(BreakType.TEXT_WRAPPING);
        run.setText("攻击类型："+att);
        run.addBreak(BreakType.TEXT_WRAPPING);

//        imgRun.addPicture(new FileInputStream(imgFile), XWPFDocument.PICTURE_TYPE_JPEG, imgFile, Units.toEMU(400), Units.toEMU(200));
    }

    public static void xiangxi(XWPFRun run,String title,String ip,String pwd1,String pwd2){


        run.setText(title);
        run.addBreak(BreakType.TEXT_WRAPPING);
        run.setText("1、监测到云防火墙安全报表，发现"+ip+"具有攻击行为");
        run.addBreak(BreakType.TEXT_WRAPPING);
        setPNG(run,pwd1);
        run.setText("2、经过内部业务排查，该IP并非属于公司IP，通过微步威胁情报平台对IP "+ip+"进行分析：");
        run.addBreak(BreakType.TEXT_WRAPPING);
        setPNG(run,pwd2);
        run.setText("确认"+ip+"为恶意地址，加入阿里云云防火墙黑名单策略。");
        run.addBreak(BreakType.TEXT_WRAPPING);
//        imgRun.addPicture(new FileInputStream(imgFile), XWPFDocument.PICTURE_TYPE_JPEG, imgFile, Units.toEMU(400), Units.toEMU(200));
    }
    public static void configOut(String config){
//        try {
//            FileOutputStream out = new FileOutputStream("config.ini");
//            out.write(config.getBytes());
//            out.close();
//        }catch (Exception e){
//
//        }
        try (FileOutputStream fos = new FileOutputStream("config.conf");
             OutputStreamWriter osw = new OutputStreamWriter(fos,"gb2312");
             BufferedWriter writer = new BufferedWriter(osw)) {
            writer.write(config);
        } catch (IOException e) {
        }

    }
}
