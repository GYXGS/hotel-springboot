package com.example.springboot.Service;

import com.example.springboot.Request.BaseRequest;
import com.example.springboot.Request.FjPageRequest;
import com.example.springboot.entity.Fj;
import com.example.springboot.entity.Fj;
import com.example.springboot.mapper.FjMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Service" 注解可以将一个类标记为服务类，以便在应用程序中进行依赖注入和管理。这样的类通常包含业务逻辑、数据访问或其他服务相关的功能。
//        通过使用 "@Service" 注解，可以将服务类与其他组件（如控制器、存储库等）进行解耦，并使其更易于测试和维护。它还可以帮助实现面向接口的编程，提供更好的可扩展性和灵活性。
//        在使用 "@Service" 注解时，通常需要结合其他注解（如 "@Autowired"）来实现依赖注入，以便在需要的地方使用服务类的实例。
//        总而言之，"@Service" 注解在Java中的作用是标识一个类作为服务组件，并提供依赖注入和管理的功能，以实现业务逻辑的组织和解耦。
public class FjService implements IFjService{
    @Autowired
    FjMapper fjMapper;

   @Override
    public void add(Fj fj){fjMapper.add(fj);}
    public List<Fj> list(){return fjMapper.list();}
    @Override
    public PageInfo<Fj> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Fj> fjs = fjMapper.listByCondition(baseRequest);
        return new PageInfo<>(fjs);
    }
    @Override
    public PageInfo<Fj> page1(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Fj> fjs = fjMapper.listByCondition1(baseRequest);
        return new PageInfo<>(fjs);
    }
    @Override
    public PageInfo<Fj> page2(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        List<Fj> fjs = fjMapper.listByCondition2(baseRequest);
        return new PageInfo<>(fjs);
    }
    @Override
    public void update(Fj user) {
//        user.setUpdatetime(new Date());
        fjMapper.updateById(user);
    }
    @Override
    public void updateState(Fj user) {
//        user.setUpdatetime(new Date());
        fjMapper.updateByState(user);
    }  @Override
    public void updateState1(Fj user) {
//        user.setUpdatetime(new Date());
        fjMapper.updateByState1(user);
    }

    @Override
    public Fj getById(Integer id) {
        return fjMapper.getById(id);
    }
    @Override
    public void deleteById(Integer id) {
        fjMapper.deleteById(id);
    }


}

