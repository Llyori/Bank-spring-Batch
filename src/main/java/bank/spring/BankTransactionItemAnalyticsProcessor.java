package bank.spring;

import bank.spring.dao.BankTransaction;
import lombok.Getter;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

//@Component
public class BankTransactionItemAnalyticsProcessor implements ItemProcessor<BankTransaction, BankTransaction> {
    @Getter private double totalDebit;
    @Getter private double totalCredit;
    @Override
    public BankTransaction process(BankTransaction bankTransaction) throws Exception {
        if(bankTransaction.getTransactionType().equals("D"))
            totalDebit += bankTransaction.getAmount();
        else if (bankTransaction.getTransactionType().equals("W"))
            totalCredit += bankTransaction.getAmount();
        return bankTransaction;
    }
}
