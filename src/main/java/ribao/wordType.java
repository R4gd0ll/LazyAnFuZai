package ribao;

import org.apache.poi.xwpf.usermodel.*;

public class wordType {
    public static XWPFRun zwType(XWPFDocument document,String font, int size,boolean bold){
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setFirstLineIndent(400); // 设置首行缩进为2厘米
        paragraph.setSpacingBetween(1, LineSpacingRule.AUTO); // 设置行距为1.5倍
        XWPFRun run = paragraph.createRun();
        run.setFontFamily(font);
        run.setFontSize(size);
        run.setBold(bold);
        return run;
    }

    public static XWPFRun btType(XWPFDocument document,String font, int size,boolean bold){
        XWPFParagraph title1 = document.createParagraph();
        title1.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun runTitle1 = title1.createRun();
        runTitle1.setFontFamily(font);
        runTitle1.setFontSize(size);
        runTitle1.setBold(bold);
        return runTitle1;
    }
}
