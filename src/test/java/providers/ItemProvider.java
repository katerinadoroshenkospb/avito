package providers;

import constants.ApiServicePath;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import models.CreateItem;

import static io.restassured.RestAssured.given;

/**
 * Класс, используемый для отправки запросов, связанных с Item
 */
public class ItemProvider {

    /**
     * Отправить POST /api/1/item для создания объявления
     *
     * @param item создаваемое объявление
     * @return полученный ответ от сервиса
     */
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

    /**
     * Отправить GET /api/1/item/{id} для получения объявления
     *
     * @param id ID получаемого объявления
     * @return полученный ответ от сервиса
     */
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

    /**
     * Отправить GET /GET /api/1/{sellerID}/item для получения объявлений указанного продавца
     *
     * @param sellerId ID продавца
     * @return полученный ответ от сервиса
     */
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
