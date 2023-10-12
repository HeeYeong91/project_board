package com.ezen.springmvc.domain.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ezen.springmvc.domain.board.dto.ArticleDTO;
import com.ezen.springmvc.domain.board.mapper.ArticleMapper;
import com.ezen.springmvc.domain.common.web.PageParams;

import lombok.RequiredArgsConstructor;

/**
 * ArticleService 구현체 (2023-08-18)
 * @author 이희영
 */
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
	
	private final ArticleMapper articleMapper;

	@Override
	public void create(ArticleDTO articleDTO) {
		articleMapper.create(articleDTO);
	}
	
	@Override
	public ArticleDTO find(int articleId) {
		return articleMapper.find(articleId);
	}

	@Override
	public int getCountAll(int boardId, String keyword) {
		return articleMapper.getCountAll(boardId, keyword);
	}

	@Override
	public List<ArticleDTO> findByAll(PageParams pageParams) {
		return articleMapper.findByAll(pageParams);
	}

	@Override
	public ArticleDTO findArticle(int articleId) {
		return articleMapper.findArticle(articleId);
	}

	@Override
	public void updateOrderNo(ArticleDTO articleDTO) {
		articleMapper.updateOrderNo(articleDTO);
	}

	@Override
	@Transactional
	public void createReply(ArticleDTO articleDTO, ArticleDTO topArticle) {
		articleMapper.updateOrderNo(topArticle);
		articleMapper.createReply(articleDTO, topArticle);
	}

	@Override
	public void updateHitCount(int articleId) {
		articleMapper.updateHitCount(articleId);
	}

	@Override
	@Transactional
	public ArticleDTO readArticle(int articleId) {
		articleMapper.updateHitCount(articleId);
		return articleMapper.readArticle(articleId);
	}

	@Override
	@Transactional
	public void update(ArticleDTO articleDTO) {
		articleMapper.update(articleDTO);
	}

	@Override
	@Transactional
	public void delete(ArticleDTO articleDTO) {
		articleMapper.delete(articleDTO);
	}
}