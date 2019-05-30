package com.example.demo.controller;

import com.example.demo.service.BookService;
import com.example.demo.utils.FileUploadUtils;
import com.example.demo.utils.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("book")
@Api(value = "图书接口", description = "图书接口")
public class BookController {

    @Resource
    private BookService bookService;

    @RequestMapping(value = "publish", method = RequestMethod.POST)
    @ApiOperation(value = "图书发布接口", notes = "图书发布接口")
    public ResultMap publish(@RequestParam("file") MultipartFile file, HttpServletRequest request, String title, String description, float price, String phone,Integer userId)throws IOException {
        if (bookService.publish(title, description, price, phone, FileUploadUtils.upLoadPicture(file, "upload/book",request),userId) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "searchAll", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有图书", notes = "获取所有图书")
    public ResultMap searchAll() {
        if (bookService.searchAll() != null) {
            return ResultMap.ok(bookService.searchAll());
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "getBookByPage", method = RequestMethod.POST)
    @ApiOperation(value = "分页获取所有图书", notes = "分页获取所有图书")
    public ResultMap getBookByPage(Integer offset, Integer pagesize) {
        if (bookService.getBookByPage(offset, pagesize) != null) {
            return ResultMap.ok(bookService.getBookByPage(offset, pagesize));
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "getBookInfoById", method = RequestMethod.POST)
    @ApiOperation(value = "通过Id获取所有图书", notes = "通过Id获取所有图书")
    public ResultMap getBookInfoById(Integer userId) {
        if (bookService.getBookInfoById(userId) != null) {
            return ResultMap.ok(bookService.getBookInfoById(userId));
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "getInfoCount", method = RequestMethod.POST)
    @ApiOperation(value = "获取所有图书的数量", notes = "获取所有图书的数量")
    public ResultMap getInfoCount() {
        if (bookService.getBookCount() >= 0) {
            return ResultMap.ok(bookService.getBookCount());
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "deleteBookById", method = RequestMethod.POST)
    @ApiOperation(value = "通过Id删除图书", notes = "通过Id删除图书")
    public ResultMap deleteBookById(Integer id) {
        if (bookService.deleteBookById(id) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "updateBook", method = RequestMethod.POST)
    @ApiOperation(value = "用户通过Id更新图书信息", notes = "通过Id更新图书信息")
    public ResultMap updateBook(@RequestParam("file") MultipartFile file, HttpServletRequest request,String title, String description, float price, String phone, Integer bookId)throws IOException {
        if (bookService.updateBook(title, description,price,phone, FileUploadUtils.upLoadPicture(file, "upload/book", request), bookId) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

    @RequestMapping(value = "updateBookAdmin", method = RequestMethod.POST)
    @ApiOperation(value = "管理员通过Id更新图书信息", notes = "管理员通过Id更新图书信息")
    public ResultMap updateBookAdmin(String title, String description, float price, String phone,Integer bookId)throws IOException {
        if (bookService.updateBookAdmin(title, description,price,phone, bookId) == 1) {
            return ResultMap.ok(null);
        }
        return ResultMap.fail(null);
    }

    @ApiOperation(value = "修改图书头像", notes = "修改图书头像")
    @RequestMapping(value = "/updateBookUrl", method = RequestMethod.POST)
    public ResultMap updateBookUrl(@RequestParam("file") MultipartFile file, Integer bookId,
                               HttpServletRequest request) throws IOException {
        String url = FileUploadUtils.upLoadPicture(file, "upload/book", request);
        if (bookService.updateBookUrl(url, bookId) == 1) {
            return ResultMap.ok(url);
        }
        return ResultMap.fail(null);
    }

}
