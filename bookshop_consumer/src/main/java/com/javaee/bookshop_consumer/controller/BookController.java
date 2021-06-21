package com.javaee.bookshop_consumer.controller;

import com.javaee.bookshop_consumer.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/read")
    public Result getBook(@RequestParam(value = "bookId") Integer bookId, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum) {
        MultiValueMap<String, Object> dataMap = new LinkedMultiValueMap<String, Object>();
        dataMap.add("bookId", bookId);
        dataMap.add("pageNum", pageNum);

        Result requestResult = restTemplate.postForObject("http://book-provider/book/read", dataMap, Result.class);
        return requestResult;
    }

    @PostMapping(value = "/addbook")
    public Result addBook(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "bookName") String bookName, @RequestParam(value = "bookDesc") String bookDesc) throws Exception {
        MultiValueMap<String, Object> dataMap = new LinkedMultiValueMap<String, Object>();
        dataMap.add("file", file);
        dataMap.add("bookName", bookName);
        dataMap.add("bookDesc", bookDesc);
        Result requestResult = restTemplate.postForObject("http://book-provider/book/addbook", dataMap, Result.class);
        return requestResult;
    }

    @PostMapping("/booklist")
    public Result getBookList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        MultiValueMap<String, Object> dataMap = new LinkedMultiValueMap<String, Object>();
        dataMap.add("pageNum", pageNum);
        dataMap.add("pageSize", pageSize);
        Result requestResult = restTemplate.postForObject("http://book-provider/book/booklist", dataMap, Result.class);
        return requestResult;
    }

    @PostMapping("/delbook")
    public Result delBook(@RequestParam Integer bookId) {
        MultiValueMap<String, Object> dataMap = new LinkedMultiValueMap<String, Object>();
        dataMap.add("bookId", bookId);
        Result requestResult = restTemplate.postForObject("http://book-provider/book/delbook", dataMap, Result.class);
        return requestResult;
    }

    @PostMapping(value = "/download")
    public ResponseEntity<byte[]> downloadBook(@RequestParam(value = "bookId") int bookId, @RequestHeader("User-Agent") String userAgent) throws Exception {
        return null;
    }
}
