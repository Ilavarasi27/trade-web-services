package com.example.tradewebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
            "MM/dd/yyyy HH:mm:ss");

    @Autowired
    private TradeRepository tradeRepository;


    @Scheduled(fixedRate = 10000)
    public void performTask() {

        System.out.println("Regular task performed at "
                + dateFormat.format(new Date()));

        boolean test = true;
        Date start = null;
        Date end = null;
       TradeBean tradeBean = new TradeBean();
        for (int i = 0; i < tradeRepository.findAll().size(); i++) {
            Date maturity_date = tradeRepository.findAll().get(i).getMaturityDate();
            Date created_date = tradeRepository.findAll().get(i).getCreatedDate();


            tradeBean = tradeRepository.findById(Long.valueOf(i)).get();

            if(maturity_date.compareTo( created_date) > 1){
                test = true;
            } else {
                test = false;
            }
        }
        while(test==true){
            if (start.before(new Date()) == true && end.after(new Date())==true ) {
                tradeBean.setExpiry('Y');

            }else{
                tradeBean.setExpiry('N');

            }

            try {
                tradeRepository.save(tradeBean);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
        }

    }

    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void performDelayedTask() {

        System.out.println("Delayed Regular task performed at "
                + dateFormat.format(new Date()));

    }

    @Scheduled(cron = "*/5 * * * * *")
    public void performTaskUsingCron() {

        System.out.println("Regular task performed using Cron at "
                + dateFormat.format(new Date()));

    }
}
