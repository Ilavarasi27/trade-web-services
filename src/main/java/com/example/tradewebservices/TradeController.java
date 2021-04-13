package com.example.tradewebservices;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class TradeController {

   @Autowired
   private TradeService tradeService;

   @Autowired
   private TradeRepository tradeRepository;

   @GetMapping("/trade/all")
   public List<TradeBean> getAllTrades(){
       //return tradeService.retrieveAll();
      return tradeRepository.findAll();
   }

   @PutMapping("/trade/update/{id}")
   public ResponseEntity<TradeBean> updateTrade(
           @PathVariable long id,@RequestBody TradeBean tradeBean
   ) throws Exception {
      //TradeBean updatedTradeBean = tradeService.save(tradeBean);
      TradeBean updatedTradeBean = tradeRepository.save(tradeBean);
      if(updatedTradeBean == null) {
         throw new Exception();
      }
      return  new ResponseEntity<TradeBean>(tradeBean, HttpStatus.OK) ;
   }

   @PostMapping("/trade/create")
   public ResponseEntity<Void> createTrade(@RequestBody TradeBean tradeBean
   ){
      //TradeBean createdTradeBean = tradeService.save(tradeBean);
      TradeBean createdTradeBean = tradeRepository.save(tradeBean);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
              .path("/{id}").buildAndExpand(createdTradeBean.getId()).toUri();

      return ResponseEntity.created(uri).build();
   }



}
