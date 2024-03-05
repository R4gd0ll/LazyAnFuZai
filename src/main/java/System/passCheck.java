package System;

public class passCheck {
    public static String passCheck(String a) {
        String result = "查看/etc/pam.d/system-auth密码复杂度";
        String[] b = {"ucredit=","lcredit=","minlen=","dcredit=","retry=","ocredit="};
        String[] c = a.split("\\s+");
        int flag = 0;
        for(String d : c){
            if(d.contains("=")){
                for(String e : b){
                    if(d.contains(e)){
                        result = result + checkpassword(d)[0];
                        flag = flag + Integer.parseInt(checkpassword(d)[1]);
                    }
                }
            }
        }
        if(flag<3){
            result = result + "不符合安全要求";
        }
        return result;
    }

    public static String[] checkpassword(String flag){
        String[] res = new String[2];
        String result = "";
        int f = 0;
        String i = flag.substring(flag.length()-1);
        if(flag.contains("ucredit=")){
            if(!i.contains("=")){
                f = f+1;
                result = result + "至少"+i+"个大写字母，";
            }else{
                result = result + "大写字母数量不符合要求，";
            }
        }else{
            result = result + "大写字母数量不符合要求，";
        }

        if(flag.contains("lcredit=")){
            if(!i.contains("=")){
                f = f+1;
                result = result + "至少"+i+"个小写字母，";
            }else{
                result = result + "小写字母数量不符合要求，";
            }
        }else{
            result = result + "小写字母数量不符合要求，";
        }

        if(flag.contains("dcredit=")){
            if(!i.contains("=")){
                f = f+1;
                result = result + "至少"+i+"个数字，";
            }else{
                result = result + "数字数量不符合要求，";
            }
        }else{
            result = result + "数字数量不符合要求，";
        }

        if(flag.contains("ocredit=")){
            if(!i.contains("=")){
                f = f+1;
                result = result + "至少"+i+"个特殊字符，";
            }else{
                result = result + "特殊字符数量不符合要求，";
            }
        }else{
            result = result + "特殊字符数量不符合要求，";
        }

        if(flag.contains("retry=")){
            if(!i.contains("=")){
                f = f+1;
                result = result + "失败"+i+"次锁定，";
            }
        }else{
            result = result + "没有失败锁定配置，";
        }
        res[0] = result;
        res[1] = ""+f;
        return res;
    }
}
