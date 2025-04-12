package com.Bank.BPDZ;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Bank.BPDZ.Entity.BPDZDir;
import com.Bank.BPDZ.Repository.RepositoryBpdzDir;

@SpringBootApplication
public class BankManagmentSystemBpdz1Application implements CommandLineRunner{
	

	public static void main(String[] args) {
		SpringApplication.run(BankManagmentSystemBpdz1Application.class, args);
	}
    @Autowired
	private RepositoryBpdzDir savecompte;
    @Autowired
    private BPDZDir s;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*BPDZDir x=new BPDZDir("BNA","123456","BNALDZAL627","BNA A.P 627 N° 81 Rue Ali REMLI Bouzareah –Alger",true,"O","P1");
		 BPDZDir h=new BPDZDir(" BNP Paribas EL Djazair","1234568","BDLODZALXXX"," 8 Quartier d'Affaires d'Alger Lot 1 N°03.I – Bab Ezzouar – 16024 Alger",true,"O","P1");
		 BPDZDir v=new BPDZDir("BDL","1234567","BNPADZALXXX El Djazair"," 05, Rue GACI Amar, Staouéli, Alger ",true,"O","P1");
		 BPDZDir c=new BPDZDir("BPDZ","0000000","BPDZALALXXX","home",true,"O","P4");
		savecompte.save(h);
		savecompte.save(v);
		savecompte.save(c);*/
			}
}
