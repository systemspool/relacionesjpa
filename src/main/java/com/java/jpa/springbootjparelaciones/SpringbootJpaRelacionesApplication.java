package com.java.jpa.springbootjparelaciones;

import com.java.jpa.springbootjparelaciones.entities.Client;
import com.java.jpa.springbootjparelaciones.entities.Invoice;
import com.java.jpa.springbootjparelaciones.repositories.ClientRepository;
import com.java.jpa.springbootjparelaciones.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootJpaRelacionesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaRelacionesApplication.class, args);
    }

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public void run(String... args) throws Exception {
        manyToOne();
    }


    public void manyToOne(){
        //creamos un nuevo cliente y lo salvamos en la bd
        Client client = new Client("Jose", "Andrade");
        clientRepository.save(client);

        //creamos una factura y le pasamos el cliente y la guardamos
        Invoice invoice = new Invoice("Compras de oficina", 2000L);
        invoice.setClient(client);
        Invoice invoiceDb = invoiceRepository.save(invoice);
        System.out.println(invoiceDb);
    }
}
