package com.example.tradewebservices;


import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TradeService {

    private static List<TradeBean> tradeBeans = new ArrayList();
    private static long idCounter = 0;

   static {
        tradeBeans.add(new TradeBean(++idCounter, "T1",1, "CP-1","B1", new Date(2020,05,20),new Date(),'N'));
        tradeBeans.add(new TradeBean(++idCounter, "T2",2, "CP-2","B1", new Date(2021,05,20),new Date(),'N'));
        tradeBeans.add(new TradeBean(++idCounter, "T2",1, "CP-1","B1", new Date(2021,05,20),new Date(),'N'));
        tradeBeans.add(new TradeBean(++idCounter, "T3",3, "CP-3","B2", new Date(2014,05,20),new Date(),'Y'));

    }

    public List<TradeBean> retrieveAll() {
        return tradeBeans;
    }


    public TradeBean save(TradeBean tradeBean) {
       if(tradeBean.getVersion() < 1) {
           System.out.print(tradeBean.getVersion());
           return null;

       }
        if(tradeBean.getId() == -1 || tradeBean.getId() == 0) {
            tradeBean.setId(++idCounter);
            tradeBeans.add(tradeBean);
        } else {
            deleteById(tradeBean.getId());
            tradeBeans.add(tradeBean);
        }
        return tradeBean;
    }

    public TradeBean deleteById(long id) {
        TradeBean tradeById = findById(id);

        if(tradeById == null) return null;

        if(tradeBeans.remove(tradeById)){
            return tradeById;
        }
        return null;
    }

    public TradeBean findById(long id){
        for(TradeBean tradeBean: tradeBeans){
            if(tradeBean.getId() == id){
                return tradeBean;
            }
        }

        return null;
    }


}
