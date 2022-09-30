package com.iliasServices.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    public final FraudCechkHistoryRepository fraudCechkHistoryRepository ;

    public boolean isFraudulentCustomer( Integer customerId){
        fraudCechkHistoryRepository.save(FraudCeckHistory
                .builder().customerId(customerId)
                        .isFraudster(false)
                        .creadetAt(LocalDateTime.now())
                        .build());
        return false ;
    }
}
