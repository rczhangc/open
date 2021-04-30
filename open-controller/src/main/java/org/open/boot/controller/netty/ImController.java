package org.open.boot.controller.netty;

import lombok.extern.slf4j.Slf4j;
import org.open.boot.controller.netty.vo.ResultModel;
import org.open.boot.service.netty.socket.WebSocketServerHandler;
import org.open.boot.service.netty.socket.WebSocketUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.socket.BinaryMessage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * @author barnak
 */
@RestController
@RequestMapping("im")
@Slf4j
public class ImController {

    @RequestMapping(value = "/fileUpload")
    public ResultModel fileUpload(@RequestParam("userName") String userName, @RequestParam MultipartFile[] myfiles,
                                  HttpServletRequest request) {
        log.info("收到发往用户[{}]的文件上传请求;文件数量:{}", userName, myfiles.length);

        int count = 0;
        for (MultipartFile myfile : myfiles) {
            if (myfile.isEmpty()) {
                count++;
            }
            log.info("文件原名:{};文件类型:", myfile.getOriginalFilename(), myfile.getContentType());
            try (ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
                 InputStream is = myfile.getInputStream();) {
                byte[] buff = new byte[100]; // buff用于存放循环读取的临时数据
                int rc = 0;
                while ((rc = is.read(buff, 0, 100)) > 0) {
                    swapStream.write(buff, 0, rc);
                }
                byte[] in_b = swapStream.toByteArray(); // in_b为转换之后的结果
                log.info("正在发送文件: ");
                WebSocketServerHandler.sendMessageToUser(userName, new BinaryMessage(in_b));
            } catch (IOException e) {
                log.error("文件原名:{}", myfile.getOriginalFilename(), e);
                e.printStackTrace();
                count++;
                continue;
            }
        }
        return ResultModel.ok(count);
    }

    @RequestMapping(value = "/setUser")
    public ResultModel setUser(@RequestParam("userName") String userName, HttpServletRequest request) {
        log.info("设置用户[{}]", userName);

        request.getSession().setAttribute("userName", userName);
        return ResultModel.ok();
    }

    @RequestMapping(value = "/user")
    public ResultModel user(HttpServletRequest request) {
        Object userName = request.getSession().getAttribute("userName");
        if(userName == null)return ResultModel.error("无用户");
        return ResultModel.ok(userName);
    }

    @RequestMapping(value = "/userList")
    public ResultModel userList() {
        return ResultModel.ok(WebSocketUser.getUserList());
    }
}
