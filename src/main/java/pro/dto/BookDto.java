package pro.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BookDto {

    private String bookId;          // 도서 ID
    private String name;            // 도서명
    private int unitPrice;          // 가격
    private String author;          // 저자
    private String description;     // 설명
    private String publisher;       // 출판사
    private String category;        // 분류
    private long unitsInStock;      // 재고수
    private String releaseDate;     // 출판일
    private String condition;       // 상태(New, Old, EBook)
    private String imageUrl;        // 이미지 URL 추가
    private transient MultipartFile image;  // MultipartFile 필드 추가
}
