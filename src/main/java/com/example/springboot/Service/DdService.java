package com.example.springboot.Service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.example.springboot.Request.BaseRequest;
import com.example.springboot.entity.Dd;
import com.example.springboot.entity.Fj;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.DdMapper;
import com.example.springboot.mapper.FjMapper;
import com.example.springboot.mapper.po.ddCountpo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public  class DdService implements IDdService{
    @Autowired
    DdMapper ddMapper;
    @Autowired
    FjMapper fjMapper;
    @Override
    //    @Override 是 Java 中的注解，它用于告诉编译器，被标记的方法是一个覆盖（或重写）父类或接口中的方法。使用 @Override 注解可以帮助开发者避免一些常见的错误，同时提高代码的可读性。
//
//    具体作用包括：
//
//    错误检查： 当你使用 @Override 注解时，编译器会检查该方法是否确实覆盖了超类中的方法（或接口中的方法）。如果没有正确覆盖，编译器会发出警告，帮助你及早发现问题。
    public void add(Dd obj){
        //  校验房间是否存在
        Fj fj = fjMapper.getByNo(obj.getRoom());
        if (Objects.isNull(fj)) {
            throw new ServiceException("房间不存在");
        }
//        校验房间状态
//        if (fj.getState().equals(false) ) {
//            throw new ServiceException("房间被占用");
//        }
        ddMapper.add(obj);}
    public List<Dd> list(){return ddMapper.list();}
@Override
//    @Override 是 Java 中的注解，它用于告诉编译器，被标记的方法是一个覆盖（或重写）父类或接口中的方法。使用 @Override 注解可以帮助开发者避免一些常见的错误，同时提高代码的可读性。
//
//    具体作用包括：
//
//    错误检查： 当你使用 @Override 注解时，编译器会检查该方法是否确实覆盖了超类中的方法（或接口中的方法）。如果没有正确覆盖，编译器会发出警告，帮助你及早发现问题。
public PageInfo<Dd> page(BaseRequest baseRequest) {
    PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
    List<Dd> dds = ddMapper.listByCondition(baseRequest);
    return new PageInfo<>(dds);
}
    @Override
    //    @Override 是 Java 中的注解，它用于告诉编译器，被标记的方法是一个覆盖（或重写）父类或接口中的方法。使用 @Override 注解可以帮助开发者避免一些常见的错误，同时提高代码的可读性。
//
//    具体作用包括：
//
//    错误检查： 当你使用 @Override 注解时，编译器会检查该方法是否确实覆盖了超类中的方法（或接口中的方法）。如果没有正确覆盖，编译器会发出警告，帮助你及早发现问题。
    public PageInfo<Dd> page1(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Dd> dds = ddMapper.listByCondition1(baseRequest);
        return new PageInfo<>(dds);
    }
    @Override
    //    @Override 是 Java 中的注解，它用于告诉编译器，被标记的方法是一个覆盖（或重写）父类或接口中的方法。使用 @Override 注解可以帮助开发者避免一些常见的错误，同时提高代码的可读性。
//
//    具体作用包括：
//
//    错误检查： 当你使用 @Override 注解时，编译器会检查该方法是否确实覆盖了超类中的方法（或接口中的方法）。如果没有正确覆盖，编译器会发出警告，帮助你及早发现问题。
    public void update(Dd user) {
        Fj fj = fjMapper.getByNo(user.getRoom());
        if (fj.getState().equals(true) ) {
            throw new ServiceException("房间已经退房");
        }
//        user.setUpdatetime(new Date());
        ddMapper.updateById(user);

    }
    @Override
    //    @Override 是 Java 中的注解，它用于告诉编译器，被标记的方法是一个覆盖（或重写）父类或接口中的方法。使用 @Override 注解可以帮助开发者避免一些常见的错误，同时提高代码的可读性。
//
//    具体作用包括：
//
//    错误检查： 当你使用 @Override 注解时，编译器会检查该方法是否确实覆盖了超类中的方法（或接口中的方法）。如果没有正确覆盖，编译器会发出警告，帮助你及早发现问题。
    public Dd getById(Integer id) {
        return ddMapper.getById(id);
    }
    @Override
    //    @Override 是 Java 中的注解，它用于告诉编译器，被标记的方法是一个覆盖（或重写）父类或接口中的方法。使用 @Override 注解可以帮助开发者避免一些常见的错误，同时提高代码的可读性。
//
//    具体作用包括：
//
//    错误检查： 当你使用 @Override 注解时，编译器会检查该方法是否确实覆盖了超类中的方法（或接口中的方法）。如果没有正确覆盖，编译器会发出警告，帮助你及早发现问题。
    public void deleteById(Integer id) {
        ddMapper.deleteById(id);
    }

    @Override
    //    @Override 是 Java 中的注解，它用于告诉编译器，被标记的方法是一个覆盖（或重写）父类或接口中的方法。使用 @Override 注解可以帮助开发者避免一些常见的错误，同时提高代码的可读性。
//
//    具体作用包括：
//
//    错误检查： 当你使用 @Override 注解时，编译器会检查该方法是否确实覆盖了超类中的方法（或接口中的方法）。如果没有正确覆盖，编译器会发出警告，帮助你及早发现问题。
    public Map<String, Object> getCountByTimeRange(String timeRange) {
        Map<String, Object> map = new HashMap<>();
        Date today = new Date();
        List<DateTime> dateRange;
        switch (timeRange) {
            case "week":
                dateRange = DateUtil.rangeToList(DateUtil.offsetDay(today, -6), today, DateField.DAY_OF_WEEK);
                break;
            case "month":
                dateRange = DateUtil.rangeToList(DateUtil.offsetDay(today, -29), today, DateField.DAY_OF_MONTH);
                break;
            case "month2":
                dateRange = DateUtil.rangeToList(DateUtil.offsetDay(today, -59), today, DateField.DAY_OF_MONTH);
                break;
            case "month3":
                dateRange = DateUtil.rangeToList(DateUtil.offsetDay(today, -89), today, DateField.DAY_OF_MONTH);
                break;
            default:
                dateRange = new ArrayList<>();
        }
        List<String> dateStrRange = datetimeToDateStr(dateRange);
        map.put("date", dateStrRange);
        List<ddCountpo> beginCount = ddMapper.getCountByTimeRange(timeRange, 1);
        List<ddCountpo> endCount = ddMapper.getCountByTimeRange(timeRange, 2);
        map.put("dd", countList(beginCount, dateStrRange));
        map.put("df", countList(endCount, dateStrRange));
        return map;
    }

    @Override
    public void updateState(Integer id, String state) {
        ddMapper.updateState(id, state);
    }

    private List<String> datetimeToDateStr(List<DateTime> dateTimeList) {
        List<String> list = CollUtil.newArrayList();
        if (CollUtil.isEmpty(dateTimeList)) {
            return list;
        }
        for (DateTime dateTime : dateTimeList) {
            String date = DateUtil.formatDate(dateTime);
            list.add(date);
        }
        return list;
    }

    private List<Integer> countList(List<ddCountpo> countPOList, List<String> dateRange) {
        List<Integer> list = CollUtil.newArrayList();
        if (CollUtil.isEmpty(countPOList)) {
            return list;
        }
        for (String date : dateRange) {
            Integer count = countPOList.stream().filter(countPO -> date.equals(countPO.getDate()))
                    .map(ddCountpo::getCount).findFirst().orElse(0);
            list.add(count);
        }
        return list;
    }
    @Override
    //    @Override 是 Java 中的注解，它用于告诉编译器，被标记的方法是一个覆盖（或重写）父类或接口中的方法。使用 @Override 注解可以帮助开发者避免一些常见的错误，同时提高代码的可读性。
//
//    具体作用包括：
//
//    错误检查： 当你使用 @Override 注解时，编译器会检查该方法是否确实覆盖了超类中的方法（或接口中的方法）。如果没有正确覆盖，编译器会发出警告，帮助你及早发现问题。
    public void add0(Dd dd) {

        ddMapper.add0(dd);
    }
}
