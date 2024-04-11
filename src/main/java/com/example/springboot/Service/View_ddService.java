package com.example.springboot.Service;

import com.example.springboot.Request.BaseRequest;
import com.example.springboot.entity.Dd;
import com.example.springboot.entity.View_dd;
import com.example.springboot.mapper.FjMapper;
import com.example.springboot.mapper.View_ddMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class View_ddService implements IView_ddService{
    @Autowired
    View_ddMapper view_ddMapper;
    @Autowired
    FjMapper fjMapper;
//    @Override
//    public void add(Dd obj){
//        //  校验房间是否存在
//        Fj fj = fjMapper.getByNo(obj.getRoom());
//        if (Objects.isNull(fj)) {
//            throw new ServiceException("房间不存在");
//        }
////        校验房间状态
//        if (fj.getState().equals(false) ) {
//            throw new ServiceException("房间被占用");
//        }
//        ddMapper.add(obj);}
    public List<View_dd> list(){return view_ddMapper.list();}
//@Override
//public PageInfo<Dd> page(BaseRequest baseRequest) {
//    PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
//    List<Dd> dds = ddMapper.listByCondition(baseRequest);
//    return new PageInfo<>(dds);
//}
    @Override
    public PageInfo<View_dd> page1(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<View_dd> dds = view_ddMapper.listByCondition1(baseRequest);
        return new PageInfo<>(dds);
    }
//    @Override
//    public PageInfo<Dd> page1(BaseRequest baseRequest) {
//        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
//        List<Dd> dds = ddMapper.listByCondition1(baseRequest);
//        return new PageInfo<>(dds);
//    }
//    @Override
//    public void update(Dd obj) {
//        Fj fj = fjMapper.getByNo(obj.getRoom());
//        if (fj.getState().equals(true) ) {
//            throw new ServiceException("房间已经退房");
//        }
////        user.setUpdatetime(new Date());
//        ddMapper.updateById(obj);
//    }
//    @Override
//    public Dd getById(Integer id) {
//        return ddMapper.getById(id);
//    }
//    @Override
//    public void deleteById(Integer id) {
//        ddMapper.deleteById(id);
//    }
}
