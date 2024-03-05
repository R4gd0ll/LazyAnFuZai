package controller;


import Base.Check1;
import cn.hutool.core.util.StrUtil;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utils.CheckBase;
import utils.Kinds_check;

import java.io.File;
import System.*;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class baseCheckController {
    private final Kinds_check typeDecrypt = new Kinds_check();//初始化type相关数据

    private final ExecutorService service = Executors.newCachedThreadPool();
    public Button submit;
    public Button out;
    public TextField fileN;
    public TextArea info;
    public Button bash;
    public String selectedItem = null;
    public Button mod;
    public RadioButton yes;
    public RadioButton no;
    private boolean initialized = false;
    public static String content = "";
    public static String filename = "";
    public TextArea result;
    public HashMap resultHash = null;
    public Button file;
    public ListView<String> checkthings;
    public TextArea check;
    public TextArea nowthings;


    @FXML
    private void handleY() {
        ToggleGroup statusGroup = new ToggleGroup();
        yes.setToggleGroup(statusGroup);
        no.setToggleGroup(statusGroup);
        Platform.runLater(() -> {
            result.clear();
        });
//        System.out.println(no.getText());
        if (!yes.getText().contains("不")) {
            Platform.runLater(() -> {
                result.appendText(printResult.flag(true));
            });

        }
    }

    @FXML
    private void handleN() {
        ToggleGroup statusGroup = new ToggleGroup();
        yes.setToggleGroup(statusGroup);
        no.setToggleGroup(statusGroup);
        Platform.runLater(() -> {
            result.clear();
        });
//        System.out.println(no.getText());
        if (no!=null && no.getText().contains("不符合")) {
            Platform.runLater(() -> {
                result.appendText(printResult.flag(false));
            });

        }
    }

    @FXML
    void mod(){
        if(resultHash != null){
            if(selectedItem!=null && !StrUtil.isBlank(result.getText()) &&!StrUtil.isBlank(nowthings.getText())){
                String modStr = result.getText()+"!!!!"+nowthings.getText();
                resultHash.put(selectedItem,modStr);
                Platform.runLater(() -> {
                    info.appendText(selectedItem+" 修改成功\n");
                });
            }
        }
    }

    @FXML
    void getbash(){
        try (FileWriter writer = new FileWriter("check.sh")) {
            writer.write(utils.CheckBase.jiaoben());
            Platform.runLater(() -> {
                info.appendText("已生成check.sh脚本，请在服务器中执行并导入结果\n");
            });
        } catch (Exception e) {
            System.err.println("写入文件时出现错误: " + e.getMessage());
        }
    }
    @FXML
    void listview_clicked() {
        checkthings.setItems(typeDecrypt.checkType());
        Platform.runLater(() -> {
            check.clear();
            result.clear();
            nowthings.clear();
        });
        selectedItem = checkthings.getSelectionModel().getSelectedItem();
        String flag = "";
        try {
            flag = Check1.checkt(selectedItem);
        } catch (Exception e) {

        }
        String finalResult = flag;
        Platform.runLater(() -> {
            check.appendText(finalResult);
            nowthings.appendText("");
        });
        if (resultHash != null) {
            String resultAll = (String) resultHash.get(selectedItem);
            String[] var = resultAll.split("!!!!");
            Platform.runLater(() -> {
                result.setStyle("-fx-font-family: 'Wingdings 2';");
                result.appendText(var[0]);
                nowthings.appendText(var[1]);
            });
            if(var[0].contains("☑符合")){
                yes.setSelected(true);
            }else{
                no.setSelected(true);
            }
        }

    }

    @FXML
    void submit(){
        String[] array = printResult.dataArray(filename);
        resultHash = printResult.resultPrint(array,filename);
        if(!content.contains("@@")){
            Platform.runLater(() -> {
                info.appendText("请导入正确文件并提交\n");
            });
        }else{
            Platform.runLater(() -> {
                info.appendText("提交成功，点击左侧栏查看结果\n");
            });
        }
    }
    @FXML
    void Out(){

        utils.toFile.toXlsxFile(resultHash,"result.xlsx");
            Platform.runLater(() -> {
                info.appendText("result.xlsx导出成功\n");
            });

    }

    @FXML
    void chooseFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择文件");

        // 设置文件选择的初始目录
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        // 添加文件过滤器
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("文本文件 (*.txt)","CLASS文件 (*.class)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        // 获取主舞台
        Stage stage = (Stage) file.getScene().getWindow();

        // 显示文件选择对话框
        File selectedFile = fileChooser.showOpenDialog(stage);
        filename = selectedFile.getAbsolutePath();
        if (!filename.equals("")) {
            Platform.runLater(() -> {
                fileN.clear();
                fileN.setText(filename);
            });

            try {
                // 读取文件内容
                content = CheckBase.readFile(selectedFile.getAbsolutePath());

                Platform.runLater(() -> {
                    info.appendText("已读取"+filename+"文件内容\n");
                });


                // 将文件内容设置到TextArea中
//        textArea_source.setText(content);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    @FXML
    public void initialize() {

        //设置自动换行
        result.setEditable(false);
        info.setEditable(false);
        check.setEditable(false);
//        nowthings.setEditable(false);
        result.setWrapText(true);
        check.setWrapText(true);
        nowthings.setWrapText(true);

        //适配屏幕
        System.setProperty("prism.allowhidpi", "true");
        listview_clicked();
        // 第一次渲染该页面时渲染数据
        if (!initialized) {
            //更新列表数据
            initialized = true;
        }

    }
}
