package com.kente.demo.service.impl;

import cn.hutool.poi.excel.*;
import com.kente.demo.pojo.Kentecom;
import com.kente.demo.pojo.Kenteother;
import com.kente.demo.pojo.Task;
import com.kente.demo.service.MainExporeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class MainExporeServciceImpl implements MainExporeService {
    @Override
    public void operateData(String dir) {
        //获取第一个表中的全部数据
        ExcelReader reader = ExcelUtil.getReader(new File(dir),"公司投标信息统计表");
        //将该数据格式化
        Task task = new Task();
        task.setOperateTime(new Date());
        List<List<Object>> readAll = reader.read();
        List<Kentecom> kenteList = new ArrayList<>();
        for (int r = 2; r < readAll.size(); r++) {
            List<Object> line = readAll.get(r);
            Kentecom kentecom = initKenteCom(line,task.getId());
            kenteList.add(kentecom);
        }
        //关闭阅读器
        reader.close();
        ExcelReader  reader1 = ExcelUtil.getReader(new File(dir),"制造厂商授权统计表");
        List<List<Object>> realOther = reader1.read();
        List<Kentecom> otherList = new ArrayList<>();
        for (int r = 2; r < realOther.size(); r++) {
            List<Object> line = realOther.get(r);
            Kentecom kenteother = initOtherCom(line,task.getId());
            otherList.add(kenteother);
        }
        reader1.close();
        //画表头
        try {
            try {
                initExcel(dir,"公司投标汇总表","2020年项目公司投标汇总表");
            } catch (Exception e) {
               log.info("初始化表头   公司投标汇总表   失败 ",e);
            }
            try {
                initExcel(dir,"授权代理商投标汇总表","2020年项目授权代理商投标汇总表");
            } catch (Exception e) {
                log.info("初始化表头   授权代理商投标汇总表   失败 ",e);
            }
            try {
                initExcel(dir,"2020投标汇总表","2020年项目投标汇总表");
            } catch (Exception e) {
                log.info("初始化表头   2020投标汇总表   失败 ",e);
            }
        } catch (Exception e) {
            log.error("初始化表头失败 原因未知",e);
        }
        List<List<Object>> comDataRows = getComData(kenteList);
        List<List<Object>> otherDataRows = getComData(otherList);
        List<Kentecom> allList = new ArrayList<>();
        allList.addAll(kenteList);
        allList.addAll(otherList);
        List<List<Object>> allRows = getComData(allList);

        ExcelWriter writer = ExcelUtil.getWriter(dir,"公司投标汇总表");
        writer.setCurrentRow(3);
        writer.write(comDataRows);
        writer.close();

        writer = ExcelUtil.getWriter(dir,"授权代理商投标汇总表");
        writer.setCurrentRow(3);
        writer.write(otherDataRows);
        writer.close();
        writer = ExcelUtil.getWriter(dir,"2020投标汇总表");
        writer.setCurrentRow(3);
        writer.write(allRows);
        writer.close();

    }

    /**
     * 将excel的数据初始化进对象中
     * @param line 一行
     * @param taskId
     * @return
     */
    @Override
    public Kentecom initKenteCom (List<Object> line, Integer taskId) {
        Kentecom kentecom = new Kentecom();
        //结构化数据
        //月份
        kentecom.setMouth(String.valueOf(line.get(1)));
        //开标日期
        kentecom.setDate(String.valueOf(line.get(2)));
        //商务制作人
        kentecom.setBusinessCreater(String.valueOf(line.get(3)));
        //技术制作人
        kentecom.setTechCreater(String.valueOf(line.get(4)));
        //行业分类
        kentecom.setIndustry(String.valueOf(line.get(5)));
        //级别
        kentecom.setLv(String.valueOf(line.get(6)));
        //项目类别
        kentecom.setType(String.valueOf(line.get(7)));
        //产品名称
        kentecom.setProName(String.valueOf(line.get(8)));
        //项目名称
        kentecom.setName(String.valueOf(line.get(9)));
        //招标单位
        kentecom.setCustomer(String.valueOf(line.get(10)));
        //数量
        kentecom.setNeedNum(String.valueOf(line.get(11)));
        //招标金额
        kentecom.setNeedPrice(line.get(12).toString());
        //投标结果
        kentecom.setAfterResult(String.valueOf(line.get(13)));
        //中标金额
        kentecom.setAfterPrice(String.valueOf(line.get(14)));
        //未中原因
        kentecom.setAfterReason(String.valueOf(line.get(15)));
        //中标单位
        kentecom.setAfterCompany(String.valueOf(line.get(16)));
        //金额
        kentecom.setPrice(String.valueOf(line.get(17)));
        //未中标原因分析
        kentecom.setCanNotReason(String.valueOf(line.get(18)));
        //部门
        kentecom.setDepartment(String.valueOf(line.get(19)));
        //销售区域
        kentecom.setSaleArea(String.valueOf(line.get(20)));
        //销售
        kentecom.setSaleMan(String.valueOf(line.get(21)));
        //task Id
        kentecom.setTaskId(taskId);
        return kentecom;
    }

    /**
     * 将对象数据 导出为 excel
     * @param sheetName 表名称
     * @param dir 路径
     * @param title 标题
     */
    @Override
    public void initExcel(String dir,String sheetName,String title) {
        ExcelWriter excelWriter = ExcelUtil.getWriter(dir,sheetName);
        //白色背景
        StyleSet whiteStyle = excelWriter.getStyleSet();
        //淡绿色背景
        StyleSet lightGreenStyle = excelWriter.getStyleSet();
        //绿色背景
        StyleSet greenStyle = excelWriter.getStyleSet();
        //合并1-18 列 同时 添加标题
        try {
            excelWriter.merge(0,0,0,20,title,true);
            //合并出月份
            excelWriter.merge(1,2,0,0,"月份",true);
            //合并出行业分类
            excelWriter.merge(1,1,1,2,"行业分类",true);
            //合并级别
            excelWriter.merge(1,1,3,5,"级别",true);
            //项目类别
            excelWriter.merge(1,1,6,9,"项目类别",true);
            //产品类别
            excelWriter.merge(1,1,10,12,"产品类别",true);
            //投标结果
            excelWriter.merge(1,1,13,16,"投标结果",true);
            //投标结果
            excelWriter.merge(1,2,17,17,"2020年投标数量",true);
            //中标结果
            excelWriter.merge(1,1,18,20,"中标率统计",true);

        //设置行高
            excelWriter.setRowHeight(0,28);
            excelWriter.setRowHeight(2,28);
            excelWriter.setRowHeight(15,25);
            //设置标题行内容
            excelWriter.writeCellValue(1,2,"水行业");
            excelWriter.writeCellValue(2,2,"工业");
            excelWriter.writeCellValue(3,2,"县级");
            excelWriter.writeCellValue(4,2,"地市级");
            excelWriter.writeCellValue(5,2,"省级及以上");
            excelWriter.writeCellValue(6,2,"项目标");
            excelWriter.writeCellValue(7,2,"年度标");
            excelWriter.writeCellValue(8,2,"入围标");
            excelWriter.writeCellValue(9,2,"框架标");
            excelWriter.writeCellValue(10,2,"水表");
            excelWriter.writeCellValue(11,2,"流量计");
            excelWriter.writeCellValue(12,2,"水表、流量计");
            excelWriter.writeCellValue(13,2,"中标");
            excelWriter.writeCellValue(14,2,"未中标");
            excelWriter.writeCellValue(15,2,"暂无结果");
            excelWriter.writeCellValue(16,2,"流标");
            excelWriter.writeCellValue(18,2,"水行业中标率");
            excelWriter.writeCellValue(19,2,"工业中标率");
            excelWriter.writeCellValue(20,2,"总中标率");
        } catch (Exception e) {
            throw new RuntimeException("存在excel sheet表");
        }finally {
            excelWriter.close();
        }
    }

    /**
     * 序列化
     * @param kentecomList 入参
     * @return  回复数组
     */
    @Override
    public List<List<Object>> getComData(List<Kentecom> kentecomList){
        List<List<Object>> allList = new ArrayList<>();
        //按照月份收集成map数组
        Map<String, List<Kentecom>> collectByMouth =kentecomList.stream().collect(Collectors.groupingBy(Kentecom::getMouth ,Collectors.toList()));
        for (int i = 0; i < 13; i++) {
            List<Object> list = new ArrayList<>();
            if (i <12) {
              final String mouth = i+1 +"月";
              List<Kentecom> mouthList = collectByMouth.get(mouth);
              Integer size = 0;
              //输入行号
              list.add(mouth);
              if (mouthList == null) {
                  List<Kentecom> tempList = new ArrayList<>();
                  Kentecom kentecom = new Kentecom();
                  kentecom.setIndustry("");
                  kentecom.setLv("");
                  kentecom.setType("");
                  kentecom.setProName("");
                  kentecom.setAfterResult("");
                  tempList.add(kentecom);
                  mouthList = tempList;
              }else {
                  size = mouthList.size();
              }
              list.add(mouthList.stream().filter(kentecom -> kentecom.getIndustry().contains("水行业")).count());
              list.add(mouthList.stream().filter(kentecom -> kentecom.getIndustry().contains("工业")).count());
              list.add(mouthList.stream().filter(kentecom -> kentecom.getLv().contains("县级")).count());
              list.add(mouthList.stream().filter(kentecom -> kentecom.getLv().contains("地市级")).count());
              list.add(mouthList.stream().filter(kentecom -> !kentecom.getLv().contains("地市级") && !kentecom.getLv().contains("县级")).count());
              list.add(mouthList.stream().filter(kentecom -> kentecom.getType().contains("项目标")).count());
              list.add(mouthList.stream().filter(kentecom -> kentecom.getType().contains("年度标")).count());
              list.add(mouthList.stream().filter(kentecom -> kentecom.getType().contains("入围标")).count());
              list.add(mouthList.stream().filter(kentecom -> kentecom.getType().contains("框架标")).count());
              list.add(mouthList.stream().filter(kentecom -> kentecom.getProName().contains("水表")).count());
              list.add(mouthList.stream().filter(kentecom -> kentecom.getProName().contains("流量计")).count());
              list.add(mouthList.stream().filter(kentecom -> !kentecom.getProName().contains("水表")&& !kentecom.getProName().contains("流量计")).count());
              list.add(mouthList.stream().filter(kentecom -> kentecom.getAfterResult().equals("中标")).count());
              list.add(mouthList.stream().filter(kentecom -> kentecom.getAfterResult().equals("未中标")).count());
              list.add(mouthList.stream().filter(kentecom -> kentecom.getAfterResult().contains("暂无结果")).count());
              list.add(mouthList.stream().filter(kentecom -> kentecom.getAfterResult().contains("流标")).count());
                //合计
                list.add(size);
                //水行业中标率
                int waterGo = 0;
                int waterAll = 0;
                int indGo = 0;
                int indAll =0;
                int allGo = 0;
                int all = 0;
                if (size == 0) {
                    list.add(0);
                    list.add(0);
                    list.add(0);
                }else {
                    for (Kentecom kentecom : mouthList) {
                        if (kentecom.getIndustry().contains("水行业")&&kentecom.getAfterResult().equals("中标")){
                            waterGo ++;
                        }
                        if (kentecom.getIndustry().contains("工业")&&kentecom.getAfterResult().equals("中标")){
                            indGo ++;
                        }
                        if (kentecom.getAfterResult().equals("中标")) {
                            allGo ++;
                        }
                        if (kentecom.getIndustry().contains("水行业")) {
                            waterAll ++;
                        }
                        if (kentecom.getIndustry().contains("工业")) {
                            indAll ++;
                        }
                        all ++;
                    }
                    if (waterAll == 0) {
                        list.add(0);
                    }else {
                        list.add(new BigDecimal(new BigDecimal(waterGo).divide(new BigDecimal(waterAll),4, RoundingMode.HALF_UP).toString()));
                    }
                    if (indAll == 0) {
                        list.add(0);
                    }else {
                        list.add(new BigDecimal(new BigDecimal(indGo).divide(new BigDecimal(indAll),4, RoundingMode.HALF_UP).toString()));
                    }
                    if (all == 0) {
                        list.add(0);
                    }else {
                        list.add(new BigDecimal(new BigDecimal(allGo).divide(new BigDecimal(all),4, RoundingMode.HALF_UP).toString()));

                    }
                }

            }else {
                list.add("合计");
                list.add(kentecomList.stream().filter(kentecom -> kentecom.getIndustry().contains("水行业")).count());
                list.add(kentecomList.stream().filter(kentecom -> kentecom.getIndustry().contains("工业")).count());

                list.add(kentecomList.stream().filter(kentecom -> kentecom.getLv().contains("县级")).count());
                list.add(kentecomList.stream().filter(kentecom -> kentecom.getLv().contains("地市级")).count());
                list.add(kentecomList.stream().filter(kentecom -> !kentecom.getLv().contains("地市级") && !kentecom.getLv().contains("县级")&& !"".equals(kentecom.getLv())).count());
                list.add(kentecomList.stream().filter(kentecom -> kentecom.getType().contains("项目标")).count());
                list.add(kentecomList.stream().filter(kentecom -> kentecom.getType().contains("年度标")).count());
                list.add(kentecomList.stream().filter(kentecom -> kentecom.getType().contains("入围标")).count());
                list.add(kentecomList.stream().filter(kentecom -> kentecom.getType().contains("框架标")).count());
                list.add(kentecomList.stream().filter(kentecom -> kentecom.getProName().contains("水表")).count());
                list.add(kentecomList.stream().filter(kentecom -> kentecom.getProName().contains("流量计")).count());
                list.add(kentecomList.stream().filter(kentecom -> !kentecom.getProName().contains("水表")&& !kentecom.getProName().contains("流量计")&&!"".equals(kentecom.getProName())).count());
                list.add(kentecomList.stream().filter(kentecom -> kentecom.getAfterResult().equals("中标")).count());
                list.add(kentecomList.stream().filter(kentecom -> kentecom.getAfterResult().equals("未中标")).count());
                list.add(kentecomList.stream().filter(kentecom -> kentecom.getAfterResult().contains("暂无结果")).count());
                list.add(kentecomList.stream().filter(kentecom -> kentecom.getAfterResult().contains("流标")).count());
                //合计
                list.add(kentecomList.size());
                //水行业中标率
                int size = kentecomList.size();
                int waterGo = 0;
                int waterAll = 0;
                int indGo = 0;
                int indAll =0;
                int allGo = 0;
                int all = 0;
                if (size == 0) {
                    list.add(0);
                    list.add(0);
                    list.add(0);
                }else {
                    for (Kentecom kentecom : kentecomList) {
                        if (kentecom.getIndustry().contains("水行业")&&kentecom.getAfterResult().equals("中标")){
                            waterGo ++;
                        }
                        if (kentecom.getIndustry().contains("工业")&&kentecom.getAfterResult().equals("中标")){
                            indGo ++;
                        }
                        if (kentecom.getAfterResult().equals("中标")) {
                            allGo ++;
                        }
                        if (kentecom.getIndustry().contains("水行业")) {
                            waterAll ++;
                        }
                        if (kentecom.getIndustry().contains("工业")) {
                            indAll ++;
                        }
                        all ++;
                    }
                    if (waterAll == 0) {
                        list.add(0);
                    }else {
                        list.add(new BigDecimal(new BigDecimal(waterGo).divide(new BigDecimal(waterAll),4, RoundingMode.HALF_UP).toString()));
                    }
                    if (indAll == 0) {
                        list.add(0);
                    }else {
                        list.add(new BigDecimal(new BigDecimal(indGo).divide(new BigDecimal(indAll),4, RoundingMode.HALF_UP).toString()));
                    }
                    if (all == 0) {
                        list.add(0);
                    }else {
                        list.add(new BigDecimal(new BigDecimal(allGo).divide(new BigDecimal(all),4, RoundingMode.HALF_UP).toString()));
                    }
                }

            }
            allList.add(list);
        }
       return allList;
    }

   private void deleteSheet(String dir,String sheetName) throws IOException {
        File file = new File(dir);
       Workbook book = WorkbookUtil.createBookForWriter(file);
       int i = book.getSheetIndex(sheetName);
       if (i >0){
           book.removeSheetAt(i);
       }
       ExcelUtil.getWriter(new File(dir)).write(book).close();
       book.close();
   }

    /**
     * 构造kente代理商表
     * @param line 行
     * @param taskId 任务id
     * @return kenteOther 对象
     */
   private Kenteother initKenteOther (List<Object> line, Integer taskId) {
        Kenteother kenteother = new Kenteother();
        kenteother.setMouth(line.get(0).toString());
        kenteother.setStartTime(line.get(1).toString());
        kenteother.setType(line.get(2).toString());
        kenteother.setLv(line.get(3).toString());
        kenteother.setObjType(line.get(4).toString());
        kenteother.setProType(line.get(5).toString());
        kenteother.setOtherName(line.get(6).toString());
        kenteother.setProjectId(line.get(7).toString());

       return kenteother;
   }

    /**
     * 同类构造kenteother
     * @param line
     * @param taskId
     * @return
     */
   private Kentecom initOtherCom(List<Object> line ,Integer taskId){
       Kentecom kentecom = new Kentecom();
       //结构化数据
       //月份
       kentecom.setMouth(String.valueOf(line.get(0)));
       //开标日期
       kentecom.setDate(String.valueOf(line.get(2)));
       //行业分类
       kentecom.setIndustry(String.valueOf(line.get(3)));
       //级别
       kentecom.setLv(String.valueOf(line.get(4)));
       //项目类别
       kentecom.setType(String.valueOf(line.get(5)));
       //产品名称
       kentecom.setProName(String.valueOf(line.get(6)));
       //数量
       kentecom.setNeedNum(String.valueOf(line.get(11)));
       //招标金额
       kentecom.setNeedPrice(line.get(12).toString());
       //投标结果
       kentecom.setAfterResult(String.valueOf(line.get(13)));
       //task Id
       kentecom.setTaskId(taskId);

       return kentecom;
   }


}
