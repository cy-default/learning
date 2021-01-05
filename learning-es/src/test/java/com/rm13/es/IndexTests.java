package com.rm13.es;

import com.rm13.es.config.ElasticsearchConfig;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 索引记录到es中
 */
@SpringBootTest
class IndexTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 索引一条记录到es中；以JSON的形式
     * <p>
     * index {[posts][_doc][1], source[{"user":"kimchy","postDate":"2013-01-30","message":"trying out Elasticsearch"}]}
     * <p>
     * IndexResponse[index=posts,type=_doc,id=1,version=3,result=updated,seqNo=7,primaryTerm=1,shards={"total":2,"successful":1,"failed":0}]
     */
    @Test
    public void syncIndexTest01() throws IOException {
        IndexRequest request = new IndexRequest("posts");
        request.id("1");
        String jsonString = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        request.source(jsonString, XContentType.JSON);
        System.out.println(request.toString());
        final IndexResponse indexResponse = restHighLevelClient.index(request, ElasticsearchConfig.COMMON_OPTIONS);
        System.out.println(indexResponse);

        String index = indexResponse.getIndex();
        String id = indexResponse.getId();
        if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
            // xxxx

        } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {
            // xxxx

        }
        ReplicationResponse.ShardInfo shardInfo = indexResponse.getShardInfo();
        if (shardInfo.getTotal() != shardInfo.getSuccessful()) {
            // xxxx

        }
        if (shardInfo.getFailed() > 0) {
            for (ReplicationResponse.ShardInfo.Failure failure :
                    shardInfo.getFailures()) {
                String reason = failure.reason();
            }
        }
    }

    /**
     * 索引一条记录到es中；以Map的形式
     * <p>
     * index {[posts][_doc][2], source[{"postDate":"2020-12-28T12:55:15.988Z","message":"trying out Elasticsearch","user":"love"}]}
     * <p>
     * IndexResponse[index=posts,type=_doc,id=2,version=3,result=updated,seqNo=6,primaryTerm=1,shards={"total":2,"successful":1,"failed":0}]
     */
    @Test
    public void syncIndexTest02() throws IOException {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "love");
        jsonMap.put("postDate", LocalDateTime.now());
        jsonMap.put("message", "trying out Elasticsearch");
        IndexRequest indexRequest = new IndexRequest("posts")
                .id("2").source(jsonMap);
        System.out.println(indexRequest.toString());
        final IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse);
    }

    /**
     * 索引一条记录到es中；以数组的形式
     * <p>
     * index {[posts][_doc][3], source[{"user":"rm13","postDate":"2020-12-28","message":"trying out Elasticsearch"}]}
     * <p>
     * IndexResponse[index=posts,type=_doc,id=3,version=2,result=updated,seqNo=5,primaryTerm=1,shards={"total":2,"successful":1,"failed":0}]
     */
    @Test
    public void syncIndexTest03() throws IOException {
        IndexRequest indexRequest = new IndexRequest("posts")
                .id("3")
                .source("user", "rm13",
                        "postDate", LocalDate.now(),
                        "message", "trying out Elasticsearch");
        System.out.println(indexRequest.toString());
        final IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse);
    }

    /**
     * 异步索引记录到es中；
     */
    @Test
    public void asyncIndexTest01() throws IOException {
        IndexRequest indexRequest = new IndexRequest("posts")
                .id("4")
                .source("user", "myy",
                        "postDate", LocalDate.now(),
                        "message", "trying out Elasticsearch");
        System.out.println(indexRequest.toString());
        restHighLevelClient.indexAsync(indexRequest, RequestOptions.DEFAULT, new ActionListener<IndexResponse>() {
            @Override
            public void onResponse(IndexResponse indexResponse) {
                System.out.println(indexResponse);
            }

            @Override
            public void onFailure(Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }

    /**
     * 乐观锁更新数据
     */
    @Test
    public void conflictIndex() throws IOException {
        IndexRequest request = new IndexRequest("posts")
                .id("1")
                .source("field", "value")
                .setIfSeqNo(10L)
                .setIfPrimaryTerm(20);
        try {
            IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        } catch (ElasticsearchException e) {
            // Elasticsearch exception [type=version_conflict_engine_exception, reason=[1]: version conflict, required seqNo [10], primary term [20]. current document has seqNo [7] and primary term [1]]
            System.out.println(e.getMessage());
            // CONFLICT
            System.out.println(e.status());
            if (e.status() == RestStatus.CONFLICT) {
                // xxxx
            }
        }
    }

    /**
     * 索引一条记录到es中；若已存在报错；
     */
    @Test
    public void createIndexTest() throws IOException {
        IndexRequest request = new IndexRequest("posts")
                .id("1")
                .source("field", "value")
                .opType(DocWriteRequest.OpType.CREATE);
        try {
            IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        } catch (ElasticsearchException e) {
            // Elasticsearch exception [type=version_conflict_engine_exception, reason=[1]: version conflict, document already exists (current version [3])]
            System.out.println(e.getMessage());
            // CONFLICT
            System.out.println(e.status());
            if (e.status() == RestStatus.CONFLICT) {

            }
        }
    }

}
