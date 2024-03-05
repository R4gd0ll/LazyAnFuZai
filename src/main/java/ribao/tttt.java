package ribao;

import controller.ribaoController;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.util.HashMap;

public class tttt {
    public static void daochu(HashMap<String,String[]> result,String[] base,String name) {
        try {
            XWPFDocument document = new XWPFDocument();

            // 添加标题
            XWPFRun runTitle1 = wordType.btType(document,"黑体",16,true);
            XWPFRun run1 = wordType.zwType(document,"宋体",14,false);


            XWPFRun runTitle2 = wordType.btType(document,"黑体",16,true);
            XWPFRun run2 = wordType.zwType(document,"宋体",14,false);
            XWPFRun run3 = wordType.zwType(document,"宋体",14,false);
            XWPFRun run4 = wordType.zwType(document,"宋体",14,false);

            XWPFRun runTitle3 = wordType.btType(document,"黑体",16,true);
            XWPFRun run5 = wordType.zwType(document,"宋体",14,false);

            XWPFRun runTitle4 = wordType.btType(document,"黑体",16,true);
            XWPFRun run6 = wordType.zwType(document,"宋体",14,false);



            runTitle1.setText("一、总体监测");
            run1.setText("2024年3月04日09时至3月04日18时, 共监测发现攻击事件"+base[0]+"起，失败"+base[1]+"起，攻击成功"+base[2]+"起。受攻击资产数量："+base[3]+"个，失陷："+base[4]+"。");
            run1.addBreak(BreakType.TEXT_WRAPPING);
            run1.setText("今日监控网络整体态势：优。");
            run1.addBreak(BreakType.TEXT_WRAPPING);
            run1.addBreak(BreakType.TEXT_WRAPPING);

            String[] shiliNum = {"事件一","事件二","事件三","事件四","事件五","事件六","事件七","事件八","事件九","事件十","事件十一","事件十二","事件十三","事件十四","事件十五","事件十六","事件十七","事件十八","事件十九","事件二十"};
            runTitle2.setText("二、监测攻击");
            run2.setText("（一）基本情况");
            run2.addBreak(BreakType.TEXT_WRAPPING);
            for(int j= 0 ;j <= result.size()-1;j++){
                String i = shiliNum[j];
                String[] jianceResult = result.get(i);
                example.jiance(run2,i+"：",jianceResult[0],jianceResult[1], jianceResult[2],jianceResult[3]);
                example.setPNG(run2,jianceResult[4]);
            }


            run3.setText("（二）攻击简述");
            run3.addBreak(BreakType.TEXT_WRAPPING);
            run3.setText("进一步分析攻击地址以及告警流量内容，确定为非正常业务流量，确定云上资产受到恶意攻击。");
            run3.addBreak(BreakType.TEXT_WRAPPING);

            run4.setText("（三）详细过程");
            run4.addBreak(BreakType.TEXT_WRAPPING);
            for(int j= 0 ;j <= result.size()-1;j++){
                String i = shiliNum[j];
                String[] jianceResult = result.get(i);
                example.xiangxi(run4,i+"：",jianceResult[0], jianceResult[5], jianceResult[6]);

            }




            runTitle3.setText("三、封禁恶意地址");
            run5.setText("前述事件所有恶意IP地址 ：均已加入阿里云云防火墙黑名单。");
            example.setPNG(run5,base[5]);


            runTitle4.setText("四、追踪溯源");
            run6.setText("今日无溯源事件");

            FileOutputStream out = new FileOutputStream(name);
            document.write(out);
            out.close();

            System.out.println("Word document created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}