package com.jie.helloservice.common.file;

import java.util.List;

public class FileTest {

    public static void main(String[] args) throws Exception {
        FileService fileService = new FileService();
        String json = fileService.getFileDataToJson("/Users/babijava/Downloads/sqlresult_2745958.csv", 0);
        List<FileData> fileData = fileService.fileDataList(json);
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `store` WHERE id IN (");
        for (FileData fileDatum : fileData) {

            //update `store` SET `area_id` = 'e85829dd-3fa9-400f-ad94-183ea38d7765' where `id`  = '003b491f-93d2-4a42-989e-59162c366202';
            //SELECT * FROM `store` WHERE id IN ('111','11');
            sb.append("'").append(fileDatum.getStr0()).append("',");
        }
        sb.append(");");
        System.out.println(sb.toString());
    }
}