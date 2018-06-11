package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/6/7.
 *
 * 用于office 文件的读写操作……
 */
@Controller
@RequestMapping(value = "/poi")
public class PoiController {
    @Autowired
    private UserService userService;
    //----导入用户信息
    public void importUser(MultipartFile fileXls, String xlsName) throws Exception{
        //获得xls文件路径
        String filename = fileXls.getOriginalFilename();
        //
        Workbook workbook = new HSSFWorkbook(new FileInputStream(filename));
        Sheet sheet = workbook.getSheet(xlsName);


    }


    //---------------导出---------------------
    @RequestMapping(value = "/export",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    //------------------------------?????????
    public void export(String titles, String fileds, HttpServletResponse response){
        //标题行 title:汉字标题行   allFiled:User字段
        String[] title = titles.split(",");
        String[] allFiled = fileds.split(",");

        //创建xls文件
        Workbook workbook = new HSSFWorkbook();

        //设置日期格式
        DataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy-MM-dd");
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format);

        //创建工作表
        Sheet sheet = workbook.createSheet("工作表");

        //创建标题行   并赋值
        Row row = sheet.createRow(0);
        for (int i = 0; i < title.length; i++) {
            String s = title[i];   //拿到每一个标题
            Cell cell = row.createCell(i);   //创建单元格
            cell.setCellValue(s);
        }

        List<User> users = userService.queryAll();

        //创建数据行  多行多单元格  双层循环
        for (int i = 0; i < users.size(); i++) {
            //创建行   从第二行开始  下标1开始
            Row dataRow = sheet.createRow(i + 1);
            //遍历单元格
            for (int j = 0; j < allFiled.length; j++) {
                //创建单元格
                Cell dataCell = dataRow.createCell(j);
                //填充字段  先获得类对象--------------------------------------------?????????
                Class<? extends User> userClass = users.get(i).getClass();
                //拼接方法对象里的get方法
                String methodName = "get" + allFiled[j].substring(0, 1).toUpperCase() + allFiled[j].substring(1);
                //调拼接好的方法
                try {
                    //得到方法的返回值：字段
                    Object invoke = userClass.getDeclaredMethod(methodName, null).invoke(users.get(i), null);
                    if (invoke instanceof Date){
                        //处理日期类型  最后强转放进单元格
                        sheet.setColumnWidth(j,18*256);
                        dataCell.setCellStyle(cellStyle);
                        dataCell.setCellValue((Date)invoke);
                    }else {
                        dataCell.setCellValue(invoke.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }

        //设置响应头  响应类型
        String name="用户.xls";
        String fileName="";
        try {
            fileName = new String(name.getBytes("GBK"), "ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("content-disposition", "attachment;fileName=" + fileName);
        response.setContentType("application/vnd.ms-excel");   //导出文件固定格式

        //写出去
        try {
            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
