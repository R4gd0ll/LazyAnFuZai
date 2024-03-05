package controller;

import Base.Check1;
import cn.hutool.core.util.StrUtil;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ribao.example;
import ribao.tttt;
import utils.CheckBase;
import utils.Kinds_check;
import utils.Kinds_shili;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ribaoController {

    private final ExecutorService service = Executors.newCachedThreadPool();
    public static HashMap<String,String[]> result = new LinkedHashMap();
    public String config = "";
    public static Boolean flag = true;
    public static String[] jiben = new String[6];
    public Button tijiao2;
    public Button tijiao3;
    public TextField attip;
    public Button jietu11;
    public TextField xiangqing;
    public TextArea info;
    public Button IC;
    public Button OC;
    public TextField configName;
    private boolean initialized = false;
    public String selectedItem = "事件一";
    public ListView<String> shili;
    public TextField faxian;
    public TextField jiben1;
    public TextField jiben2;
    public TextField jiben3;
    public TextField jiben4;
    public TextField jiben5;
    public TextField gongji;
    public TextField leixing;
    public TextField baobiao;
    public Button jietu1;
    public TextField qingbao;
    public Button jietu2;
    public TextField fengjin1;
    public Button fengjin;
    public Button tijiao;

    @FXML
    void ConfigIn(){
        Platform.runLater(() -> {
            jiben1.clear();
            jiben2.clear();
            jiben3.clear();
            jiben4.clear();
            jiben5.clear();
            fengjin1.clear();
            attip.clear();
            faxian.clear();
            gongji.clear();
            xiangqing.clear();
            leixing.clear();
            baobiao.clear();
            qingbao.clear();
        });
        String filename = chooseFile(IC);
        if (!filename.equals("") && filename.contains("config.conf")) {
            result = new LinkedHashMap<>();
            Platform.runLater(() -> {
                configName.clear();
                configName.setText(filename);
            });

            try {
                // 读取文件内容
                config = CheckBase.readFile(filename);
                if(!config.contains("!!!!")){
                    Platform.runLater(() -> {
                        info.appendText("非config文件\n");
                    });
                    return;
                }

                Platform.runLater(() -> {
                    info.appendText("已读取"+filename+"文件内容\n");
                });

                String[] var = config.split("!!!!\n");
                jiben = var[1].split("\n");


                Platform.runLater(() -> {
                    jiben1.appendText(jiben[0]);
                    jiben2.appendText(jiben[1]);
                    jiben3.appendText(jiben[2]);
                    jiben4.appendText(jiben[3]);
                    jiben5.appendText(jiben[4]);
                    fengjin1.appendText(jiben[5]);
                });

                for(int i = 2 ;i<var.length;i++){
                    String[] varR = new String[7];
                    varR[0] = var[i].split("\n")[1];
                    varR[1] = var[i].split("\n")[2];
                    varR[2] = var[i].split("\n")[3];
                    varR[3] = var[i].split("\n")[4];
                    varR[4] = var[i].split("\n")[5];
                    varR[5] = var[i].split("\n")[6];
                    varR[6] = var[i].split("\n")[7];
                    result.put(var[i].split("\n")[0],varR);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void ConfigOut(){
        if(result.size()<1){
            flag = false;
            Platform.runLater(() -> {
                info.appendText("请记录完后保存才可导出配置文件\n");
            });
            return;
        }
        String[] shiliNum = {"事件一","事件二","事件三","事件四","事件五","事件六","事件七","事件八","事件九","事件十","事件十一","事件十二","事件十三","事件十四","事件十五","事件十六","事件十七","事件十八","事件十九","事件二十"};
        config = "";
        config = config + "!!!!\n"+jiben[0]+"\n"+jiben[1]+"\n"+jiben[2]+"\n"+jiben[3]+"\n"+jiben[4]+"\n"+jiben[5]+"\n";
        for(int i = 0 ; i < result.size();i++){
            String j = shiliNum[i];
            String[] var = result.get(j);
            StringBuilder sb = new StringBuilder();
            sb.append("!!!!\n");
            sb.append(j).append("\n");
            for (String str : var) {
                sb.append(str).append("\n");
            }
            String result = sb.toString();
            config = config + result;
        }
        example.configOut(config.replace("null"," "));
        Platform.runLater(() -> {
            info.appendText("已导出配置文件 config.conf\n");
        });
    }

    @FXML
    void setTijiao2(){
        if(StrUtil.isBlank(jiben1.getText()) || StrUtil.isBlank(jiben2.getText()) || StrUtil.isBlank(jiben3.getText()) || StrUtil.isBlank(jiben4.getText()) || StrUtil.isBlank(jiben5.getText()) || StrUtil.isBlank(fengjin1.getText())){
            flag = false;
            Platform.runLater(() -> {
                info.appendText("请完成基本信息的填写\n");
            });
            return;
        }
        jiben[0] = jiben1.getText();
        jiben[1] = jiben2.getText();
        jiben[2] = jiben3.getText();
        jiben[3] = jiben4.getText();
        jiben[4] = jiben5.getText();
        jiben[5] = fengjin1.getText();
        Platform.runLater(() -> {
            info.appendText("基本信息已提交\n");
        });

    }
    @FXML
    void setdaochu(){

        if(result.size()<1){
            flag = false;
            Platform.runLater(() -> {
                info.appendText("请记录完后保存才可导出报告文件\n");
            });
            return;
        }
        setTijiao2();
        if(!flag){
            return;
        }

        ConfigOut();
        if(!flag){
            return;
        }
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String formattedDate = sdf.format(currentDate);
        String name = "值守报告("+formattedDate+").docx";
        tttt.daochu(result,jiben,name);

        Platform.runLater(() -> {
            info.appendText("已导出文件 "+name+"\n");
        });

    }
    @FXML
    void setJietu11(){
        Platform.runLater(() -> {
            xiangqing.clear();
            xiangqing.appendText(chooseFile(jietu1));
        });
    }
    @FXML
    void setJietu1(){
        Platform.runLater(() -> {
            baobiao.clear();
            baobiao.appendText(chooseFile(jietu1));
        });
    }
    @FXML
    void setJietu2(){
        Platform.runLater(() -> {
            qingbao.clear();
            qingbao.appendText(chooseFile(jietu2));
        });
    }
    @FXML
    void setJietu3(){
        Platform.runLater(() -> {
            fengjin1.clear();
            fengjin1.appendText(chooseFile(fengjin));
        });
    }

    @FXML
    void listview_clicked() {
        shili.setItems(Kinds_shili.shiliType());
        selectedItem = shili.getSelectionModel().getSelectedItem();
        Platform.runLater(() -> {
            attip.clear();
            faxian.clear();
            gongji.clear();
            xiangqing.clear();
            leixing.clear();
            baobiao.clear();
            qingbao.clear();
        });
        if(result.size()>=1){
            try {
                Platform.runLater(() -> {
                    info.appendText("已读取 "+selectedItem+" 的记录信息，可进行修改\n");
                    attip.appendText(result.get(selectedItem)[0]);
                    faxian.appendText(result.get(selectedItem)[1]);
                    gongji.appendText(result.get(selectedItem)[2]);
                    leixing.appendText(result.get(selectedItem)[3]);
                    xiangqing.appendText(result.get(selectedItem)[4]);
                    baobiao.appendText(result.get(selectedItem)[5]);
                    qingbao.appendText(result.get(selectedItem)[6]);
                });
            }catch (Exception e){}
        }
    }

    @FXML
    void submit(){
        String attipText = attip.getText();
        String gongjiText = gongji.getText();
        String faxianText = faxian.getText();
        String leixingText = leixing.getText();
        String xiangqingText = xiangqing.getText();
        String baobiaoText = baobiao.getText();
        String qingbaoText = qingbao.getText();
        if(selectedItem==null){
            selectedItem = "事件一";
        }
        if(StrUtil.isBlank(xiangqingText) || StrUtil.isBlank(attipText) || StrUtil.isBlank(faxianText) || StrUtil.isBlank(gongjiText) || StrUtil.isBlank(leixingText) || StrUtil.isBlank(baobiaoText) || StrUtil.isBlank(qingbaoText)){
            flag = false;
            Platform.runLater(() -> {
                info.appendText("请完成 "+selectedItem+" 的记录信息并提交\n" );
            });
            return;
        }
        String[] Text = new String[7];
        Text[0] = attipText;
        Text[1] = faxianText;
        Text[2] = gongjiText;
        Text[3] = leixingText;
        Text[4] = xiangqingText;
        Text[5] = baobiaoText;
        Text[6] = qingbaoText;

        result.put(selectedItem,Text);
        Platform.runLater(() -> {
            info.appendText("已提交 "+selectedItem+" 记录信息\n" );
        });
    }

    @FXML
    public void initialize() {


        //适配屏幕
        selectedItem = "事件一";
        System.setProperty("prism.allowhidpi", "true");
        listview_clicked();
        // 第一次渲染该页面时渲染数据
        if (!initialized) {
            //更新列表数据
            initialized = true;
        }

    }

    public String chooseFile(Button button){
        info.setWrapText(true);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择文件");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("所有文件", "*.*")
        );

        // 获取主舞台
        Stage stage = (Stage) button.getScene().getWindow();

        // 显示文件选择对话框
        File selectedFile = fileChooser.showOpenDialog(stage);
        return selectedFile.getAbsolutePath();
    }
}
