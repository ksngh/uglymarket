package com.uglymarket.service;

import com.uglymarket.domain.Item;
import com.uglymarket.dto.request.ItemReqDTO;
import com.uglymarket.dto.response.ItemResDTO;
import com.uglymarket.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    
    private final ItemMapper itemMapper;
    private final ModelMapper modelMapper;

    /**
     * 상품 등록
     * @param itemReqDTO - 상품 요청 DTO
     * @return - 상품 번호
     */
    public Long saveItem(ItemReqDTO itemReqDTO) {
        Item item = modelMapper.map(itemReqDTO, Item.class);
        itemMapper.insertItem(item);
        return item.getId();
    }

    /**
     * 상품 수정
     * @param itemReqDTO - 상품 요청 DTO
     */
    public void modifyItem(ItemReqDTO itemReqDTO) {
        Item item = modelMapper.map(itemReqDTO, Item.class);
        itemMapper.updateItem(item);
    }

    /**
     * 상품 조회
     * @param id - 상품 번호
     * @return - 상품 응답 DTO
     */
    public ItemResDTO findItem(Long id) {
        Item item = itemMapper.selectItemById(id);
        return modelMapper.map(item, ItemResDTO.class);
    }
}
