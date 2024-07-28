package org.fastcampus.community_feed.acceptance.post;

import io.restassured.RestAssured;
import java.util.List;
import org.fastcampus.community_feed.post.application.dto.CreatePostRequestDto;
import org.fastcampus.community_feed.post.application.dto.GetPostContentResponseDto;
import org.springframework.http.MediaType;

public class FeedAcceptanceSteps {

    // io.restassured.response.Response
    public static Long requestCreatePost(CreatePostRequestDto dto) {
        return RestAssured
                .given().log().all()
                .body(dto)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .post("/post")
                .then().log().all()
                .extract()
                .jsonPath()
                .getObject("value", Long.class);
    }

    public static List<GetPostContentResponseDto> requestFeedList(Long requestUserId) {
        return RestAssured
                .given().log().all()
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .get("/feed/{userId}", requestUserId)
                .then().log().all()
                .extract()
                .jsonPath()
                .getList("value", GetPostContentResponseDto.class);
    }
}
