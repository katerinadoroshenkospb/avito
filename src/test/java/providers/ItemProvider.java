package providers;

import constants.ApiServicePath;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.CreateItem;

import static io.restassured.RestAssured.given;

public class ItemProvider {
    public static ValidatableResponse sendPostRequest(CreateItem item) {
        return given()
                .baseUri(ApiServicePath.BASE_URL)
                .basePath(ApiServicePath.CREATE_ITEM)
                .contentType(ContentType.JSON)
                .body(item)
                .when()
                .post()
                .then();
    }

    public static ValidatableResponse sendGetRequest(String id) {
        return given()
                .baseUri(ApiServicePath.BASE_URL)
                .basePath(ApiServicePath.GET_ITEM_BY_ID)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then();
    }

    public static ValidatableResponse sendGetRequestSellerId(Integer sellerId) {
        return given()
                .baseUri(ApiServicePath.BASE_URL)
                .basePath(ApiServicePath.GET_ITEM_BY_SELLER_ID)
                .pathParam("sellerID", sellerId)
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then();
    }
}
