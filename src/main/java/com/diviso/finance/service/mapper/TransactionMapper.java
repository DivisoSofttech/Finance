package com.diviso.finance.service.mapper;

import com.diviso.finance.domain.*;
import com.diviso.finance.service.dto.TransactionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Transaction and its DTO TransactionDTO.
 */
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface TransactionMapper extends EntityMapper<TransactionDTO, Transaction> {

    @Mapping(source = "transaction.id", target = "transactionId")
    TransactionDTO toDto(Transaction transaction);

    @Mapping(source = "transactionId", target = "transaction")
    Transaction toEntity(TransactionDTO transactionDTO);

    default Transaction fromId(Long id) {
        if (id == null) {
            return null;
        }
        Transaction transaction = new Transaction();
        transaction.setId(id);
        return transaction;
    }
}
