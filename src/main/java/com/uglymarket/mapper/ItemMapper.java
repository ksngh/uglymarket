package com.uglymarket.mapper;

import com.uglymarket.domain.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    /**
     * 상품 삭제
     * @param id - 상품 번호
     */
    void deleteItem(Long id);

    /**
     * 모든 상품 조회
     * @return - 상품 도메인 리스트
     */
    List<Item> selectItems();

    /**
     * 조회수 카운트 등록
     * @param id - 상품 번호
     */
    void updateViewCnt(Long id);
}
