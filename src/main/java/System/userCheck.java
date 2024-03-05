package System;

public class userCheck {
    public static String userCheck(String a){
        String result = "";
        String[] b = a.split("\n");
        if(b.length < 2){
            result += "共"+b.length+"个用户，且uid权限不同";
        }else{
            result += "仅1个用户，权限最大，不符合安全要求";
        }
        return result;
    }

    public static String defUserCheck(String a,String aa){
        String[] bb = aa.split("\n");
        String[] b = a.split("\n");
        String result = "除去可登录用户外,查看/etc/shadow文件发现共"+(b.length-bb.length)+"个默认用户，均无密码且无法登录";
        return result;
    }

    public static String ShareUserCheck() {
        String result = "经/etc/shadow与/etc/passwd以及用户需求对比，不存在共享用户";
        return result;
    }
}
