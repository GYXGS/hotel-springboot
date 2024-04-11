package com.example.springboot.Service;

import com.example.springboot.Request.BaseRequest;
import com.example.springboot.entity.Dd;
import com.example.springboot.entity.Df;
import com.example.springboot.entity.Fj;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.DfMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DfService implements IDfService{
    @Autowired
    DfMapper dfMapper;
    @Override

    public void add0(Df df){dfMapper.add0(df);}
    @Override

    public void add(Df df){dfMapper.add(df);}
    @Override

    public void add1(Df df){dfMapper.add1(df);}
    @Override

    public void add2(Df df){dfMapper.add2(df);}
    public List<Df> list(){return dfMapper.list();}
@Override
public PageInfo<Df> page(BaseRequest baseRequest) {
    PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
    List<Df> dfs = dfMapper.listByCondition(baseRequest);
    return new PageInfo<>(dfs);
}
    @Override
    public void update(Df user) {
//        user.setUpdatetime(new Date());
        dfMapper.updateById(user);
    }
    @Override
    public void update1(Df df) {
//        user.setUpdatetime(new Date());
        dfMapper.updateById0(df);
    }
    @Override
    //    @Override 是 Java 中的注解，它用于告诉编译器，被标记的方法是一个覆盖（或重写）父类或接口中的方法。使用 @Override 注解可以帮助开发者避免一些常见的错误，同时提高代码的可读性。
//    具体作用包括：
//    错误检查： 当你使用 @Override 注解时，编译器会检查该方法是否确实覆盖了超类中的方法（或接口中的方法）。如果没有正确覆盖，编译器会发出警告，帮助你及早发现问题。
    public Df getById(Integer id) {
        return dfMapper.getById(id);
    }
    @Override
    //    @Override 是 Java 中的注解，它用于告诉编译器，被标记的方法是一个覆盖（或重写）父类或接口中的方法。使用 @Override 注解可以帮助开发者避免一些常见的错误，同时提高代码的可读性。
//    具体作用包括：
//    错误检查： 当你使用 @Override 注解时，编译器会检查该方法是否确实覆盖了超类中的方法（或接口中的方法）。如果没有正确覆盖，编译器会发出警告，帮助你及早发现问题。
    public void deleteById(Integer id) {
        dfMapper.deleteById(id);
    }

    @Override
    public void updateStatus(Df obj) {

        dfMapper.updateById1(obj);
    }
}
