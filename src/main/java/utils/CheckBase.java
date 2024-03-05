package utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class CheckBase {


    public static String readFile(String path){

//        try {
//            FileInputStream in = new FileInputStream(path);
//            int size=in.available();
//            byte[] buffer=new byte[size];
//            in.read(buffer);
//            in.close();
//            return new String(buffer);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try (FileInputStream fis = new FileInputStream(path);
             InputStreamReader isr = new InputStreamReader(fis,"gb2312");
             BufferedReader reader = new BufferedReader(isr)) {
            String line;
            String res = "";
            while ((line = reader.readLine()) != null) {
                res += line+"\n";
            }
            return res;
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        return null;
    }

    public static String jiaoben(){
        String sh = "#!/bin/bash\n" +
                "\n" +
                "result=\"test.txt\"\n" +
                "echo \"@@\" > \"$result\"\n" +
                "cat /etc/passwd | grep /bin/bash | awk -F: '{print $1, $3}' | while read user uid; do\n" +
                "    echo -n \"$user, uid: $uid \" >> \"$result\"\n" +
                "done\n" +
                "echo -e \"\\n@@\" >> \"$result\"\n" +
                "grep \"retry\" /etc/pam.d/system-auth >> \"$result\"\n" +
                "echo \" \" >> \"$result\"\n" +
                "echo -e \"@@\" >> \"$result\"\n" +
                "cat /etc/login.defs | grep -E '^[^#].*' | grep  -E 'PASS_MAX_DAYS|PASS_MIN_DAYS|PASS_MIN_LEN|PASS_WARN_AGE' >> \"$result\"\n" +
                "echo \" \" >> \"$result\"\n" +
                "echo  \"@@\" >> \"$result\"\n" +
                "cat /etc/profile | grep 'TMOUT' >> \"$result\"\n" +
                "echo \" \" >> \"$result\"\n" +
                "echo \"@@\" >> \"$result\"\n" +
                "cat /etc/passwd | grep '/bin/bash' | awk -F: '{print $1}' >> \"$result\"\n" +
                "echo \" \" >> \"$result\"\n" +
                "echo \"@@\" >> \"$result\"\n" +
                "cat /etc/shadow | awk -F: '{print $1,$2}' >> \"$result\"\n" +
                "echo \" \" >> \"$result\"\n" +
                "echo  \"@@\" >> \"$result\"\n" +
                "systemctl status auditd | grep active >> \"$result\"\n" +
                "echo \" \" >> \"$result\"\n" +
                "echo \"@@\" >> \"$result\"\n" +
                "cat /etc/audit/rules.d/audit.rules | grep -E '^[^#].*' >> \"$result\"\n" +
                "echo \" \" >> \"$result\"\n" +
                "echo  \"@@\" >> \"$result\"\n" +
                "yum grouplist >> \"$result\"\n" +
                "echo \" \" >> \"$result\"\n" +
                "echo  \"@@\" >> \"$result\"\n" +
                "netstat -anptul | grep -E ':22|:135|:137|:138|:139|:445|:3389' | awk '{print $4}' | grep -E '^[^::].*' | awk -F: '{print $2}'|uniq >> \"$result\"\n" +
                "echo \" \" >> \"$result\"\n" +
                "echo  \"@@\" >> \"$result\"\n" +
                "yum history list >> \"$result\"\n" +
                "echo \" \" >> \"$result\"\n" +
                "echo  \"@@\" >> \"$result\"\n" +
                "ps aux | grep unlogin | grep -v 'grep' >> \"$result\"\n" +
                "echo \" \" >> \"$result\"\n" +
                "echo \"@@\" >> \"$result\"\n";
        return sh;
    }
}
