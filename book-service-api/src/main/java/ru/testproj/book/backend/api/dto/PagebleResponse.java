package ru.testproj.book.backend.api.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PagebleResponse<T> {
    int elements;
    boolean hasMore;
    List<T> data;

//    public static class Builder<T>{
//        private PagebleResponse<T> pagebleResponse;
//
//        public Builder() {
//            pagebleResponse =new PagebleResponse<>();
//        }
//        public Builder<T> elements(int elements){
//            pagebleResponse.elements=elements;
//            return this;
//        }
//        public Builder<T> hasMore(boolean hasMore){
//            pagebleResponse.hasMore=hasMore;
//            return this;
//        }
//        public Builder<T> data(List<T> list){
//            pagebleResponse.data=list;
//            return this;
//        }
//        public PagebleResponse<T> build(){
//            return pagebleResponse;
//        }
//
//
//    }

}
