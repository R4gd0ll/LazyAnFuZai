package System;

public class systemCheck {
    public static String installCheck(String a){
        String result = "yum grouplist查看已安装组件，";
        if(a.contains("最小安装") || a.contains("Minimal Install")){
            result += "存在环境分组且具备最小安装";
        }else {
            result += "存在环境分组且不具备最小安装，不符合安全要求";
        }
        return result;
    }
    public static String portCheck(String a){
        String[] b = a.split("\n");
        String result = "netstat查看开放端口，";
        if(b.length == 0 ) {
            result += "没有开放高危端口。";
            return result;
        }else{
            result += "开放";
        }
        for(String i : b){
            if(i.contains("22")){
                result += "22、";
            }else if(i.contains("135")){
                result += "135、";
            }else if(i.contains("137")){
                result += "137、";
            }else if(i.contains("138")){
                result += "138、";
            }else if(i.contains("139")){
                result += "139、";
            }else if(i.contains("445")){
                result += "445、";
            }else if(i.contains("3389")){
                result += "3389、";
            }
        }
        result += "共"+b.length+"个高危端口，不符合安全要求";

        return result;
    }
    public static String killCheck(){
        String result = "未发现常用杀毒软件，不符合安全要求";
        return result;
    }

    public static String budingCheck(String a){
        String[] b = a.split("\n");
        String d = b[3].replace("|","@").split("@")[2];
        String result = "yum history list查看补丁安装情况，最近补丁安装时间为"+d;
        if(d.contains("2022")||d.contains("2023")||d.contains("2024")){
            return result;
        }
        return result+"，不符合安全要求";
    }

    public static String otherCheck(){
        String result = "自行查看，默认不符合安全要求";
        return result;
    }

    public static String UpanCheck(){
        String result = "不允许移动介质类设备接入服务器，符合安全规范";
        return result;
    }

    public static String sunloginCheck(String a){
        String result = "ps查看进程，";
        if(a!=" " || !a.contains(" ")){
            result += "未发现向日葵进程";
        }else{
            result += "发现向日葵进程，不符合安全要求";
        }

        return result;
    }
}
