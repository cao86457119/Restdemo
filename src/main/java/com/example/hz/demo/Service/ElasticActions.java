package com.example.hz.demo.Service;

import com.example.hz.demo.config.ElasticHighClient;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.get.GetRequest;;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class ElasticActions {

    private  final static Logger logger = LoggerFactory.getLogger(ElasticActions.class);

    @Autowired



    public static String getQuery(){
        RestHighLevelClient restHighLevelClient = new ElasticHighClient().restHighLevelClient();
        SearchRequest request = new SearchRequest("table");
        request.types("WM_A0001");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("CORECONTENT","福建"));
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(5);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        //highlight
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        HighlightBuilder.Field highlightTitle =
                new HighlightBuilder.Field("CORECONTENT");
        highlightTitle.highlighterType("unified");
        highlightBuilder.field(highlightTitle);
        HighlightBuilder.Field highlightUser = new HighlightBuilder.Field("user");
        highlightBuilder.field(highlightUser);
        searchSourceBuilder.highlighter(highlightBuilder);

        request.source(searchSourceBuilder);

        //SearchRequest
        try {
            SearchResponse searchResponse = restHighLevelClient.search(request, RequestOptions.DEFAULT);
            RestStatus status = searchResponse.status();
            TimeValue took = searchResponse.getTook();
            Boolean terminatedEarly = searchResponse.isTerminatedEarly();
            boolean timedOut = searchResponse.isTimedOut();
            SearchHits hits = searchResponse.getHits();

            long totalHits = hits.getTotalHits();
            SearchHit[] searchHits = hits.getHits();
            for (SearchHit hit : searchHits) {
                // do something with the SearchHit
                String index = hit.getIndex();
                String id = hit.getId();
                float score = hit.getScore();

                String sourceAsString = hit.getSourceAsString();
                Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                String documentTitle = (String) sourceAsMap.get("title");
                Map<String, Object> innerObject =
                        (Map<String, Object>) sourceAsMap.get("innerObject");

                Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                HighlightField highlight = highlightFields.get("CORECONTENT");
                Text[] fragments = highlight.fragments();
                String fragmentString = fragments[0].string();

                logger.info(hit.getId());
                logger.info(fragmentString);
            }

            float maxScore = hits.getMaxScore();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                restHighLevelClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "ok";
    }


    public static void main(String...args){
        getQuery();
    }



    public void createIndex(String indexname) throws IOException {
         RestHighLevelClient restHighLevelClient = new ElasticHighClient().restHighLevelClient();
        //创建索引
        IndexRequest request = new IndexRequest("posts");
        request.id("1");
        String jsonString = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        request.source(jsonString, XContentType.JSON);

        /**
         * Document source provided as a Map which gets automatically converted to JSON format
         */
//        Map<String, Object> jsonMap = new HashMap<>();
//        jsonMap.put("user", "kimchy");
//        jsonMap.put("postDate", new Date());
//        jsonMap.put("message", "trying out Elasticsearch");
//        IndexRequest indexRequest = new IndexRequest("posts")
//                .id("1").source(jsonMap);

        /**
         * Document source provided as an XContentBuilder object, the Elasticsearch built-in helpers to generate JSON content
         */
//        XContentBuilder builder = null;
//        try {
//            builder = XContentFactory.jsonBuilder();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        builder.startObject();
//        {
//            builder.field("user", "kimchy");
//            builder.timeField("postDate", new Date());
//            builder.field("message", "trying out Elasticsearch");
//        }
//        builder.endObject();
//            indexRequest = new IndexRequest("posts")
//                .id("1").source(builder);
/**
 * Document source provided as Object key-pairs, which gets converted to JSON format
 */
//        IndexRequest indexRequest = new IndexRequest("posts")
//                .id("1")
//                .source("user", "kimchy",
//                        "postDate", new Date(),
//                        "message", "trying out Elasticsearch");

        try {
            IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        } catch(ElasticsearchException e) {
            if (e.status() == RestStatus.CONFLICT) {

            }
        }
    }

    public void getIndex(String index){
        GetRequest getRequest = new GetRequest("posts","1", "1");
    }

    public void searchDoc(String docid,String indexname){
        RestHighLevelClient restHighLevelClient = new ElasticHighClient().restHighLevelClient();
        SearchRequest searchRequest = new SearchRequest(indexname);
        try {
            restHighLevelClient.search(searchRequest,RequestOptions.DEFAULT);
            SoftReference<String> stringSoftReference = new SoftReference<>("123");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
