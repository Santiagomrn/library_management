package Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Lending {
    private String bookCode, memberNumber;
    private LocalDateTime date;

    public Lending(String bookCode, String memberNumber, LocalDateTime date) {
        this.bookCode = bookCode;
        this.memberNumber = memberNumber;
        this.date = date;
    }
    public String getBookCode() {
        return bookCode;
    }
    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }
    public String getMemberNumber() {
        return memberNumber;
    }
    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getFormattedDate(){
        String format = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(format);
        return dateFormatter.format(date);
    }
    @Override
    public String toString() {
         return "Lending{" + "bookCode=" + bookCode + ", memberNumber=" + memberNumber + ", date="
                + this.getFormattedDate() + '}';
    }
}
