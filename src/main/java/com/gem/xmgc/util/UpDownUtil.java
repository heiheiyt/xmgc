package com.gem.xmgc.util;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author jiowww
 * @data 2019/11/5.
 */
public class UpDownUtil {

    public static List getList(MultipartFile file, String type) throws ClassNotFoundException, IOException {
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        InputStream ins = file.getInputStream();
        File f = new File(file.getOriginalFilename());
        uploadToExcel(ins, f);
        return ExcelImportUtil.importExcel(f,
                Class.forName("com.gem.xmgc.entity." + type), params);
    }

    public static void uploadToExcel(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static String exportExcel(HttpServletResponse response, String type,List list, String excel, String sheet,String excelName) throws ClassNotFoundException {
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(excel, sheet),
                Class.forName("com.gem.xmgc.entity." + type), list);

        // 判断数据
        if (workbook == null) {
            return "fail";
        }
        // 设置excel的文件名称
//        String excelName = "测试excel";
        // 重置响应对象
        response.reset();
        // 当前日期，用于导出文件名称
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateStr = "[" + excelName + "-" + sdf.format(new Date()) + "]";
        // 指定下载的文件名--设置响应头
        response.setHeader("Content-Disposition", "attachment;filename=" + dateStr + ".xls");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        // 写出数据输出流到页面
        try {
            OutputStream output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            workbook.write(bufferedOutPut);
            bufferedOutPut.flush();
            bufferedOutPut.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

}
