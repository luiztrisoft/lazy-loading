package com.trisoft.lazyproject.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.trisoft.lazyproject.entity.Jogador;

public class JogadorRepositoryImpl implements JogadorRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Jogador> filtrar(JogadorFilter jogadorFilter, Pageable pageable) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Jogador> criteriaQuery = criteriaBuilder.createQuery(Jogador.class);
		Root<Jogador> root = criteriaQuery.from(Jogador.class);

		Predicate[] predicates = criarRestricoes(jogadorFilter, criteriaBuilder, root);
		criteriaQuery.where(predicates);
		criteriaQuery.orderBy(criteriaBuilder.asc(root.get("nome")));

		TypedQuery<Jogador> typedQuery = manager.createQuery(criteriaQuery);
		adicionarRestricoesDePaginacao(typedQuery, pageable);

		return new PageImpl<>(typedQuery.getResultList(), pageable, total(jogadorFilter));
	}

	private Predicate[] criarRestricoes(JogadorFilter jogadorFilter, CriteriaBuilder builder, Root<Jogador> root) {
		List<Predicate> predicates = new ArrayList<>();
		// predicates.add(builder.equal(root.get("id"),jogadorFilter.getId()));
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Jogador> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);

	}

	private Long total(JogadorFilter jogadorFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Jogador> root = criteria.from(Jogador.class);
		Predicate[] predicates = criarRestricoes(jogadorFilter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}
