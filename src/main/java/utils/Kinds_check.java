package utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Kinds_check {
    private static ArrayList<String> checkList;

    public Kinds_check() {
        this.checkType();
    }
    public static ArrayList<String> oakinds() {
        checkList = new ArrayList<>();
        checkList.add("用户身份认证");
        checkList.add("登录失败认证");
        checkList.add("用户权限分配");
        checkList.add("默认用户检查");
        checkList.add("共享用户检查");
        checkList.add("安全审计检查");
        checkList.add("日志备份检查");
        checkList.add("最小安装检查");
        checkList.add("高危端口检查");
        checkList.add("杀毒软件检查");
        checkList.add("系统补丁更新");
        checkList.add("软件兼容版本");
        checkList.add("系统备份机制");
        checkList.add("恶意代码防范");
        checkList.add("移动介质接入");
        checkList.add("远控软件检测");
        return checkList;
    }
    public static ObservableList<String> checkType() {
        ArrayList<String> OAlist = oakinds();
        return FXCollections.observableArrayList(OAlist);
    }
}
