package com.example.springboot.entity;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.example.springboot.Request.FjPageRequest;
import com.example.springboot.Service.FjService;
import com.example.springboot.Service.IFjService;
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
@RequestMapping("/Fj")
@Service
public class FjController {
    @Autowired
    IFjService fjService;
    private static final String BASE_FILE_PATH = System.getProperty("user.dir") + "/files/";
    @PutMapping("/add")
    public Result add(@RequestBody Fj fj) {
        fjService.add(fj);
    return Result.success();
    }
    @GetMapping("/list")
    public Result list(){
        List<Fj> room = fjService.list();
        return  Result.success(room);
    }
    @GetMapping("/page")
    public Result page(FjPageRequest fjPageRequest) {
        return Result.success(fjService.page(fjPageRequest));
    }
    @GetMapping("/page1")
    public Result page1(FjPageRequest fjPageRequest) {
        return Result.success(fjService.page1(fjPageRequest));
    }
    @GetMapping("/page2")
    public Result page2(FjPageRequest fjPageRequest) {
        return Result.success(fjService.page2(fjPageRequest));
    }
    @PutMapping("/update")
    public Result update(@RequestBody Fj obj) {
        fjService.update(obj);
        return Result.success();
    }
    @PutMapping("/updateState")
    public Result updateState(@RequestBody Fj obj) {
        fjService.updateState(obj);
        return Result.success();
    }
    @PutMapping("/updateState1")
    public Result updateState1(@RequestBody Fj obj) {
        fjService.updateState1(obj);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Fj obj = fjService.getById(id);
        return Result.success(obj);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        fjService.deleteById(id);
        return Result.success();
    }
    //    @PutMapping("/add")
//    public Result add(@RequestBody ClaIn claIn){
//        claInService.add(claIn);
//        return  Result.success();
//    }
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
            Admin currentAdmin = TokenUtils.getCurrentAdmin();
            String token = TokenUtils.genToken(currentAdmin.getId().toString(), currentAdmin.getPassword(), 15);
            String url = "http://localhost:9292/Fj/file/download/" + flag + "?&token=" + token;
            if (originalFilename.endsWith("png") || originalFilename.endsWith("jpg") || originalFilename.endsWith("pdf")) {
                url += "&play=1";
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
