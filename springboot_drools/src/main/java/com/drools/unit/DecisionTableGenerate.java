package com.drools.unit;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;


public class DecisionTableGenerate {

    private final static Logger logger = LoggerFactory.getLogger(DecisionTableGenerate.class);

    /**
     * 主方法，修改需要有excel编译为drl的文件夹路径，然后右键run as运行即可
     *
     * @param args
     * 不需要传参
     */
    public static final void main(String[] args) {
        DecisionTableGenerate dtg = new DecisionTableGenerate();
//        aa.traverseFolder2("E:/任务/新核心系统建设/svn/04_Development/02_Auto/费率/4商业险手续费比例上限");
        dtg.traverseFolder2("E:\\PROJECT\\drools\\springboot_drools");
    }

    /**
     * 工具方法
     * @param path
     *  路径
     */
    private void traverseFolder2(String path) {

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                logger.info("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        traverseFolder2(file2.getAbsolutePath());
                    } else {
                        String droolsFilePath = file2.getAbsolutePath();
                        String[] split = droolsFilePath.split("\\.");
                        if (split.length == 2 && "xls".equals(split[1])) {
                            transfromRules(droolsFilePath);
                            logger.info("文件:{}", droolsFilePath);
                        }
                    }
                }
            }
        } else {
            logger.info("文件不存在!");
        }
    }

    /**
     * 工具方法xls规则转换成drl文件
     * @param path
     */
    private void transfromRules(String path) {
        try {
            SpreadsheetCompiler sc = new SpreadsheetCompiler();
            File f = new File(path);
            // String fileName = f.getName();
            // String name = fileName.substring(0,fileName.lastIndexOf("."));
            FileInputStream xlsStream = new FileInputStream(f);
            String drlFileTmp = sc.compile(xlsStream, InputType.XLS);
            drlFileTmp.replaceAll(".xls", ".drl");
            path = path.replaceAll(".xls", ".drl");
            File drlFile = new File(path);
            FileWriter writer = new FileWriter(drlFile);
            writer.write(drlFileTmp);
            writer.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
