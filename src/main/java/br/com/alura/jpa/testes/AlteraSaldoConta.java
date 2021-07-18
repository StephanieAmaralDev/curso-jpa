package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlteraSaldoConta {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = em.find(Conta.class, 1L);
        em.getTransaction().begin();
        conta.setSaldo(20.00);
        em.getTransaction().commit();
    }
}
