package com.lwando.pos.system.Service;

import com.lwando.pos.system.exceptions.UserException;
import com.lwando.pos.system.modal.Store;
import com.lwando.pos.system.modal.User;
import com.lwando.pos.system.payload.dto.StoreDTO;

import java.util.List;

public interface StoreService {

    StoreDTO createStore(StoreDTO storeDTO, User user);
    StoreDTO getStoreById(Long id) throws Exception;
    List<StoreDTO> getAllStores();
    Store getStoreByAdmin() throws UserException;
    StoreDTO updateStore(Long id, StoreDTO storeDTO) throws Exception;
    void deleteStore(Long id) throws UserException;
    StoreDTO getStoreByEmployee() throws UserException;
}
