package com.apple.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Service;

import com.apple.dtos.request.SearchRequestDTO;
import com.apple.entity.UserSolrDocument;
import com.apple.repos.SearchRepositoryCustom;
import com.apple.services.SolrSearchService;

@Service
public class SolrSearchServiceImpl implements SolrSearchService {

	@Resource
	private SolrTemplate solrTemplate;

	@Autowired
	private SearchRepositoryCustom searchRepo;

	public List<UserSolrDocument> search(SearchRequestDTO searchRequest) {


		String searchKeyword = searchRequest.getSearchText();
		return searchRepo.findByQueryAnnotation(searchKeyword);

		
	}

}
