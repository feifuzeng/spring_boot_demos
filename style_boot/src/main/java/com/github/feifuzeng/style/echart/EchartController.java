package com.github.feifuzeng.style.echart;


import com.github.feifuzeng.style.echart.model.EchartData;
import com.github.feifuzeng.style.echart.model.EchartReq;
import com.github.feifuzeng.style.echart.model.Series;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/** * @author  feifz:
 * @date ：2017年7月5日 上午11:13:42
 * @return
 * @desc
 */
@Controller
@RequestMapping("echart")
public class EchartController {

    @RequestMapping("/echart")
    public String toPage(){
        return "echart";
    }

    /**
     *
     * @return
     */
    @RequestMapping("getEchartData")
    @ResponseBody
    public EchartData getEchartData(EchartReq echartReq){
        List<String> legendList=new ArrayList<String>();

        List<String> categoryList=new ArrayList<String>();
        categoryList.add("20170301-20170308");
        categoryList.add("20170309-20170316");
        categoryList.add("20170317-20170324");
        categoryList.add("20170325-20170401");
        categoryList.add("20170402-20170409");
        categoryList.add("20170410-20170417");
        categoryList.add("20170418-20170425");
        List<Series> seriesList =new ArrayList<>();
        List<Integer> data1 = new ArrayList<>();
        data1.add(111);
        data1.add(272);
        data1.add(313);
        data1.add(474);
        data1.add(515);
        data1.add(474);
        data1.add(515);
        seriesList.add(new Series("消费金额(元)", "line",data1));
        List<Integer> data2 = new ArrayList<>();
        data2.add(111);
        data2.add(222);
        data2.add(333);
        data2.add(444);
        data2.add(555);
        data2.add(444);
        data2.add(555);
        seriesList.add(new Series("周环比(100%)", "line",data2));
        EchartData echartData = new EchartData(legendList, categoryList, seriesList);
        return echartData;
    }
}
