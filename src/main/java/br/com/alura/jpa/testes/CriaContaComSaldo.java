package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaContaComSaldo {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("Ste");
        conta.setNumero(45678);
        conta.setAgencia(4254);
        conta.setSaldo(500.00);
         //managed
        em.getTransaction().begin();

        em.persist(conta);

        em.getTransaction().commit();

        em.close();

        //detached
        EntityManager em2 = emf.createEntityManager();
        conta.setSaldo(500.000);

        em2.getTransaction().begin();
        em2.merge(conta);
        em2.getTransaction().commit();

    }
}
