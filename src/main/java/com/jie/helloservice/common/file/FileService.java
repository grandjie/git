package com.jie.helloservice.common.file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

@Component
public class FileService {

    private static DecimalFormat df = new DecimalFormat("0");

    Logger logger = LoggerFactory.getLogger(FileService.class);

    @Autowired
    ObjectMapper mapper = new ObjectMapper();

    public String getFileDataToJson(String filePath, int sheetAt) {
        File file = new File(filePath);
        InputStream is = null;
        // 一个sheet表对于一个List
        List list = new LinkedList();
        if (file != null) {
            return getFileDataToJson(file, sheetAt);
        }
        return null;
    }

    public String getFileDataToJson(File file, int sheetAt) {
        String filePath = file.getName();
        InputStream is = null;
        // 一个sheet表对于一个List
        List list = new LinkedList();
        if (file != null) {
            try {
                is = new FileInputStream(file);
                return getFileDataToJson(is, sheetAt, filePath);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null) {
                        is.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return null;
    }

    public String getFileDataToJson(InputStream is, int sheetAt, String filePath) {
        // 一个sheet表对于一个List
        List list = new LinkedList();
        try {
            String ext = filePath.substring(filePath.lastIndexOf("."));
            Workbook workbook = null;
            if (".xls".equals(ext)) {
                workbook = new HSSFWorkbook(is);
            } else if (".xlsx".equals(ext)) {
                workbook = new XSSFWorkbook(is);
            } else {
                workbook = null;
            }
            //获取第几张表格
            Sheet sheet = workbook.getSheetAt(sheetAt);
            //起始行
            int firstRowIndex = sheet.getFirstRowNum();
            //最后一行
            int lastRowIndex = sheet.getLastRowNum();

            //遍历行数
            for (int i = firstRowIndex; i <= lastRowIndex; i++) {
                //一行对应一个map
                LinkedHashMap rowMap = new LinkedHashMap();
                //获取某一行
                Row row = sheet.getRow(i);
                if (row != null) {
                    //列数
                    int firstCellIndex = row.getFirstCellNum();
                    int lastCellIndex = row.getLastCellNum();
                    String[] data = new String[lastCellIndex];
                    //此处参数cIndex决定可以取到excel的列数。
                    for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {
                        Cell cell = row.getCell(cIndex);
                        String value = "";
                        if (cell != null) {
//                            value = cell.toString();
                            value = (String) getCellValue(cell);
                            data[cIndex] = value;
                            rowMap.put("str" + cIndex, value);
                        }
                    }
                }
                list.add(rowMap);
            }
            return mapper.writeValueAsString(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<FileData> fileDataList(String jsonFileData) {
        if (StringUtils.isEmpty(jsonFileData)) {
            return null;
        }
        List<FileData> list = null;
        try {
            list = mapper.readValue(jsonFileData, new TypeReference<List<FileData>>() {
            });
        } catch (IOException e) {
            logger.error("解析抵扣金额出错", e, e.getMessage());
            return null;
        }
        return list;
    }

    public static File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    private static Object getCellValue(Cell cell) {
        Object o = null;
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                o = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    o = cell.getDateCellValue();
                } else {
                    o = cell.getNumericCellValue();
                    o = df.format(o);
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                o = cell.getBooleanCellValue();
                break;
            case Cell.CELL_TYPE_FORMULA:
                o = cell.getCellFormula();
                break;
            case Cell.CELL_TYPE_BLANK:
                break;
            default:
        }
        return o;
    }

}
