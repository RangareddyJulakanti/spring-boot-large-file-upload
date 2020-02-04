package com.ranga.spring.web.fileio;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    Response<String> upload(HttpServletRequest request) throws IOException {

        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            // Inform user about invalid request
            Response<String> responseObject = new Response<String>(false, "Not a multipart request.", "");
            return responseObject;
        }
        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload();

        // Parse the request
        MultipartFile multipartFile = ((StandardMultipartHttpServletRequest) request).getMultiFileMap().getFirst("filevideo");
        File file=new File(this.getClass().getResource("/").getFile().concat(Long.toString(System.nanoTime())).concat(".pdf"));
        file.createNewFile();
        multipartFile.transferTo(file);

        return new Response<String>(true, "Success", "");
    }
}