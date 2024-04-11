package com.example.springboot.entity;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;

import com.example.springboot.DTO.PlDTO;

import com.example.springboot.Request.PlPageRequest;
import com.example.springboot.Request.PlRequest;

import com.example.springboot.Service.IPlService;
import com.example.springboot.Service.PlService;
import com.example.springboot.Service.utils.TokenUtils;
import com.example.springboot.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
//当在使用Spring框架创建Web应用程序时，@ CrossOrigin注释可以帮助您处理跨域请求。如果您的前端和后端代码位于不同的服务器上，则需要通过添加此注释来允许跨域请求。
//        它是一个用于授权远程客户端访问资源的方便注释，并支持跨域请求。 要使用此注释，请将其声明在Spring REST控制器的顶部（如@RestController）。
@RequestMapping("/Pl1")
@Service
public class PlController {
    @Autowired
    IPlService plService;


    private static final String BASE_FILE_PATH = System.getProperty("user.dir") + "/files/";

    @GetMapping("/list")
    public Result list() {
        List<Pl> pl  = plService.list();
        return Result.success(pl);
    }
    @GetMapping("/list1")
    public Result list1() {
        List<Pl> pl1  = plService.list1();
        return Result.success(pl1);
    }
    @PostMapping("/login")
    public Result login(@RequestBody PlRequest plRequest) {

        PlDTO pl = plService.pl(plRequest);
        if (pl == null) {
            return Result.error("订单号错误");

        }
        return Result.success(pl);
    }
    @PutMapping("/add")
//    @RequestBody接受前端传递给后端的字符串
    public Result add(@RequestBody Pl obj) {

        plService.add(obj);
        return Result.success();
    }
    @GetMapping("/page")
    public Result page(PlPageRequest plPageRequest) {
        return Result.success(plService.page(plPageRequest));
    }
    @GetMapping("/page1")
    public Result page1(PlPageRequest plPageRequest) {
        return Result.success(plService.page(plPageRequest));
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        plService.deleteById(id);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Pl obj = plService.getById(id);
        return Result.success(obj);
    }
    @PostMapping("/file/upload")
    public Result uploadFile(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        if (StrUtil.isBlank(originalFilename)) {
            return Result.error("文件上传失败");
        }
        long flag = System.currentTimeMillis();
        String filePath = BASE_FILE_PATH + flag + "_" + originalFilename;
        try {
            FileUtil.mkParentDirs(filePath);  // 创建父级目录
            file.transferTo(FileUtil.file(filePath));
//            Admin currentAdmin = TokenUtils.getCurrentAdmin();
//            String token = TokenUtils.genToken(currentAdmin.getId().toString(), currentAdmin.getPassword(), 15);
            String url = "http://localhost:9292/Pl1/file/download/" + flag  ;
            if (originalFilename.endsWith("png") || originalFilename.endsWith("jpg") || originalFilename.endsWith("pdf")) {
//                url += "&play=1";
            }
            return Result.success(url);
        } catch (Exception e) {
            log.info("文件上传失败", e);
        }
        return Result.error("文件上传失败");
    }
    @GetMapping("/file/download/{flag}")
    public void download(@PathVariable String flag, @RequestParam(required = false) String play, HttpServletResponse response) {
        OutputStream os;
        List<String> fileNames = FileUtil.listFileNames(BASE_FILE_PATH);
        String fileName = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse(""); //  System.currentTimeMillis() + originalFilename
        try {
            if (StrUtil.isNotEmpty(fileName)) {
                String realName = fileName.substring(fileName.indexOf("_") + 1);
                if ("1".equals(play)) {
                    response.addHeader("Content-Disposition", "inline;filename=" + URLEncoder.encode(realName, "UTF-8"));
                } else {
                    response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(realName, "UTF-8"));
                }
                byte[] bytes = FileUtil.readBytes(BASE_FILE_PATH + fileName);
                os = response.getOutputStream();
                os.write(bytes);
                os.flush();
                os.close();
            }
        } catch (Exception e) {
            log.error("文件下载失败", e);
        }
    }
}
