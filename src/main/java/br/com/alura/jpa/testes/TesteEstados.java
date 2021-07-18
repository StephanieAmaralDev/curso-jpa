package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteEstados {
    public static void main(String[] args) {

        Conta conta = new Conta();
        conta.setTitular("ste");
        conta.setAgencia(4254);
        conta.setNumero(45678);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //transiente -> managed
        em.persist(conta);

        //managed -> removed
        em.remove(conta); //remove do contexto
        em.getTransaction().commit();
    }
}
