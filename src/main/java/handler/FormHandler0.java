package handler;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by geyao on 2017/3/8.
 */
@Controller
@RequestMapping(value = {"/SpringMVC", "/springmvc", "/SPRINGMVC", "/Springmvc"})
public class FormHandler0 {

    private static final String urlAddress = "/SpringMVC";

    @ModelAttribute("fileList")
    public ArrayList<File> getFiles(Model model){
        System.out.println("fileList");
        String diPath = System.getenv("HOME") + "/files/";
        File dir = new File(diPath);
        File[] files = dir.listFiles();
        ArrayList<File> fileList = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory())
                    ;
                else {
                    if (file.getName().toLowerCase().endsWith(".ds_store")
                            || file.getName().startsWith("."))
                        continue;
                    fileList.add(file);
                }
            }
        }
        System.out.println("fileList里面的Model是 = " + model);
        return fileList;
    }



    @ModelAttribute("fileNameList")
    public ArrayList<String> getFilesName(Model model) throws Exception{
        System.out.println("fileNameList");
        ArrayList<File> fileList = (ArrayList<File>) model.asMap().get("fileList");
        ArrayList<String> fileNameList = new ArrayList<>();
        for (File tempFile : fileList){
            String longPath = tempFile.getName();
            String parentName = tempFile.getParent();
            String Canonicalpath = tempFile.getCanonicalPath();
            fileNameList.add(longPath);
        }
        System.out.println("fileNameList里面的Model是 = " + model);
        return fileNameList;
    }



    //分发
    @RequestMapping(value = "/{formName}")
    public String logInForm(@PathVariable String formName, HttpServletRequest request) throws Exception{
        String url = request.getLocalAddr();
        System.out.println(url);
        return formName;
    }


    //上传
    @RequestMapping(value = "/fileUpLoad")
    public String uploadTest(
            @RequestParam(name = "description", defaultValue = "description") String description,
            @RequestParam(name = "file")MultipartFile file,
            HttpServletRequest request
//            Model model
            )throws Exception{
        System.out.println(request.toString());
        System.out.println(description);
        if (!file.isEmpty()){
            //上传文件路径
            String path = System.getenv("HOME") + "/files/";
            String contextPath = request.getServletContext().getContextPath();
            String fileName = file.getOriginalFilename();
            File filePath = new File(path, fileName);
            if (!filePath.getParentFile().exists()){
                filePath.getParentFile().mkdirs();
            }
            File targetFile = new File(path + File.separator + fileName);
            file.transferTo(targetFile);
        }
        return "redirect:" + urlAddress + "/logInForm3";
    }

    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(
            @RequestParam("fileName") String fileName,
            HttpServletRequest request,
            Model model,
            HttpServletResponse response
    ) throws Exception{
        ArrayList<String> fileNameList = (ArrayList<String>) model.asMap().get("fileNameList");
        System.out.println();
        HttpHeaders headers= new HttpHeaders();

        if (!fileNameList.contains(fileName)){
            request.getRequestDispatcher(urlAddress + "/logInForm3").forward(request, response);
        }

        request.setCharacterEncoding("UTF-8");
        String path = System.getenv("HOME") + "/files/";
        File file = new File(path + File.separator + fileName);
        String downloadFileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");

        headers.setContentDispositionFormData("attachment", downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>
                (FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
}
