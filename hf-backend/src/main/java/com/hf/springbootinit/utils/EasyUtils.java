package com.hf.springbootinit.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.hf.springbootinit.model.entity.EchartParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Easy Excel工具类
 */
public class EasyUtils {

    public static List<String> readFile(MultipartFile file) throws IOException {
        List<String> list = new ArrayList<>();
        EasyExcel.read(file.getInputStream(), EchartParam.class, new PageReadListener<EchartParam>(dataList -> {
            for (EchartParam demoData : dataList) {
                String demoDataString = demoData.toString();
                list.add(demoDataString);
            }
        })).sheet().doRead();
        return list;
    }


}
