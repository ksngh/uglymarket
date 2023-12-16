package com.uglymarket.service;

import com.uglymarket.domain.Item;
import com.uglymarket.dto.request.ItemReqDTO;
import com.uglymarket.dto.response.ItemResDTO;
import com.uglymarket.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    
    private final ItemMapper itemMapper;
    private final ModelMapper modelMapper;

    /**
     * 모든 상품 조회
     * @return - 상품 응답 DTO 리스트
     */
    public List<ItemResDTO> findItems() {
        List<Item> items = itemMapper.selectItems();
        return items.stream()
                .map(item -> modelMapper.map(item, ItemResDTO.class))
                .toList();
    }

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

    /**
     * 상품 삭제
     * @param id - 상품 번호
     */
    public void removeItem(Long id) {
        itemMapper.deleteItem(id);
    }
}
