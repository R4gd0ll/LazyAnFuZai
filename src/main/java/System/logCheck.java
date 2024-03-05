package System;

public class logCheck {
    public static String logCheck(String a,String b) {

        String result = "通过查看audit日志审计服务，状态为"+a.substring(0,a.indexOf(")")+1);
        if(a.contains("running")){
            result += "状态为开启";
        }else{
            result += "状态为关闭，不符合安全要求";
        }

        if(b.contains("-w")){
            result += "存在审计记录规则";
        }else{
            result += "不存在审计规则，不符合安全要求";
        }
        return result;
    }

    public static String logBakCheck(){
        String result = "系统日志存放于/var/log下,定期备份";
        return result;
    }
}
