package com.uglymarket.service;

import com.uglymarket.domain.Item;
import com.uglymarket.dto.request.ItemReqDTO;
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
}
