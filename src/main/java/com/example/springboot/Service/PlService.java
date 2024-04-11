package com.example.springboot.Service;

import cn.hutool.core.collection.CollUtil;
import com.example.springboot.DTO.PlDTO;
import com.example.springboot.Request.BaseRequest;
import com.example.springboot.Request.PlRequest;
import com.example.springboot.entity.Pl;
import com.example.springboot.exception.ServiceException;
import com.example.springboot.mapper.PlMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PlService implements IPlService {
    @Autowired
    PlMapper plMapper;
    @Override
    public PlDTO pl(PlRequest plRequest){


        try {
            Pl pl = plMapper.getByOrder(plRequest);
            PlDTO plDTO=new PlDTO();
            BeanUtils.copyProperties(pl,plDTO);
            return  plDTO;
        } catch (Exception e) {
            log.error("登录出现异常",e);
            return null;
        }

    }

    public void add(Pl obj) {
        try {
            obj.setCategory(category(obj.getCategories()));
            plMapper.add(obj);
        } catch (Exception e) {
            throw new ServiceException("数据插入错误", e);
        }
    }
    @Override
    public PageInfo<Pl> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Pl> Pls = plMapper.listByCondition(baseRequest);
        return new PageInfo<>(Pls);
    }
    @Override
    public PageInfo<Pl> page1(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Pl> Pls = plMapper.listByCondition1(baseRequest);
        return new PageInfo<>(Pls);
    }
    @Override
    public void deleteById(Integer id) {
        plMapper.deleteById(id);
    }

    @Override
    public Pl getById(Integer id) {
        return plMapper.getById(id);
    }
    public List<Pl> list(){ return plMapper.list(); }

    public List<Pl> list1(){ return plMapper.list1(); }
    private String category(List<String> categories) {
        StringBuilder sb = new StringBuilder();
        if (CollUtil.isNotEmpty(categories)) {
            categories.forEach(v -> sb.append(v).append(" > "));
            return sb.substring(0, sb.lastIndexOf(" > "));
        }
        return sb.toString();
    }
}
