package System;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

public class printResult {
    public static String[] dataArray(String pwd){
        String[] dataArray = new String[100000];
        int index = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(pwd))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("@@") && sb.length() > 0) {
                    dataArray[index] = sb.toString().replace("@@","").trim();
                    sb.setLength(0);
                    index++;
                } else {
                    sb.append(line).append("\n");
                }
            }
            if (sb.length() > 0) {
                dataArray[index] = sb.toString().replace("@@","").trim();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataArray;
    }

    public static String flag(Boolean f){
        if(f){
            return "☑符合\n□不符合";
        }else {
            return "□符合\n☑不符合";
        }
    }
    public static HashMap<String, Objects> resultPrint(String[] data,String pwd){
        HashMap setting = new LinkedHashMap();
        String content = null;
        Boolean f = false;
        String flag = "";

        String[] array = data;

        //check.passCheck
        content = passCheck.passCheck(array[1]);
        content = "/etc/passwd文件中存在以下可登录用户："+array[0]+","+content;
        f = !content.contains("不符合安全要求");
        flag = printResult.flag(f);
        setting.put("用户身份认证",flag+"!!!!"+content);

        //check.loginCheck
        content = loginCheck.loginCheck(array[3],pwd);
        f = !content.contains("不符合安全要求");
        flag = printResult.flag(f);
        setting.put("登录失败认证",flag+"!!!!"+content);

        //userPri
        content = userCheck.userCheck(array[4]);
        content = "/etc/passwd文件中存在以下可登录用户："+array[0]+","+content;
        f = !content.contains("不符合安全要求");
        flag = printResult.flag(f);
        setting.put("用户权限分配",flag+"!!!!"+content);

        //defUserPri
        content = userCheck.defUserCheck(array[5],array[4]);
        content = "/etc/passwd文件中存在以下可登录用户："+array[0]+","+content;
        f = !content.contains("不符合安全要求");
        flag = printResult.flag(f);
        setting.put("默认用户检查",flag+"!!!!"+content);

        //shareUser
        content = userCheck.ShareUserCheck();
        f = !content.contains("不符合安全要求");
        flag = printResult.flag(f);
        setting.put("共享用户检查",flag+"!!!!"+content);


        //check.logCheck
        content = logCheck.logCheck(array[6],array[7]);
        f = !content.contains("不符合安全要求");
        flag = printResult.flag(f);
        setting.put("安全审计检查",flag+"!!!!"+content);


        //logBakCheck
        content = logCheck.logBakCheck();
        f = !content.contains("不符合安全要求");
        flag = printResult.flag(f);
        setting.put("日志备份检查",flag+"!!!!"+content);


        //installCheck
        content = systemCheck.installCheck(array[8]);
        f = !content.contains("不符合安全要求");
        flag = printResult.flag(f);
        setting.put("最小安装检查",flag+"!!!!"+content);

        //portCheck
        content = systemCheck.portCheck(array[9]);
        f = !content.contains("不符合安全要求");
        flag = printResult.flag(f);
        setting.put("高危端口检查",flag+"!!!!"+content);

        //killCheck
        content = systemCheck.killCheck();
        f = !content.contains("不符合安全要求");
        flag = printResult.flag(f);
        setting.put("杀毒软件检查",flag+"!!!!"+content);

        //budingCheck
        content = systemCheck.budingCheck(array[10]);
        f = !content.contains("不符合安全要求");
        flag = printResult.flag(f);
        setting.put("系统补丁更新",flag+"!!!!"+content);

        //otherCheck
        content = systemCheck.otherCheck();
        f = !content.contains("不符合安全要求");
        flag = printResult.flag(f);
        setting.put("软件兼容版本",flag+"!!!!"+content);

        //otherCheck
        content = systemCheck.otherCheck();
        f = !content.contains("不符合安全要求");
        flag = printResult.flag(f);
        setting.put("系统备份机制",flag+"!!!!"+content);

        //otherCheck
        content = systemCheck.otherCheck();
        f = !content.contains("不符合安全要求");
        flag = printResult.flag(f);
        setting.put("恶意代码防范",flag+"!!!!"+content);

        //UpanCheck
        content = systemCheck.UpanCheck();
        f = !content.contains("不符合安全要求");
        flag = printResult.flag(f);
        setting.put("移动介质接入",flag+"!!!!"+content);

        //otherCheck
        content = systemCheck.sunloginCheck(array[11]);
        f = !content.contains("不符合安全要求");
        flag = printResult.flag(f);
        setting.put("远控软件检测",flag+"!!!!"+content);


        return setting;
    }
}
