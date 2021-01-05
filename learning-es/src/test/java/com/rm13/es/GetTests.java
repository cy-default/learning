package com.rm13.es;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * 从es中查询记录
 */
@SpringBootTest
class GetTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 查询指定id的数据
     * <p>
     * get [posts][_doc][1]: routing [null]
     * <p>
     * {"_index":"posts","_type":"_doc","_id":"1","_version":3,"_seq_no":7,"_primary_term":1,"found":true,"_source":{"user":"kimchy","postDate":"2013-01-30","message":"trying out Elasticsearch"}}
     */
    @Test
    public void get01() throws IOException {
        final GetRequest getRequest = new GetRequest("posts", "1");
        final GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        // get [posts][_doc][1]: routing [null]
        System.out.println(getRequest);
        // {"_index":"posts","_type":"_doc","_id":"1","_version":3,"_seq_no":7,"_primary_term":1,"found":true,"_source":{"user":"kimchy","postDate":"2013-01-30","message":"trying out Elasticsearch"}}
        System.out.println(getResponse);
    }

    @Test
    public void getAsync01() throws IOException {
        final GetRequest getRequest = new GetRequest("posts", "1");
        final GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        // get [posts][_doc][1]: routing [null]
        System.out.println(getRequest);
        // {"_index":"posts","_type":"_doc","_id":"1","_version":3,"_seq_no":7,"_primary_term":1,"found":true,"_source":{"user":"kimchy","postDate":"2013-01-30","message":"trying out Elasticsearch"}}
        System.out.println(getResponse);
    }

    /**
     * 查询指定id的数据；不查询source数据；
     * get [posts][_doc][1]: routing [null]
     * <p>
     * {"_index":"posts","_type":"_doc","_id":"1","_version":3,"_seq_no":7,"_primary_term":1,"found":true}
     */
    @Test
    public void doNotFetchSource01() throws IOException {
        final GetRequest getRequest = new GetRequest("posts", "1");
        getRequest.fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE);
        final GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        // get [posts][_doc][1]: routing [null]
        System.out.println(getRequest);
        // {"_index":"posts","_type":"_doc","_id":"1","_version":3,"_seq_no":7,"_primary_term":1,"found":true}
        System.out.println(getResponse);
    }

    /**
     * 查询指定字段的数据
     *
     * @throws IOException
     */
    @Test
    public void fetchAssignFiledSource01() throws IOException {

        String[] inclouds = {"message", "*Date"};
        String[] exclouds = Strings.EMPTY_ARRAY;
        FetchSourceContext fetchSourceContext = new FetchSourceContext(true, inclouds, exclouds);

        // id不能不填；否则报错 （ActionRequestValidationException: Validation Failed: 1: id is missing;）
        GetRequest getRequest = new GetRequest("posts", "1");
        getRequest.fetchSourceContext(fetchSourceContext);
        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);

        // get [posts][_doc][1]: routing [null]
        System.out.println(getRequest.toString());
        // {"_index":"posts","_type":"_doc","_id":"1","_version":3,"_seq_no":7,"_primary_term":1,"found":true,"_source":{"postDate":"2013-01-30","message":"trying out Elasticsearch"}}
        System.out.println(getResponse.toString());
    }

    /**
     * 查询除去不需要的字段的所有字段；
     *
     * @throws IOException
     */
    @Test
    public void fetchAssignFiledSource02() throws IOException {

        String[] includes = Strings.EMPTY_ARRAY;
        String[] excludes = {"message"};
        FetchSourceContext fetchSourceContext = new FetchSourceContext(true, includes, excludes);

        // id不能不填；否则报错 （ActionRequestValidationException: Validation Failed: 1: id is missing;）
        GetRequest getRequest = new GetRequest("posts", "1");
        getRequest.fetchSourceContext(fetchSourceContext);
        getRequest.routing("routing");

        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);

        // get [posts][_doc][1]: routing [null]
        System.out.println(getRequest.toString());
        // {"_index":"posts","_type":"_doc","_id":"1","_version":3,"_seq_no":7,"_primary_term":1,"found":true,"_source":{"postDate":"2013-01-30","user":"kimchy"}}
        System.out.println(getResponse.toString());

        if(getResponse.isExists()){
            System.out.println(getResponse.getSourceAsString());
        }else{
            System.out.println("xxx");
        }
    }

    @Test
    public void indexNotExistedException() throws IOException {

        String[] includes = Strings.EMPTY_ARRAY;
        String[] excludes = {"message"};
        FetchSourceContext fetchSourceContext = new FetchSourceContext(true, includes, excludes);

        // id不能不填；否则报错 （ActionRequestValidationException: Validation Failed: 1: id is missing;）
        GetRequest getRequest = new GetRequest("posts333", "1");
        getRequest.fetchSourceContext(fetchSourceContext);
        getRequest.routing("routing");

        try {
            GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        }catch (ElasticsearchException e){
            System.out.println(e.getMessage());
           if(e.status() == RestStatus.NOT_FOUND){
               System.out.println("404==NOT_FOUND");
           }
        }
    }


}
