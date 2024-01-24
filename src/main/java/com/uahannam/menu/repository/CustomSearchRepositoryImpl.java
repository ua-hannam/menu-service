//package com.uahannam.menu.repository;
//
//import com.uahannam.menu.config.ElasticsearchOperations;
//import com.uahannam.menu.domain.Search;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.elasticsearch.core.SearchHit;
//import org.springframework.data.elasticsearch.core.SearchHits;
//import org.springframework.data.elasticsearch.core.query.Criteria;
//import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
//import org.springframework.data.elasticsearch.core.query.Query;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@Component
//public class CustomSearchRepositoryImpl implements CustomSearchRepository {
//
//    private final ElasticsearchOperations elasticsearchOperations;
//
//    @Override
//    public List<Search> searchByName(String name, Pageable pageable) {
//        Criteria criteria = Criteria.where("basicProfile.name").contains(name);
//        Query query = new CriteriaQuery(criteria).setPageable(pageable);
//        SearchHits<Search> search = elasticsearchOperations.search(query, Search.class);
//        return search.stream()
//                .map(SearchHit::getContent)
//                .toList();
//    }
//}
