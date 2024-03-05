package System;

public class loginCheck {
    public static String loginCheck(String a,String pwd) {
        String result = "查看登录失败处理功能,";
        int flag = 0;
        if(!a.isEmpty()&& a!=""){
            flag += 1;
            try{
                String b = a.substring(a.indexOf("=")+1);
                result = result + "登录"+b+"秒后无操作超时，";
            }catch (Exception e){

            }
        }else{
            result = result + "未做登录超时配置，不符合安全要求";
        }

        String[] c = printResult.dataArray(pwd)[1].split("\\s+");
        for(String d : c){
            if(d.contains("retry=")){
                result = result + retry(d)[0];
                flag = flag + Integer.parseInt(retry(d)[1]);
            }
        }

        if(flag<1){
            result = result + "不符合安全要求";
        }
        return result;
    }
    private static String[] retry(String d){
        String[] a = new String[2];
        String result = "";
        int f = 0;
        String i = d.substring(d.length()-1);
        if(d.contains("retry=")){
            if(!i.contains("=")){
                f = f+1;
                result = result + "失败"+i+"次锁定";
            }
        }else{
            result = result + "没有失败锁定配置，";
        }
        a[0] = result;
        a[1] = ""+f;
        return a;
    }
}
