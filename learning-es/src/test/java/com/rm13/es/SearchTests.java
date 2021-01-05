package com.rm13.es;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 从es中查询记录
 */
@SpringBootTest
class SearchTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;


    /**
     * 全量查询
     *
     * @throws IOException
     */
    @Test
    public void search01() throws IOException {
        final SearchRequest searchRequest = new SearchRequest("posts");
        final SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);
        final SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(searchRequest.toString());
        System.out.println(searchResponse.toString());
    }

    /**
     * 精确查询
     *
     * @throws IOException
     */
    @Test
    public void search02() throws IOException {
        final SearchRequest searchRequest = new SearchRequest();
        final SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.termQuery("user", "kimchy"));
        sourceBuilder.from(0);
        sourceBuilder.size(5);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(sourceBuilder);
        searchRequest.indices("posts");
        final SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        // SearchRequest{searchType=QUERY_THEN_FETCH, indices=[posts], indicesOptions=IndicesOptions[ignore_unavailable=false, allow_no_indices=true, expand_wildcards_open=true, expand_wildcards_closed=false, allow_aliases_to_multiple_indices=true, forbid_closed_indices=true, ignore_aliases=false, ignore_throttled=true], types=[], routing='null', preference='null', requestCache=null, scroll=null, maxConcurrentShardRequests=0, batchedReduceSize=512, preFilterShardSize=128, allowPartialSearchResults=null, localClusterAlias=null, getOrCreateAbsoluteStartMillis=-1, ccsMinimizeRoundtrips=true, source={"from":0,"size":5,"timeout":"60s","query":{"term":{"user":{"value":"kimchy","boost":1.0}}}}}
        System.out.println(searchRequest.toString());
        // {"took":8,"timed_out":false,"_shards":{"total":1,"successful":1,"skipped":0,"failed":0},"hits":{"total":{"value":1,"relation":"eq"},"max_score":0.9808292,"hits":[{"_index":"posts","_type":"_doc","_id":"1","_score":0.9808292,"_source":{"user":"kimchy","postDate":"2013-01-30","message":"trying out Elasticsearch"}}]}}
        System.out.println(searchResponse.toString());
    }


    @Test
    public void search03() throws IOException {
        QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("user", "kimchy")
                .fuzziness(Fuzziness.AUTO)
                .prefixLength(3)
                .maxExpansions(10);

        final SearchRequest searchRequest = new SearchRequest();
        final SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(matchQueryBuilder);

        searchRequest.source(sourceBuilder);
        searchRequest.indices("posts");

        final SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        // {"query":{"match":{"user":{"query":"kimchy","operator":"OR","fuzziness":"AUTO","prefix_length":3,"max_expansions":10,"fuzzy_transpositions":true,"lenient":false,"zero_terms_query":"NONE","auto_generate_synonyms_phrase_query":true,"boost":1}}}}
        System.out.println(searchRequest.toString());
        // {"took":36,"timed_out":false,"_shards":{"total":1,"successful":1,"skipped":0,"failed":0},"hits":{"total":{"value":1,"relation":"eq"},"max_score":0.9808292,"hits":[{"_index":"posts","_type":"_doc","_id":"1","_score":0.9808292,"_source":{"user":"kimchy","postDate":"2013-01-30","message":"trying out Elasticsearch"}}]}}
        System.out.println(searchResponse.toString());
    }

    /**
     * 排序
     *
     * @throws IOException
     */
    @Test
    public void search04() throws IOException {
        QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("user", "kimchy")
                .fuzziness(Fuzziness.AUTO)
                .prefixLength(3)
                .maxExpansions(10);

        final SearchRequest searchRequest = new SearchRequest();
        final SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(matchQueryBuilder);
        // 排序
        sourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
        sourceBuilder.sort(new FieldSortBuilder("_id").order(SortOrder.ASC));
        // 不查询source
        // sourceBuilder.fetchSource(false);
        // 按字段查询
        String[] includeFields = new String[] {"title", "innerObject.*"};
        String[] excludeFields = new String[] {"user"};
        sourceBuilder.fetchSource(includeFields, excludeFields);

        searchRequest.source(sourceBuilder);
        searchRequest.indices("posts");

        final SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        // {"query":{"match":{"user":{"query":"kimchy","operator":"OR","fuzziness":"AUTO","prefix_length":3,"max_expansions":10,"fuzzy_transpositions":true,"lenient":false,"zero_terms_query":"NONE","auto_generate_synonyms_phrase_query":true,"boost":1.0}}},"sort":[{"_score":{"order":"desc"}},{"_id":{"order":"asc"}}]}
        System.out.println(searchRequest.toString());
        // {"took":4,"timed_out":false,"_shards":{"total":1,"successful":1,"skipped":0,"failed":0},"hits":{"total":{"value":1,"relation":"eq"},"max_score":null,"hits":[{"_index":"posts","_type":"_doc","_id":"1","_score":0.9808292,"_source":{"user":"kimchy","postDate":"2013-01-30","message":"trying out Elasticsearch"},"sort":[0.9808292,"1"]}]}}
        System.out.println(searchResponse.toString());
    }




}
