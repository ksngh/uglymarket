package com.uglymarket.mapper;

import com.uglymarket.domain.Item;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {

    /**
     * 상품 등록
     * @param item - 상품 도메인
     */
    void insertItem(Item item);

    /**
     * 상품 수정
     * @param item - 상품 도메인
     */
    void updateItem(Item item);

    /**
     * 상품 조회
     * @param id - 상품 번호
     * @return - 상품 도메인
     */
    Item selectItemById(Long id);
}
