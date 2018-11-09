package com.nsk.cloud.microservicefileupload.file;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author nsk
 * 2018/8/9 8:16
 */
@Controller
public class FileUploadController {

    @PostMapping(value = "/upload")
    public @ResponseBody
    String handleFileUpload(@RequestParam MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        String filePath = file.getOriginalFilename() == null ? "C://" : file.getOriginalFilename();
        File fileToSave = new File(filePath);
        FileCopyUtils.copy(bytes, fileToSave);
        return fileToSave.getAbsolutePath();
    }
}
