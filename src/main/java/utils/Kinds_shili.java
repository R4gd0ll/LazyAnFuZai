package utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Kinds_shili {
    private static ArrayList<String> shiliList;

    public Kinds_shili() {
        this.shiliType();
    }
    public static ArrayList<String> oakinds() {
        shiliList = new ArrayList<>();
        shiliList.add("事件一");
        shiliList.add("事件二");
        shiliList.add("事件三");
        shiliList.add("事件四");
        shiliList.add("事件五");
        shiliList.add("事件六");
        shiliList.add("事件七");
        shiliList.add("事件八");
        shiliList.add("事件九");
        shiliList.add("事件十");
        shiliList.add("事件十一");
        shiliList.add("事件十二");
        shiliList.add("事件十三");
        shiliList.add("事件十四");
        shiliList.add("事件十五");
        shiliList.add("事件十六");
        shiliList.add("事件十七");
        shiliList.add("事件十八");
        shiliList.add("事件十九");
        shiliList.add("事件二十");
        return shiliList;
    }
    public static ObservableList<String> shiliType() {
        ArrayList<String> OAlist = oakinds();
        return FXCollections.observableArrayList(OAlist);
    }
}
