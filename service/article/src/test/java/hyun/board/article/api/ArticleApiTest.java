package hyun.board.article.api;

import hyun.board.article.service.request.ArticleCreateRequest;
import hyun.board.article.service.response.ArticleResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClient;

public class ArticleApiTest {
    RestClient restClient = RestClient.create("http://localhost:9000");

    @Test
    void createTest(){
        ArticleResponse articleResponse = create(new ArticleCreateRequest(
                "hi", "my content", 1L, 1L
        ));
        System.out.println("articleResponse = " + articleResponse);
    }

    ArticleResponse create(ArticleCreateRequest request){
        return restClient.post()
                .uri("/v1/articles")
                .body(request)
                .retrieve()
                .body(ArticleResponse.class);
    }

//    @Test
//    void readTest(){
//        read()
//    }

    ArticleResponse read(ArticleCreateRequest request){
        return restClient.get()
                .uri("/v1/articles")
                .retrieve()
                .body(ArticleResponse.class);
    }


    @Getter
    @AllArgsConstructor
    static class ArticleCreateRequest {
        private String title;
        private String content;
        private Long writerId;
        private Long boardId;
    }

    @Getter
    static class ArticleUpdateRequest {
        private String title;
        private String content;
    }

}
