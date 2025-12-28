package providers;

import constants.ApiServicePath;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import models.Item;

import static io.restassured.RestAssured.given;

/**
 *
 * Класс, используемый для отправки запросов, связанных со статистикой объявления
 */
public class StatisticProvider {

    @Getter
    private static List<Item> itemList = new ArrayList<>();

    /**
     * Отправить GET /api/1/statistic/{id} для получения статистики по объявлению
     *
     * @param id ID объявления
     * @return полученный ответ от сервиса
     */
    public static ValidatableResponse sendGetRequestId(String id) {
        return given()
                .baseUri(ApiServicePath.BASE_URL)
                .basePath(ApiServicePath.GET_STATISTIC_BY_ID)
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then();
    }
}
